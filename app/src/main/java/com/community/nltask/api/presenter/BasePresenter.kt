package com.community.nltask.api.presenter

import android.content.Context
import com.community.nltask.api.views.IAppView
import retrofit2.Response

abstract class BasePresenter<I : IAppView> {
    var view: I? = null
        set(value) {
            field = value
        }

    fun handleError(response: Response<*>, context: Context): Boolean {
        /*
         *
         * 400 Email Already Registered
         * 404 Not Found
         * 408 Request Timeout
         * 500 Internal Server Error
         * 502 Bad Gateway
         * 503 Service Unavailable
         * 504 Gateway Timeout
         * 598 Network Read Timeout
         * 599 Network Connect Timeout
         *
         * */
        if (response.code() == 400 || response.code() == 401 || response.code() == 404 || response.code() == 500
            || response.code() == 408 || response.code() == 503 || response.code() == 502
            || response.code() == 504 || response.code() == 598 || response.code() == 599) {
            val title: String = when (response.code()) {
                400 -> "Email Already Registered"
                401 -> "unauthorized Request"
                404 -> "Not Found"
                408 -> "Request Timeout"
                500 -> "Internal Server Error"
                502 -> "Bad Gateway"
                503 -> "Service Unavailable"
                504 -> "Gateway Timeout"
                598 -> "Network Read Timeout"
                599 -> "Network Connect Timeout"
                else -> ""
            }

            view?.onError(title)
            return true
        } else if (response.errorBody() != null) {
            try {
                val error: String? = response.errorBody()?.string()
                (if (response != null) error else null)?.let { view?.onError(it) }
            } catch (e: Exception) {
                e.printStackTrace()
                view?.onError(null)
            } finally {
                return true
            }
        }
        return false
    }
}
