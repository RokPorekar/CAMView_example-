package com.example.camview_example

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.echo.holographlibrary.Bar
import com.example.camview_example.databinding.ActivityBarGraphBinding
import com.google.android.material.snackbar.Snackbar


class BarGraphActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBarGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        graph()
        binding.graph.setOnBarClickedListener { index ->
            val selectedBar = binding.graph.bars[index]
            val value = selectedBar.valueString
            Toast.makeText(this@BarGraphActivity, "Clicked Bar Value: $value", Toast.LENGTH_SHORT)
                .show()
        }
    }
    private fun graph(){

        val points = ArrayList<Bar>()
        val d = Bar()
        d.color = Color.parseColor("#99CC00")
        d.name = "Test1"
        d.value = 10f
        val d2 = Bar()
        d2.color = Color.parseColor("#FFBB33")
        d2.name = "Test2"
        d2.value = 20f
        points.add(d)
        points.add(d2)

        val g = binding.graph
        g.bars = points
    }

    fun graph(view: View) {
        if(binding.editTextBarName1.text.isBlank() || binding.editTextBarValue1.text.isBlank() || binding.editTextBarName2.text.isBlank() || binding.editTextBarValue2.text.isBlank()){
            Snackbar.make(binding.root, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            return
        }
        val points = ArrayList<Bar>()
        val d = Bar()
        d.color = Color.parseColor("#99CC00")
        d.name = binding.editTextBarName1.text.toString()
        d.value = binding.editTextBarValue1.text.toString().toFloat()
        val d2 = Bar()
        d2.color = Color.parseColor("#FFBB33")
        d2.name = binding.editTextBarName2.text.toString()
        d2.value = binding.editTextBarValue2.text.toString().toFloat()
        points.add(d)
        points.add(d2)

        val g = binding.graph
        g.bars = points
        g.setShowAxis(false)
        g.setShowAxisLabel(true)
        g.setShowBarText(false)
        binding.editTextBarName1.text.clear()
        binding.editTextBarName2.text.clear()
        binding.editTextBarValue1.text.clear()
        binding.editTextBarValue2.text.clear()
    }
}