package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kmm.Extension.formatMoney
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    productsManager: ProductsManager,
) {
    val products = productsManager.getProductsFlow().collectAsState()
    Surface() {
        Scaffold(
            topBar = {
                TopAppBar() {
                    Text(Greeting().greeting())
                }
            },
            backgroundColor = Color.LightGray
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                val searchText = remember {
                    mutableStateOf("")
                }
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                        productsManager.search(it)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    )
                )
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    modifier = Modifier.padding(top = 6.dp),
                ) {
                    items(products.value.size) { index ->
                        val product = products.value[index]
                        Column(
                            modifier = Modifier
                                .padding(1.dp)
                                .background(Color.White)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter("https://lh3.googleusercontent.com/vFpAXTtQzObGSHYwdMxAgKzs-gsV_eY3iRVZdP4Ig85SHDGR_SwRHojaBpEWfPaNs99p5un5iqF_ZaAsvA=rw-w300"),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth()
                                    .height(100.dp)
                            )
                            Text(product.productInfo.name)
                            Text(formatMoney(1000.0))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    MainScreen(productsManager = ProductsManager)
}