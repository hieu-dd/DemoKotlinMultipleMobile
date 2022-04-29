package com.example.kmm.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.kmm.CartManager
import com.example.kmm.data.Dummy
import com.example.kmm.model.CartItem
import com.example.kmm.utils.Extension.formatMoney

@Composable
fun CartScreen(
    navController: NavController,
    cartManager: CartManager
) {
    val cart by cartManager.getCartFlow().collectAsState()
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Outlined.ChevronLeft, contentDescription = null)
                        }
                    },
                    title = {
                        Text("Giỏ hàng của tôi")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    backgroundColor = Color.White
                ) {
                    Spacer(modifier = Modifier.weight(1F))
                    Text("Tổng thanh toán: ")
                    Text(
                        text = formatMoney(cart.getPrice()),
                        style = TextStyle(fontSize = 20.sp, color = Color.Red)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = {}, modifier = Modifier.fillMaxHeight()) {
                        Text("  Mua hàng  ")
                    }
                }
            }
        ) {
            LazyColumn() {
                items(count = cart.items.size) { index ->
                    CartLineItem(cartItem = cart.items[index])
                }
            }
        }
    }
}

@Composable
fun CartLineItem(
    cartItem: CartItem,
) {
    Row(modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp)) {
        Image(
            painter = rememberAsyncImagePainter(cartItem.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(4.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp)
        ) {
            Text(cartItem.name)
            Spacer(modifier = Modifier.weight(1F))
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    formatMoney(cartItem.price),
                    color = Color.Red,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Text(cartItem.quantity.toString())
            }
        }
    }
}