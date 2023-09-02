package com.realy.vasundharainfotechtest.data.model

import com.google.gson.annotations.SerializedName

data class HomeItem(

	@SerializedName("is_active")
	val isActive: Int? = null,

	@SerializedName("sub_category")
	val subCategory: List<SubCategoryItem?>? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("position")
	val position: Int? = null,

	@SerializedName("catgeory")
	val catgeory: String? = null
)