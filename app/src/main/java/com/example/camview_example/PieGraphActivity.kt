package com.example.camview_example

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.echo.holographlibrary.PieSlice
import com.example.camview_example.databinding.ActivityPieGraphBinding


class PieGraphActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPieGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPieGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        graph()
    }
    private fun graph(){

        val pg = binding.graph
        var slice = PieSlice()
        slice.color = Color.parseColor("#99CC00")
        slice.value = 2f
        pg.addSlice(slice)
        slice = PieSlice()
        slice.color = Color.parseColor("#FFBB33")
        slice.value = 3f
        pg.addSlice(slice)
        slice = PieSlice()
        slice.color = Color.parseColor("#AA66CC")
        slice.value = 8f
        pg.addSlice(slice)
    }
}