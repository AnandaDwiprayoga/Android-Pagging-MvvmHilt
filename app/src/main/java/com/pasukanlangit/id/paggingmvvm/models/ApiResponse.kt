package com.pasukanlangit.id.paggingmvvm.models

import com.google.gson.annotations.SerializedName

data class ApiResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem>,

)

data class ResultsItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("species")
	val species: String,

	@field:SerializedName("created")
	val created: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("episode")
	val episode: List<String>,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("status")
	val status: String
)
