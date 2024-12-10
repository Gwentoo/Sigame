package view
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp




@Composable
fun mainScreen(){


    Button(modifier = Modifier.size(100.dp), onClick = {}){
        Text("Main")
    }
}