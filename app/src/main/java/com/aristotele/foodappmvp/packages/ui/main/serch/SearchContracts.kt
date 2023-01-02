package com.aristotele.foodappmvp.packages.ui.main.serch

import com.aristotele.foodappmvp.base.BaseView
import com.aristotele.foodappmvp.packages.data.model.home.ResponseMoviesList


interface SearchContracts {

    interface View : BaseView {
        fun loadSearchData(data: ResponseMoviesList)
    }

    interface Presenter {
        fun callSearch(search: String)
    }
}