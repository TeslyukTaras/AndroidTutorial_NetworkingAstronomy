package com.tetalab.androidtutorial_astronomy.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Astronomy {

    @SerializedName("astronomy")
    @Expose
    var astronomy: List<Astronomy_>? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null
    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null

}