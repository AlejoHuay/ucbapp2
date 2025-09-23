package com.calyrsoft.ucbapp.features.github.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.calyrsoft.ucbapp.R

@Composable
fun GithubUI() {
    var alias by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column( horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = alias,
                onValueChange = {
                    alias = it
                },
                label = {
                    Text(stringResource(id = R.string.gitalias_input))
                }
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(stringResource(id = R.string.gitalias_btn_find))
            }

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = ""
            )
        }
    }
}
