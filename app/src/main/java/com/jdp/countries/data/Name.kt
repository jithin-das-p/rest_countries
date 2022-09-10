package com.jdp.countries.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(
    var common: String,
    var official: String
) : Parcelable