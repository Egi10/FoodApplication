package com.example.foodapplication.ui

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapplication.R
import com.example.foodapplication.base.BaseActivity
import com.example.foodapplication.network.handling.Status
import com.example.foodapplication.network.model.CategoriesItem
import com.example.foodapplication.ui.adapter.FoodAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val mainViewModel by viewModel<MainViewModel>()
    private val list: MutableList<CategoriesItem> = mutableListOf()
    private lateinit var foodAdapter: FoodAdapter

    override fun contentView(): Int {
        return R.layout.activity_main
    }

    override fun initObservable() {
        with(mainViewModel) {
            response.observe(this@MainActivity, Observer {
                when(it.status) {
                    Status.SUCCESS -> {
                        val listData = it.data
                        listData?.categories?.let { listCategory ->
                            list.clear()
                            list.addAll(listCategory)
                            foodAdapter.notifyDataSetChanged()
                        }
                    }

                    Status.ERROR -> {
                        Log.d("Sukses", "Error")
                    }

                    else -> {
                        Log.d("Sukses", "Error")
                    }
                }
            })

            loading.observe(this@MainActivity, Observer {
                swipeRefresh.isRefreshing = it
            })
        }
    }

    override fun initView() {
        foodAdapter = FoodAdapter(list) {

        }
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = foodAdapter
    }
}
