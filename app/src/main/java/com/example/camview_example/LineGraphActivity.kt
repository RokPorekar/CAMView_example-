package com.example.camview_example

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.echo.holographlibrary.Line
import com.echo.holographlibrary.LinePoint
import com.example.camview_example.databinding.ActivityLineGraphBinding
import com.google.android.material.snackbar.Snackbar


class LineGraphActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLineGraphBinding
    private var clickedPoint: LinePoint? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLineGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        graph()
        binding.graph.setOnPointClickedListener { lineIndex, pointIndex ->
            val line = binding.graph.lines[lineIndex]
            clickedPoint = line.points[pointIndex]
            // Display the values (you can replace this with your preferred way of displaying values)
            Snackbar.make(
                binding.root,
                "Clicked Point: x=${clickedPoint?.getX()}, y=${clickedPoint?.getY()}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
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
        p = LinePoint()
        p.x = 25f
        p.y = 5f
        l.addPoint(p)
        l.color = Color.parseColor("#FFBB33")

        val li = binding.graph
        li.addLine(l)
        li.setRangeY(0f, 10f)
        li.lineToFill = 0
        li.setRangeX(0f,50f)
    }
    fun addPoint(view: View) {
        if(binding.editTextX.text.isBlank() || binding.editTextY.text.isBlank()){
            Snackbar.make(binding.root, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            return
        }
        val l = Line()
        val p = LinePoint()
        p.x = binding.editTextX.text.toString().toFloat()
        p.y = binding.editTextY.text.toString().toFloat()
        l.addPoint(p)
        l.strokeWidth = 20
        val li = binding.graph
        li.addLine(l)
        li.setRangeY(0f, binding.editTextY.text.toString().toFloat() + 4)
        li.lineToFill = -1
        li.setRangeX(0f, binding.editTextX.text.toString().toFloat() + 4)

        // Reset clicked point
        clickedPoint = null
        binding.editTextX.text.clear()
        binding.editTextY.text.clear()
    }
}