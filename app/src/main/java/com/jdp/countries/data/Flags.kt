package com.jdp.countries.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flags(
    val png: String,
    val svg: String
) : Parcelable