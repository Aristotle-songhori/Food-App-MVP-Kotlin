package com.aristotele.foodappmvp.retrofit.ui.detail


import com.aristotele.foodappmvp.base.BasePresenter
import com.aristotele.foodappmvp.base.BaseView
import com.aristotele.foodappmvp.retrofit.data.database.FoodEntity
import com.aristotele.foodappmvp.retrofit.data.model.home.ResponseFoodsList

interface DetailContracts {
    interface View : BaseView {
        fun loadDetail(data: ResponseFoodsList)
        fun updateFavorite(isAdded: Boolean)
    }

    interface Presenter : BasePresenter {
        fun callDetailApi(id: Int)
        fun saveFood(entity: FoodEntity)
        fun deleteFood(entity: FoodEntity)
        fun checkFavorite(id: Int)
    }
}