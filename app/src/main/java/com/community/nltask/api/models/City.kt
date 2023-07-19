package com.community.nltask.api.models

import com.google.gson.annotations.SerializedName

data class City(

	@field:SerializedName("citybl")
	val citybl: List<CityblItem?>? = null
)

data class CityblItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
