package com.example.lab2

import android.app.UiModeManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.adapter.FigureAdapter
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.FigureApi
import com.example.lab2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.BLACK
        val uiModeManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        uiModeManager.nightMode = UiModeManager.MODE_NIGHT_NO

        val recyclerView = binding.recyclerViewFigure
        recyclerView.layoutManager = LinearLayoutManager(this)

        val api = ApiClient.instance

        binding.searchButton.setOnClickListener {
            val searchQuery = binding.searchText.text.toString()
            val call = api.getFigures(searchQuery)
            call.enqueue(object : Callback<List<FigureApi>> {
                override fun onResponse(call: Call<List<FigureApi>>, response: Response<List<FigureApi>>) {
                    if (response.isSuccessful) {
                        val figures = response.body()
                        if (figures != null && figures.isNotEmpty()) {
                            println("HTTP ${response.body()}")
                            val adapter = FigureAdapter()
                            recyclerView.adapter = adapter
                            adapter.submitList(figures)
                        } else {
                            println("HTTP Response body is empty or invalid")
                        }
                    } else {
                        println("HTTP Failed to get historical figures: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<FigureApi>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "HTTP FAIL: ${t.message}", Toast.LENGTH_LONG).show()
                    println("HTTP Failed to get historical figures: ${t.message}")
                }
            })
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}