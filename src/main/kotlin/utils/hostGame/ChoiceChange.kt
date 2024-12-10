package utils.hostGame
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun choiceChangeDialog(
    onDismiss: () -> Unit,
    showDialog: Boolean,
    onInputConfirmed: (String) -> Unit) {

    var userInput by remember { mutableStateOf("") }

    if (showDialog){

        Dialog(onDismiss,  title = "Выберите", icon = painterResource("icon.png")) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                    userInput = "change"
                    onInputConfirmed(userInput)
                    onDismiss()}){
                    Text("Изменить баллы")
                }

                Spacer(modifier = Modifier.height(5.dp))
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                    userInput = "add"
                    onInputConfirmed(userInput)
                    onDismiss()
                }){
                    Text("Добавить баллы")
                }

                Spacer(
                    modifier = Modifier.height(5.dp))
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                    userInput = "sub"
                    onInputConfirmed(userInput)
                    onDismiss()}){
                    Text("Вычесть баллы")
                }

            }
        }


    }

}

