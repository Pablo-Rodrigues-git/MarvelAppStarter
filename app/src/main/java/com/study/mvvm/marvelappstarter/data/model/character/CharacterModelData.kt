package com.study.mvvm.marvelappstarter.data.model.character

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CharacterModelData(
    @SerializedName("results")
    val results: List<CharacterModel>,
) : Serializable