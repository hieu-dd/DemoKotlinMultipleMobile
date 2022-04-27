package com.example.kmm.android

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmm.AuthManager

@Composable
fun LoginScreen(navController: NavController, authManager: AuthManager) {

    val context = LocalContext.current
    Surface {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Scaffold {
            Column() {
                TextField(
                    value = username,
                    onValueChange = {
                        username = it
                    })
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                    })
                TextButton(onClick = {
                    if (authManager.login(username, password)) {
                        navController.navigate("products")
                    } else {
                        Toast.makeText(context, "Invalid username or password", Toast.LENGTH_LONG).show()
                    }
                }) {
                    Text("Signin")
                }
            }
        }
    }
}