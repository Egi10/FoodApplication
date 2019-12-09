package com.example.foodapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapplication.R
import com.example.foodapplication.network.handling.Resource
import com.example.foodapplication.network.handling.Status
import com.example.foodapplication.network.model.Response
import com.example.foodapplication.ui.adapter.FoodAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    //Inject
    private val mainViewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(mainViewModel) {
            getCategory().observe(this@MainActivity, Observer<Resource<Response>> {
                when(it.status) {
                    Status.SHOWLOADING -> {
                        Log.d("Sukses", "Loading")
                    }

                    Status.SUCCESS -> {
                        val listData = it.data

                        val foodAdapter = listData?.categories?.let { it1 ->
                            FoodAdapter(it1) {

                            }
                        }
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                        recyclerView.adapter = foodAdapter
                    }

                    Status.ERROR -> {
                        Log.d("Sukses", "Error")
                    }

                    Status.HIDELOADING -> {
                        Log.d("Sukses", "Hide")
                    }

                    else -> {
                        Log.d("Sukses", "Error")
                    }
                }
            })
        }
    }
}
