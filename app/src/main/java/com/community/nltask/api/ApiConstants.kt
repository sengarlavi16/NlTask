package com.community.nltask.api

object ApiConstants {
        const val BASE_URL = "https://nationlearns.com/api/"

        // PARAMETER
        const val AUTHORIZATION = "Authorization"
        const val DEVICE_TOKEN = "device_token"

        const val COUNTRIES = "countries"
        const val STATES = "states"
        const val CITY = "city/{state_id}"
        const val PINCODE = "pincode/{city_id}"
}