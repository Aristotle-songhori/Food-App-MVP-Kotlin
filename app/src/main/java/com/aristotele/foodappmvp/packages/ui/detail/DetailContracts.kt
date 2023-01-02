package com.aristotele.foodappmvp.packages.ui.detail

interface DetailContracts {

    interface View {
        fun loadDetailData()
        fun saveState()
        fun emptyList()
    }

    interface Presenter {
        fun callDetailPage(id: Int)
        fun saveFavorite()
    }
}