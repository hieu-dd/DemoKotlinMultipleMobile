package com.example.kmm.android

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kmm.AuthManager
import com.example.kmm.Greeting

@Composable
fun LoginScreen(navController: NavController, authManager: AuthManager) {

    val context = LocalContext.current
    Surface {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var rememberMe by remember { mutableStateOf(false) }

        Scaffold {
            Column(
                modifier = Modifier.padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    Greeting().greeting(),
                    style = TextStyle(fontSize = 32.sp)
                )
                Spacer(modifier = Modifier.weight(1F))
                TextField(
                    value = username,
                    onValueChange = {
                        username = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Username")
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Password")
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                    Text("Remember me")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    onClick = {
                        if (authManager.login(username, password, rememberMe)) {
                            navController.navigate("products")
                        } else {
                            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_LONG).show()
                        }
                    }) {
                    Text("Signin")
                }
                Spacer(modifier = Modifier.weight(2F))
            }
        }
    }
}