package com.example.exampleproject.services.repository

import org.koin.dsl.module

val repoModule = module {
    single { ResultsRepository() }
}