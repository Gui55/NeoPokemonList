package com.example.exampleproject.services.model

data class PokePageResult(var count: Int, var next: String?,
                          var previous: String?, var results: List<SimplePokeResults>)