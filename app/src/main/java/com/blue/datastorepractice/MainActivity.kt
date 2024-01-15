package com.blue.datastorepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        findViewById<Button>(R.id.btn).setOnClickListener {
            viewModel.addData()
        }
        viewModel.data.observe(this){
            findViewById<TextView>(R.id.txt).text = "$it"
        }
    }
}