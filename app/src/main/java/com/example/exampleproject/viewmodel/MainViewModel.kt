package com.example.exampleproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.exampleproject.services.model.SimplePokeResults
import com.example.exampleproject.services.repository.ResultsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {

    private val repository: ResultsRepository by inject()

    private val mutablePageResults = repository.getSimplePageResults()
    val pageResults : LiveData<List<SimplePokeResults>> = mutablePageResults

}