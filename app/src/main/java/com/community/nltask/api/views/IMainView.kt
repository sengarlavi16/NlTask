package com.community.nltask.api.views

import com.community.nltask.api.models.City
import com.community.nltask.api.models.Countries
import com.community.nltask.api.models.Pincode
import com.community.nltask.api.models.States

interface IMainView : IAppView {
    fun onCountrySuccess(item: Countries)
    fun onStateSuccess(item: States)
    fun onCitySuccess(item: City)
    fun onPinSuccess(item: Pincode)
}