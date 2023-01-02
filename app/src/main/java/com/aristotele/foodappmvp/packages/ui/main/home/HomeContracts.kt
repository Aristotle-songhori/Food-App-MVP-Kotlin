package com.aristotele.foodappmvp.packages.ui.main.home


import com.aristotele.foodappmvp.base.BaseView
import com.aristotele.foodappmvp.packages.data.model.home.ResponseMoviesList

interface HomeContracts {
    interface View : BaseView {
        fun loadTopMovies(data: ResponseMoviesList)
        fun loadCategories()
        fun loadLastMovies()
    }

    interface Presenter {
        fun callTopMovies()
        fun callCategories()
        fun callLastMovies()
    }
}