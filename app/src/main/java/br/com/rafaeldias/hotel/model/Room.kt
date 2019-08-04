package br.com.rafaeldias.cvchotel.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Room(
    val categoryName: String,
    val price: Price,
    val roomID: Int,
    val hotelId: Int
) : Parcelable
