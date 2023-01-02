package com.aristotele.foodappmvp.packages.ui.base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun isInternetAvailable(): Boolean
    fun showInternetError()
    fun showEmpty()
    fun showServerError(err: String)
    fun logoutUser()
}