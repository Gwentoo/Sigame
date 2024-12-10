package utils.hostGame

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun changeScoreDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onInputConfirmed: (String) -> Unit
) {
    var userInput by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Введите число") },
            text = {
                TextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                )
            },
            confirmButton = {
                Button(onClick = {
                    onInputConfirmed(userInput)
                    onDismiss()
                }) {
                    Text("Подтвердить")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text("Отмена")
                }
            }
        )
    }
}