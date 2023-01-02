package com.aristotele.foodappmvp.retrofit.ui.favorite


import com.aristotele.foodappmvp.base.BasePresenter
import com.aristotele.foodappmvp.retrofit.data.database.FoodEntity

interface FavoriteContracts {
    interface View {
        fun showAllFoods(list: MutableList<FoodEntity>)
    }

    interface Presenter : BasePresenter {
        fun loadAllFood()
    }
}