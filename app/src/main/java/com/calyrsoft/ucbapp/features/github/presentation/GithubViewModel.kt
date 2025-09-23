package com.calyrsoft.ucbapp.features.github.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calyrsoft.ucbapp.features.github.domain.error.Failure
import com.calyrsoft.ucbapp.features.github.domain.model.UserModel
import com.calyrsoft.ucbapp.features.github.domain.usecase.FindByNickNameUseCase
import com.calyrsoft.ucbapp.features.github.presentation.error.ErrorMessageProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GithubViewModel(
    val usecase: FindByNickNameUseCase,
    val context: Context
): ViewModel() {
    sealed class GithubStateUI {
        object Init: GithubStateUI()
        object Loading: GithubStateUI()
        class Error(val message: String): GithubStateUI()
        class Success(val github: UserModel): GithubStateUI()
    }
    private val _state = MutableStateFlow<GithubStateUI>(GithubStateUI.Init)

    val state : StateFlow<GithubStateUI> = _state.asStateFlow()

    fun fetchAlias(nickname: String) {
        val errorMessageProvider = ErrorMessageProvider(context)

        viewModelScope.launch(Dispatchers.IO) {
            _state.value = GithubStateUI.Loading
            val result = usecase.invoke(nickname)

            result.fold(
                onSuccess = {
                        user -> _state.value = GithubStateUI.Success( user )
                },
                onFailure = {
                    val message = errorMessageProvider.getMessage(it as Failure)

                    _state.value = GithubStateUI.Error(message = message)
                }
            )
        }
    }

}

/*class GithubViewModel(
    val usecase: FindByNickNameUseCase
): ViewModel() {
    sealed class GithubStateUI { // siempre definimos una clase sellada tras definir un viewModel

        //Estados posibles de la interfaz que se extienden de la clase padre GithubStateUI
        object Init: GithubStateUI() // cuando el estado no tinene ningun atributo a gaurdar lo identificamos como un objeto
        object Loading: GithubStateUI()
        class Error(val message: String): GithubStateUI()
        class Success(val github: UserModel): GithubStateUI()
    }

    private val _state = MutableStateFlow<GithubStateUI>(GithubStateUI.Init) // variable mutable

    val state : StateFlow<GithubStateUI> = _state.asStateFlow() // variable observable

    fun fetchAlias(nickname: String){ // evento desecadenador que permite cambiar de estado a mi variable mutable
        viewModelScope.launch(Dispatchers.IO){
            _state.value = GithubStateUI.Loading
            val result = usecase.invoke(nickname)

            result.fold(
                onSuccess = {
                    user -> _state.value = GithubStateUI.Success(user)
                },
                onFailure = {
                    error -> _state.value = GithubStateUI.Error(message = error.message ?: "Error desconocido")
                }
            )
        }
    }
}*/
