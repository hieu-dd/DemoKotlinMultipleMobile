package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.Greeting
import android.widget.TextView
import com.example.kmm.ProductsManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private val productsManager = ProductsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
        tv.text = "Loading..."
        GlobalScope.launch {

            productsManager.getProductsFlow().collectIndexed { index, value ->
                runOnUiThread {
                    tv.text = value.size.toString()
                }
            }
        }
        GlobalScope.launch {
            delay(2000)
            productsManager.search("11")
        }
    }
}
