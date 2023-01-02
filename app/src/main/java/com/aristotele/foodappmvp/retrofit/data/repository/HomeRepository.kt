package com.aristotele.foodappmvp.retrofit.data.repository


import com.aristotele.foodappmvp.retrofit.data.server.ApiServices
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: ApiServices) {
    fun loadFoodRandom() = api.foodRandom()
    fun loadCategoriesList() = api.categoriesList()
    fun loadFoodsList(letter: String) = api.foodsList(letter)
    fun loadSearchFood(letter: String) = api.searchFood(letter)
    fun loadFoodsByCategory(letter: String) = api.foodsByCategory(letter)
}