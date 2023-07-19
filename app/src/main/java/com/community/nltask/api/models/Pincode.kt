package com.community.nltask.api.models

import com.google.gson.annotations.SerializedName

data class Pincode(

	@field:SerializedName("pincode_list")
	val pincodeList: List<PincodeListItem?>? = null
)

data class PincodeListItem(

	@field:SerializedName("pincode")
	val pincode: String? = null,

	@field:SerializedName("office_name")
	val officeName: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state_id")
	val stateId: Any? = null,

	@field:SerializedName("city_id")
	val cityId: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)
