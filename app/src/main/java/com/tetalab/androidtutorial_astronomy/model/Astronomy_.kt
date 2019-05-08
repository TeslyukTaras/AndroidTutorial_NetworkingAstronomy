package com.tetalab.androidtutorial_astronomy.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Astronomy_ {

    @SerializedName("sunrise")
    @Expose
    var sunrise: String? = null
    @SerializedName("sunset")
    @Expose
    var sunset: String? = null
    @SerializedName("moonrise")
    @Expose
    var moonrise: String? = null
    @SerializedName("moonset")
    @Expose
    var moonset: String? = null
    @SerializedName("moonPhase")
    @Expose
    var moonPhase: Double? = null
    @SerializedName("moonPhaseDesc")
    @Expose
    var moonPhaseDesc: String? = null
    @SerializedName("iconName")
    @Expose
    var iconName: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null
    @SerializedName("utcTime")
    @Expose
    var utcTime: String? = null

}