package br.com.rafaeldias.cvchotel.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Hotel(
    val cityCode: Int,
    val cityName: String,
    val id: Int,
    val name: String,
    val rooms: List<Room>
) : Parcelable

{
    fun roomMinorPrice() =  rooms.sortedBy { it.price.adult }.first()
}
