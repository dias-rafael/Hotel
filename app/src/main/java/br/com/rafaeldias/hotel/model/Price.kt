package br.com.rafaeldias.cvchotel.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    val adult: Double,
    val child: Double
) : Parcelable