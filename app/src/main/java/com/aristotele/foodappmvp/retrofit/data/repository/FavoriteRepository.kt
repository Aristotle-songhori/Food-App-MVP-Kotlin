package com.aristotele.foodappmvp.retrofit.data.repository


import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val dao: FoodDao) {
    fun loadAllFoods() = dao.getAllFoods()
}