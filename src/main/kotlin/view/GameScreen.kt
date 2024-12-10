package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
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
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import player.Player
import utils.hostGame.changeScoreDialog
import utils.hostGame.choiceChangeDialog


@Composable
fun gameScreen(){
    val nPlayers = 6

    var player1 by remember { mutableStateOf(Player("Ken Kaneki", "1.jpg", "100")) }
    var player2 by remember { mutableStateOf(Player("Otche  nash", "2.jpg", "1000")) }
    var player3 by remember { mutableStateOf(Player("zxcaratel 1000-7 next door", "3.jpg", "-3000")) }
    var player4 by remember { mutableStateOf(Player("123", "4.jpg", "42")) }
    var player5 by remember { mutableStateOf(Player("Sema Niveaman", "5.jpg", "564")) }
    var player6 by remember { mutableStateOf(Player("Jimmy Vrot", "6.jpg", "-10000")) }

    var listPlayers = listOf(player1, player2, player3, player4, player5, player6)
    var editMode by remember {mutableStateOf(false)}
    var showDialog by remember { mutableStateOf(false) }
    var changePlayer by remember { mutableStateOf(0) }
    var showChoice by remember { mutableStateOf(false) }
    var choiceChange by remember { mutableStateOf("") }

    choiceChangeDialog(
        showDialog = showChoice,
        onDismiss = {showChoice = false},
        onInputConfirmed = {input ->
            choiceChange = input
            showDialog = true
        }
    )

    changeScoreDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onInputConfirmed = { input ->
            if (choiceChange == "change"){
                listPlayers[changePlayer].score = input
            }
            if (choiceChange == "add"){
                listPlayers[changePlayer].score = (input.toInt() + listPlayers[changePlayer].score.toInt()).toString()
            }
            if (choiceChange == "sub"){
                listPlayers[changePlayer].score = (listPlayers[changePlayer].score.toInt() - input.toInt()).toString()
            }
            showDialog = false
        }
    )

    Column(modifier = Modifier.fillMaxSize()) {

    Row(modifier = Modifier.padding(5.dp).height(650.dp)) {
        Box(modifier = Modifier.height(650.dp).width(1975.dp).border(2.dp, color = Color.Black))
    }


    Row(modifier = Modifier.padding(5.dp).height(355.dp)) {
        Box(modifier = Modifier.height(355.dp).width(350.dp).border(2.dp, color = Color.Black)){
            Button(onClick = {editMode = !editMode}){
                Text("EditMode")
            }
        }
        Spacer(modifier = Modifier.width(5.dp))

        Row(
            modifier = Modifier
                .height(355.dp)
                .width(1560.dp)
                .border(2.dp, color = Color.Black)
                .padding(5.dp)
        ) {
            for (i in 0 until nPlayers) {
                Box(
                    modifier = Modifier
                        .width(((1560-((nPlayers - 1) * 5)) / (nPlayers)).dp)
                        .height(350.dp)
                        .border(2.dp, color = Color.Black))

                 {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                        ) {
                        Image(painter = painterResource(listPlayers[i].photo),
                            modifier = Modifier
                                .border(2.dp, Color.Black)
                                .height(232.dp)
                                .width(((1560-((nPlayers - 1) * 5)) / (nPlayers)).dp), contentDescription = "dfgd")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(listPlayers[i].name, fontSize = (18.sp), overflow = TextOverflow.Ellipsis, maxLines = 1)
                        Spacer(modifier = Modifier.height(15.dp))
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                    .clickable(enabled = editMode){
                                        changePlayer = i
                                        showChoice=true}



                                .fillMaxSize()
                                    .border(2.dp, Color.Black),
                            ){
                            Text(listPlayers[i].score, fontSize = 25.sp)
                        }
                    }

                }
                Spacer(modifier = Modifier.width(5.dp))

            }
        }
    }


}
}