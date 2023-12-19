package com.example.camview_example

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.echo.holographlibrary.Line
import com.echo.holographlibrary.LineGraph
import com.echo.holographlibrary.LinePoint
import com.example.camview_example.databinding.ActivityLineGraphBinding


class LineGraphActivity : AppCompatActivity() {
    lateinit var binding: ActivityLineGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLineGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        graph()
    }
    private fun graph(){

        val l = Line()
        var p = LinePoint()
        p.x = 0f
        p.y = 5f
        l.addPoint(p)
        p = LinePoint()
        p.x = 8f
        p.y = 8f
        l.addPoint(p)
        p = LinePoint()
        p.x = 10f
        p.y = 4f
        l.addPoint(p)
        l.color = Color.parseColor("#FFBB33")

        val li = binding.graph
        li.addLine(l)
        li.setRangeY(0f, 10f)
        li.lineToFill = 0
    }
}