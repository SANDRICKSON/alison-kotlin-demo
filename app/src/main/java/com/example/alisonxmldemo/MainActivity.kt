package com.example.alisonxmldemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alisonxmldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater) }
    lateinit var recyclerView: RecyclerView
    var countryNameList = ArrayList<String>()
    var detailsList = ArrayList<String>()
    var imageList = ArrayList<Int>()
    lateinit var adapter: CountriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        countryNameList.add("UK")
        countryNameList.add("USA")
        countryNameList.add("Germany")

        detailsList.add("This is UK")
        detailsList.add("This is USA")
        detailsList.add("This is Germany")

        imageList.add(R.drawable.uk)
        imageList.add(R.drawable.usa)
        imageList.add(R.drawable.germany)

        adapter = CountriesAdapter(countryNameList,detailsList,imageList,this@MainActivity)
        recyclerView.adapter = adapter
    }

}