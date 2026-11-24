package com.example.alisonxmldemo

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.alisonxmldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val nameList = ArrayList<String>()
    val imageList = ArrayList<Int>()
    lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        gridView = binding.gridView
        fillArrays()
        val adapter = AnimalsAdapter(this, nameList, imageList)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val selectedAnimal = nameList[position]
            Toast.makeText(this@MainActivity, "You selected $selectedAnimal", Toast.LENGTH_SHORT).show()
        }
    }

    fun fillArrays() {
        nameList.add("Lion")
        nameList.add("Tiger")
        nameList.add("Elephant")
        nameList.add("Giraffe")
        nameList.add("Wolf")
        nameList.add("Fox")
        nameList.add("Bear")
        nameList.add("Rabbit")
        nameList.add("Dolphin")

        imageList.add(R.drawable.lion)
        imageList.add(R.drawable.tiger)
        imageList.add(R.drawable.elephant)
        imageList.add(R.drawable.giraffe)
        imageList.add(R.drawable.wolf)
        imageList.add(R.drawable.fox)
        imageList.add(R.drawable.bear)
        imageList.add(R.drawable.rabbit)
        imageList.add(R.drawable.dolphin)
    }

}