package com.app.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                Surface(color = MaterialTheme.colors.background) {
                    Greeting(Message("Android", "Utsav"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun Greeting(msg: Message) {
    Row(modifier = Modifier.padding(all = 15.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_kid_outside),
            contentDescription = "Profile Pic",
            modifier = Modifier
                .size(40.dp)
                .border(1.5.dp, MaterialTheme.colors.primaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(3.dp))
        Column {
            Text(
                text = "Hello ${msg.author}!",
     /*           fontSize = 50.sp,
                fontWeight = FontWeight.Bold,*/
                color = MaterialTheme.colors.secondaryVariant,
                textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.subtitle2
            )

            Surface(shape = MaterialTheme.shapes.medium, elevation = 6.dp) {
                Text(
                    text = msg.body,
                    color= MaterialTheme.colors.primary,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }

            Text(text = msg.body)
        }

    }

}

@Preview(name = "Light Mode",showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting(Message("Android", "Utsav"))
    }
}
