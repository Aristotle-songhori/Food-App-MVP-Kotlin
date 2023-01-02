package com.aristotele.foodappmvp.retrofit.ui.home


import com.aristotele.foodappmvp.base.BasePresenterImpl
import com.aristotele.foodappmvp.retrofit.data.repository.HomeRepository
import com.aristotele.foodappmvp.utils.applyIoScheduler
import javax.inject.Inject

class HomePresenter @Inject constructor(private val repository: HomeRepository, val view: HomeContracts.View) :
    BasePresenterImpl(), HomeContracts.Presenter {

    override fun callFoodRandom() {

        //اول چک میکنیم اینترنت وصله یا نه
        if (view.checkInternet()) {

            //یه اکستنشن مینویسیم راحت در یوتیل

            disposable = repository.loadFoodRandom()
                .applyIoScheduler() // اینو خودمون نوشتیم اکستنشن هست با آر ایکس جاوا که مش تکراری ننویسیم
                .subscribe({ response ->
                    when (response.code()) {
                        //رنج ارور ها رو دسته بندی میکنه
                        in 200..202 -> {
                            //حالا که جواب درست اومده ببین اگر بادیییییی خالی نیست لود کن رندم رو
                            response.body()?.let {
                                view.loadFoodRandom(it)
                            }
                        }
                        422 -> {

                        }
                        in 400..499 -> {

                        }
                        in 500..599 -> {

                        }
                    }

                }, {
                    view.serverError(it.message.toString())
                })
        } else {
            view.internetError(false)
        }
    }

    override fun callCategoriesList() {
        if (view.checkInternet()) {
            view.showLoading()
            disposable = repository.loadCategoriesList()
                .applyIoScheduler()
                .subscribe({ response ->
                    view.hideLoading()
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.categories.isNotEmpty()) {
                                    view.loadCategories(it)
                                }
                            }
                        }
                    }

                }, {
                    view.hideLoading()
                    view.serverError(it.message.toString())
                })
        } else {
            view.internetError(false)
        }
    }

    override fun callFoodsList(letter: String) {
        if (view.checkInternet()) {
            view.foodsLoadingState(true)
            disposable = repository.loadFoodsList(letter)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.foodsLoadingState(false)
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.meals!!.isNotEmpty()) {
                                    view.loadFoodsList(it)
                                }
                            }
                        }
                    }

                }, {
                    view.foodsLoadingState(false)
                    view.serverError(it.message.toString())
                })
        } else {
            view.internetError(false)
        }
    }

    override fun callSearchFood(letter: String) {
        if (view.checkInternet()) {
            view.foodsLoadingState(true)
            disposable = repository.loadSearchFood(letter)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.foodsLoadingState(false)
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let { itBody ->
                                if (itBody.meals != null) {
                                    if (itBody.meals.isNotEmpty()) {
                                        view.loadFoodsList(itBody)
                                    }
                                } else {
                                    view.emptyList()
                                }
                            }
                        }
                    }

                }, {
                    view.foodsLoadingState(false)
                    view.serverError(it.message.toString())
                })
        } else {
            view.internetError(false)
        }
    }

    override fun callFoodsByCategory(letter: String) {
        if (view.checkInternet()) {
            view.foodsLoadingState(true)
            disposable = repository.loadFoodsByCategory(letter)
                .applyIoScheduler()
                .subscribe({ response ->
                    view.foodsLoadingState(false)
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                if (it.meals!!.isNotEmpty()) {
                                    view.loadFoodsList(it)
                                }
                            }
                        }
                    }

                }, {
                    view.foodsLoadingState(false)
                    view.serverError(it.message.toString())
                })
        } else {
            view.internetError(false)
        }
    }
}