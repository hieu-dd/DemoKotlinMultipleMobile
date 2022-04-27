package com.example.kmm.android

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.kmm.CartManager
import com.example.kmm.Greeting
import com.example.kmm.ProductsManager
import com.example.kmm.utils.Extension.formatMoney

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(
    navController: NavController,
    productsManager: ProductsManager,
    cartManager: CartManager,
) {
    val products = productsManager.getProductsFlow().collectAsState()
    val cart = cartManager.getCartFlow().collectAsState()
    Surface() {
        Scaffold {
            Column(modifier = Modifier.padding(8.dp)) {
                val searchText = remember {
                    mutableStateOf("")
                }
                Text(
                    Greeting().greeting(),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                )
                Text(text = cart.value.getTotalItems().toString())
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                        productsManager.search(it)
                    },
                    placeholder = {
                        Text(text = "Search products")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
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
                                .padding(bottom = 6.dp)
                                .background(Color.White)
                                .height(250.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(product.productInfo.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth()
                                    .height(100.dp)
                            )
                            Text(product.productInfo.name, maxLines = 2)
                            Box(modifier = Modifier.weight(1F)) {

                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    formatMoney(product.prices.firstOrNull()?.sellPrice ?: 0.0),
                                    color = Color.Red,
                                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                )
                                IconButton(onClick = { cartManager.addItem(product) }) {
                                    Icon(Icons.Rounded.AddShoppingCart, contentDescription = null)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}