package com.realy.vasundharainfotechtest.data.model

import com.google.gson.annotations.SerializedName

data class DataItem(

	@SerializedName("app_link")
	val appLink: String? = null,

	@SerializedName("full_thumb_image")
	val fullThumbImage: String? = null,

	@SerializedName("thumb_image")
	val thumbImage: String? = null,

	@SerializedName("splash_active")
	val splashActive: Int? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("package_name")
	val packageName: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("position")
	val position: Int? = null,

	@SerializedName("app_id")
	val appId: Int? = null
)