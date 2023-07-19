package com.community.nltask.api.models

import com.google.gson.annotations.SerializedName

data class Countries(

	@field:SerializedName("countriesbl")
	val countriesbl: List<CountriesblItem?>? = null
)

data class CountriesblItem(

	@field:SerializedName("capital")
	val capital: String? = null,

	@field:SerializedName("emojiU")
	val emojiU: String? = null,

	@field:SerializedName("flag")
	val flag: Int? = null,

	@field:SerializedName("iso")
	val iso: String? = null,

	@field:SerializedName("emoji")
	val emoji: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("nicename")
	val nicename: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("native")
	val jsonMemberNative: String? = null,

	@field:SerializedName("translations")
	val translations: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null,

	@field:SerializedName("wikiDataId")
	val wikiDataId: String? = null,

	@field:SerializedName("currency_name")
	val currencyName: String? = null,

	@field:SerializedName("currency_symbol")
	val currencySymbol: String? = null,

	@field:SerializedName("subregion")
	val subregion: String? = null,

	@field:SerializedName("phonecode")
	val phonecode: String? = null,

	@field:SerializedName("tld")
	val tld: String? = null,

	@field:SerializedName("numcode")
	val numcode: String? = null,

	@field:SerializedName("timezones")
	val timezones: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("iso3")
	val iso3: String? = null
)
