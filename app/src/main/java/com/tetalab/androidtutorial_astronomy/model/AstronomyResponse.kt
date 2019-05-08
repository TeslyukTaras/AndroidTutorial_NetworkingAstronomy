package com.tetalab.androidtutorial_astronomy.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AstronomyResponse {

    @SerializedName("astronomy")
    @Expose
    var astronomy: Astronomy? = null
    @SerializedName("feedCreation")
    @Expose
    var feedCreation: String? = null
    @SerializedName("metric")
    @Expose
    var metric: Boolean? = null

}