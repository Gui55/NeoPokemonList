package com.example.exampleproject.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.exampleproject.R
import com.example.exampleproject.services.model.PokePageResult
import com.example.exampleproject.services.webservices.Requisitions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var requisitions = retrofit.create(Requisitions::class.java)

        requisitions.getPageResult().enqueue(object: Callback<PokePageResult>{
            override fun onFailure(call: Call<PokePageResult>, t: Throwable) {
                Log.d("AN ERROR", t.message.toString())
            }

            override fun onResponse(call: Call<PokePageResult>, response: Response<PokePageResult>) {

                var r = response.body()!!

                Log.d("RESPONSE", "count "+r.count.toString()+" next "+r.next.toString()+" previous "+r.previous.toString())

                for(i in r.results){
                    Log.d("RESULTS", "name "+i.name+" url "+i.url)
                }
            }

        })
    }
}