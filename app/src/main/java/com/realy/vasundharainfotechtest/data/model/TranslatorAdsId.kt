package com.realy.vasundharainfotechtest.data.model

import com.google.gson.annotations.SerializedName

data class TranslatorAdsId(

	@SerializedName("interstitial")
	val interstitial: String? = null,

	@SerializedName("banner")
	val banner: String? = null
)