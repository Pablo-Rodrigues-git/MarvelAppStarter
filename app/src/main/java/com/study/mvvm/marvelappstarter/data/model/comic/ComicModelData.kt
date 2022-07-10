package com.study.mvvm.marvelappstarter.data.model.comic

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ComicModelData(
    @SerializedName("results")
    val result: List<ComicModel>,
) : Serializable