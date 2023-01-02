package com.aristotele.foodappmvp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers



//اکستنشن های نوشته شده خومون هست

//این نوشتیم برای درخواست رتروفیت دیگه هی تکرار نکنیم این بخش رو
//RxJava
fun <T : Any> Single<T>.applyScheduler(scheduler: Scheduler): Single<T> =
    subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())


//اینم یه مدل دیگه با io هست
fun <T : Any> Single<T>.applyIoScheduler() = applyScheduler(Schedulers.io())



//اینم برای کنترل اینترنت نوشتیم
//Check network
fun Context.isNetworkAvailable(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = cm.activeNetworkInfo
    return info != null && info.isConnected
}



///اینم پیام نشون میده تو اسنکبار
//SnackBar
fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}