package com.dhanu.google_map_ps2017107.models

import java.io.Serializable

data class UserMaps (
    val title:String,
    val places:List<Place>
        ):Serializable
