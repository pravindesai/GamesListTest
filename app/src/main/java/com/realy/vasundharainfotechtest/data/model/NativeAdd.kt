package com.realy.vasundharainfotechtest.data.model

import com.google.gson.annotations.SerializedName

data class NativeAdd(

	@SerializedName("image")
	val image: String? = null,

	@SerializedName("is_active")
	val isActive: Int? = null,

	@SerializedName("image_active")
	val imageActive: Int? = null,

	@SerializedName("package_name")
	val packageName: String? = null,

	@SerializedName("playstore_link")
	val playstoreLink: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("position")
	val position: Int? = null
)