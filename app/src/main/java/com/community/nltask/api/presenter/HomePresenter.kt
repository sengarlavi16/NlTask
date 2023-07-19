package com.community.nltask.api.presenter

import android.content.Context
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.community.nltask.NlTaskApp
import com.community.nltask.api.models.City
import com.community.nltask.api.models.Countries
import com.community.nltask.api.models.Pincode
import com.community.nltask.api.models.States
import com.community.nltask.api.views.IMainView
import com.community.nltask.utils.NetworkCheck
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter: BasePresenter<IMainView>() {

    fun country(context: Context) {

        if (NetworkCheck.isConnected(context)) {

            view?.enableLoadingBar(context, true, "")
                NlTaskApp.getInstance().getApiService()?.getCountries()?.enqueue(object : Callback<Countries> {
                override fun onResponse(call: Call<Countries>, response: Response<Countries>) {
                    view?.enableLoadingBar(context, false, "")
                    try {
                        if (!handleError(response, context)) {
                            if (response.isSuccessful && response.code() == 200) {
                                response.body()?.let { view?.onCountrySuccess(it) }
                            } else {
                                Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show()
                            }
                        } else {
                            view?.onError(response.message())
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        view?.onError(e.message)
                    }
                }

                override fun onFailure(call: Call<Countries>, t: Throwable) {
                    try {
                        view?.enableLoadingBar(context, false, "")
                        t.printStackTrace()
                        view?.onError(t.message)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            })
        } else {
            internetNotAvailableMessage(context)
        }
    }

    fun city(context: Context, stateid : String) {

        if (NetworkCheck.isConnected(context)) {

            view?.enableLoadingBar(context, true, "")
            NlTaskApp.getInstance().getApiService()?.getCity(stateid)?.enqueue(object : Callback<City> {
                override fun onResponse(call: Call<City>, response: Response<City>) {
                    view?.enableLoadingBar(context, false, "")
                    try {
                        if (!handleError(response, context)) {
                            if (response.isSuccessful && response.code() == 200) {
                                response.body()?.let { view?.onCitySuccess(it) }
                            } else {
                                Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show()
                            }
                        } else {
                            view?.onError(response.message())
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        view?.onError(e.message)
                    }
                }

                override fun onFailure(call: Call<City>, t: Throwable) {
                    try {
                        view?.enableLoadingBar(context, false, "")
                        t.printStackTrace()
                        view?.onError(t.message)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            })
        } else {
            internetNotAvailableMessage(context)
        }
    }

    fun pincode(context: Context, cityid: String) {

        if (NetworkCheck.isConnected(context)) {

            view?.enableLoadingBar(context, true, "")
            NlTaskApp.getInstance().getApiService()?.getPincode(cityid)?.enqueue(object : Callback<Pincode> {
                override fun onResponse(call: Call<Pincode>, response: Response<Pincode>) {
                    view?.enableLoadingBar(context, false, "")
                    try {
                        if (!handleError(response, context)) {
                            if (response.isSuccessful && response.code() == 200) {
                                response.body()?.let { view?.onPinSuccess(it) }
                            } else {
                                Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show()
                            }
                        } else {
                            view?.onError(response.message())
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        view?.onError(e.message)
                    }
                }

                override fun onFailure(call: Call<Pincode>, t: Throwable) {
                    try {
                        view?.enableLoadingBar(context, false, "")
                        t.printStackTrace()
                        view?.onError(t.message)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            })
        } else {
            internetNotAvailableMessage(context)
        }
    }

    fun state(context: Context) {

        if (NetworkCheck.isConnected(context)) {

            view?.enableLoadingBar(context, true, "")
            NlTaskApp.getInstance().getApiService()?.getStates()?.enqueue(object : Callback<States> {
                override fun onResponse(call: Call<States>, response: Response<States>) {
                    view?.enableLoadingBar(context, false, "")
                    try {
                        if (!handleError(response, context)) {
                            if (response.isSuccessful && response.code() == 200) {
                                response.body()?.let { view?.onStateSuccess(it) }
                            } else {
                                Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show()
                            }
                        } else {
                            view?.onError(response.message())
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        view?.onError(e.message)
                    }
                }

                override fun onFailure(call: Call<States>, t: Throwable) {
                    try {
                        view?.enableLoadingBar(context, false, "")
                        t.printStackTrace()
                        view?.onError(t.message)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            })
        } else {
            internetNotAvailableMessage(context)
        }
    }

    private fun internetNotAvailableMessage(context: Context) {
        val dialog = SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
        dialog.contentText = "Internet Not Available"
        dialog.show()
    }
}