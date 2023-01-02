package com.aristotele.foodappmvp.packages.ui.main.favorites

interface FavoriteContracts {

    interface View {
        fun emptyList()
        fun loadFavoritesData()
    }

    interface Presenter {
        fun getFavoritesList()
    }

}