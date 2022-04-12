package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.kmm.ProductsManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val productsManager = ProductsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(productsManager = productsManager)
        }
    }
}

@Composable
fun MainScreen(
    productsManager: ProductsManager,
) {
    val products = productsManager.getProductsFlow().collectAsState()
    Surface() {
        Scaffold(
            topBar = {
                Text(Greeting().greeting())
            }
        ) {
            Column() {
                val searchText = remember {
                    mutableStateOf("")
                }
                TextField(
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                        productsManager.search(it)
                    })
                products.value.forEach {
                    Text("Sku: ${it.sku}")
                }
            }
        }
    }
}
