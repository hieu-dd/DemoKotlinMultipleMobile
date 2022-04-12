package com.example.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmm.Greeting
import android.widget.TextView
import kotlinx.coroutines.runBlocking

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
        tv.text = "Loading..."
        runBlocking {
            kotlin.runCatching {
                Greeting().getHtml()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }
    }
}
