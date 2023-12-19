package com.example.camview_example

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.camview_example.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun lineGraph(view: View) {
        val intent = Intent(this, LineGraphActivity::class.java)
        startActivity(intent)
    }
    fun barGraph(view: View) {
        val intent = Intent(this, BarGraphActivity::class.java)
        startActivity(intent)
    }
    fun pieGraph(view: View) {
        val intent = Intent(this, PieGraphActivity::class.java)
        startActivity(intent)
    }
}