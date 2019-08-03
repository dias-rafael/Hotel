package br.com.rafaeldias.cvchotel.ui.model

data class Hotel(
    val cityCode: Int,
    val cityName: String,
    val id: Int,
    val name: String,
    val rooms: List<Room>
)

