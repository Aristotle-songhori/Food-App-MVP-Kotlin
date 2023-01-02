package com.aristotele.foodappmvp.retrofit.ui.home

import com.aristotele.foodappmvp.base.BasePresenter
import com.aristotele.foodappmvp.base.BaseView
import com.aristotele.foodappmvp.retrofit.data.model.home.ResponseCategoriesList
import com.aristotele.foodappmvp.retrofit.data.model.home.ResponseFoodsList


interface HomeContracts {
    interface View : BaseView {
        fun loadFoodRandom(data: ResponseFoodsList)
        fun loadCategories(data: ResponseCategoriesList)
        fun loadFoodsList(data: ResponseFoodsList)
        fun foodsLoadingState(isShown: Boolean)
        fun emptyList()
    }

    interface Presenter : BasePresenter {
        fun callFoodRandom()
        fun callCategoriesList()
        fun callFoodsList(letter: String)
        fun callSearchFood(letter: String)
        fun callFoodsByCategory(letter: String)
    }
}