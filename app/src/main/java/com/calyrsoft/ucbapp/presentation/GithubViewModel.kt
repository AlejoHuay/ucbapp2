package com.calyrsoft.ucbapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calyrsoft.ucbapp.domain.model.UserModel
import com.calyrsoft.ucbapp.domain.usecase.FindByNickNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GithubViewModel(
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
}