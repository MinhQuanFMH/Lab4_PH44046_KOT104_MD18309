package com.example.lab4kot_ph44046

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4kot_ph44046.ui.theme.Lab4KOT_PH44046Theme


class Bai1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4KOT_PH44046Theme {
                LoginScreen()
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    Lab4KOT_PH44046Theme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                TextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text(text = "UserName") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp)) // Thêm khoảng cách giữa các TextField
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            painterResource(id = R.drawable.ic_visibility)
                        else
                            painterResource(id = R.drawable.ic_visibility_off)

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(modifier = Modifier.width(20.dp),painter = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp)) // Thêm khoảng cách giữa TextFields và Button
            Button(
                onClick = {
                    if (userName.isEmpty()||password.isEmpty()){
                        Toast.makeText(context, "Enter userName $userName password $password", Toast.LENGTH_LONG).show()
                    }else Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green, // Đổi màu nền của nút
                    contentColor = Color.White // Đổi màu chữ của nút
                ),
                modifier = Modifier
                    .width(150.dp) // Độ rộng của nút
                    .align(Alignment.CenterHorizontally) // Căn giữa nút
            ) {
                Text(text = "Login")
            }
        }
    }
}