package com.onedev.dicoding.dagger2implementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.dagger2implementation.adapter.RecyclerViewAdapter
import com.onedev.dicoding.dagger2implementation.databinding.ActivityMainBinding
import com.onedev.dicoding.dagger2implementation.model.RecyclerList

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = RecyclerViewAdapter()
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = adapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, {
            if (it != null) {
                adapter.setData(it.items)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error Getting Data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPiCall()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}