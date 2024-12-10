import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import view.gameScreen
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*



@Composable
@Preview
fun app(){
    gameScreen()
}


fun main() = application {



    Window(
        onCloseRequest = ::exitApplication,
        title = "SiGame",
        state = WindowState(width = 1920.dp, height = 1080.dp),
        icon = painterResource("icon.png")
        )
    {
        app()
    }
    

    
}
