package com.jdp.countries.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CurrencyInfo(
    val name: String?,
    val symbol: String?
) : Parcelable