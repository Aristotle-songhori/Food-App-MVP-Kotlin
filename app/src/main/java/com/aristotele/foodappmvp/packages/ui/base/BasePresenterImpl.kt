package com.aristotele.foodappmvp.packages.ui.base

import androidx.annotation.NonNull
import io.reactivex.rxjava3.disposables.Disposable

class BasePresenterImpl : BasePresenter {

    var disposable: Disposable? = null

    override fun onStop() {
        disposable?.let {
            it.dispose()
        }
    }
}