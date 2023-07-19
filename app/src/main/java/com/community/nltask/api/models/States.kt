package com.community.nltask.api.models

import com.google.gson.annotations.SerializedName

data class States(

	@field:SerializedName("statebl")
	val statebl: List<StateblItem?>? = null
)

data class StateblItem(

	@field:SerializedName("wikiDataId")
	val wikiDataId: String? = null,

	@field:SerializedName("flag")
	val flag: Int? = null,

	@field:SerializedName("fips_code")
	val fipsCode: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("iso2")
	val iso2: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("country_id")
	val countryId: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
