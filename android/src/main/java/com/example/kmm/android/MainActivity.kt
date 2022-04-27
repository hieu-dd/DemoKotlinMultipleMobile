package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.Greeting
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.kmm.AuthManager
import com.example.kmm.CartManager
import com.example.kmm.utils.Extension.formatMoney
import com.example.kmm.ProductsManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authManager = AuthManager(context = application!!)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = if (authManager.isLogin()) "products" else "login"
            ) {
                composable("login") {
                    LoginScreen(navController = navController, authManager = authManager)
                }
                composable("products") {
                    ProductScreen(
                        navController = navController,
                        productsManager = ProductsManager,
                        cartManager = CartManager
                    )
                }
                composable("cart") {

                }
            }
        }
    }
}