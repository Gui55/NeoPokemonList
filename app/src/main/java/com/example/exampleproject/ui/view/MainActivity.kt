package com.example.exampleproject.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleproject.R
import com.example.exampleproject.services.model.PokePageResult
import com.example.exampleproject.services.repository.repoModule
import com.example.exampleproject.services.webservices.Requisitions
import com.example.exampleproject.services.webservices.retroModules
import com.example.exampleproject.ui.adapter.SimpleResultsAdapter
import com.example.exampleproject.viewmodel.MainViewModel
import org.koin.core.context.startKoin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initKoin()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initRecyclerView()
        observations()
    }

    private fun initKoin() {
        startKoin{
            modules(retroModules, repoModule)
        }
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.simple_results_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observations() {
        viewModel.pageResults.observe(this, Observer {
            recyclerView.adapter = SimpleResultsAdapter(it, this)
        })
    }
}