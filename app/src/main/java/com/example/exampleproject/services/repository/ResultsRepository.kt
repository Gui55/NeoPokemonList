package com.example.exampleproject.services.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.exampleproject.services.model.PokePageResult
import com.example.exampleproject.services.model.SimplePokeResults
import com.example.exampleproject.services.webservices.Requisitions
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ResultsRepository : KoinComponent {

    //Instância do Retrofit e a interface de requisições
    val retrofit: Retrofit by inject()
    var requisitions = retrofit.create(Requisitions::class.java)

    fun getSimplePageResults() : MutableLiveData<List<SimplePokeResults>>{
        val results = MutableLiveData<List<SimplePokeResults>>()

        requisitions.getPageResult().enqueue(object: Callback<PokePageResult>{
            override fun onFailure(call: Call<PokePageResult>, t: Throwable) {
                Log.d("ERROR", t.message.toString())
            }

            override fun onResponse(call: Call<PokePageResult>, response: Response<PokePageResult>) {
                results.value = response.body()!!.results
            }

        })

        return results
    }

}