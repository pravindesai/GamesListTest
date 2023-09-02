package com.realy.vasundharainfotechtest.data.model

import com.google.gson.annotations.SerializedName

data class SubCategoryItem(

	@SerializedName("app_link")
	val appLink: String? = null,

	@SerializedName("is_active")
	val isActive: Int? = null,

	@SerializedName("star")
	val star: String? = null,

	@SerializedName("image_active")
	val imageActive: Int? = null,

	@SerializedName("installed_range")
	val installedRange: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("icon")
	val icon: String? = null,

	@SerializedName("banner")
	val banner: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("position")
	val position: Int? = null,

	@SerializedName("app_id")
	val appId: Int? = null,

	@SerializedName("banner_image")
	val bannerImage: String? = null
)