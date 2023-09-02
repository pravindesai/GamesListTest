package com.realy.vasundharainfotechtest.data.model

import com.google.gson.annotations.SerializedName

data class ObjNetworkResponse(

	@SerializedName("more_apps")
	val moreApps: List<MoreAppsItem?>? = null,

	@SerializedName("native_add")
	val nativeAdd: NativeAdd? = null,

	@SerializedName("data")
	val data: List<DataItem?>? = null,

	@SerializedName("translator_ads_id")
	val translatorAdsId: TranslatorAdsId? = null,

	@SerializedName("app_center")
	val appCenter: List<AppCenterItem?>? = null,

	@SerializedName("message")
	val message: String? = null,

	@SerializedName("status")
	val status: Int? = null,

	@SerializedName("home")
	val home: List<HomeItem?>? = null
)