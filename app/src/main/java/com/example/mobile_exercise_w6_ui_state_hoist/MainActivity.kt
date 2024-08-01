package com.example.mobile_exercise_w6_ui_state_hoist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_exercise_w6_ui_state_hoist.ui.theme.Mobile_Exercise_W6_UI_State_HoistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.google), contentDescription = "Logo Google")
        Spacer(modifier = Modifier.height(30.dp))


        Row {
            Image(
                painter = painterResource(id = R.drawable.youtube),
                contentDescription = "Image",
                modifier = Modifier
                    .size(200.dp)
                    .background(color = Color.Unspecified)
            )
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Twiter",
                modifier = Modifier
                    .size(200.dp)
                    .background(color = Color.Unspecified)
            )
        }

        var handout by remember {
            mutableStateOf("")
        }

        var forgot by remember {
            mutableStateOf("")
        }

        Text(
            text = forgot
        )
        OutlinedTextField(
            value = handout,
            onValueChange = { handout = it },
            textStyle = TextStyle(color = Color.Black),
            label = { Text(text = "Input here", fontSize = 15.sp) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 20.dp)
        )

        Button(
            onClick = {
                forgot = handout
            },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
        ) {
            Text(text = "Fill text")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobile_Exercise_W6_UI_State_HoistTheme {
        Greeting()
    }
}