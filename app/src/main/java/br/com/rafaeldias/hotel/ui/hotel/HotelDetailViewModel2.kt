package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.MutableLiveData
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.utils.Format


class HotelDetailViewModel2: BaseViewModel() {
    private val hotelCategoriaQuarto = MutableLiveData<String>()
    private val hotelPrecoQuartoAdulto = MutableLiveData<String>()
    private val hotelPrecoQuartoCrianca = MutableLiveData<String>()

    fun bind(hotel: Room){
        hotelCategoriaQuarto.value = hotel.categoryName+ " Adulto"
        hotelPrecoQuartoAdulto.value = Format.Currency(hotel.price.adult)
        hotelPrecoQuartoCrianca.value = Format.Currency(hotel.price.child)
    }

    fun getHotelCategoriaQuarto():MutableLiveData<String>{
        return hotelCategoriaQuarto
    }

    fun getHotelPrecoQuartoAdulto():MutableLiveData<String>{
        return hotelPrecoQuartoAdulto
    }

    fun getHotelPrecoQuartoCrianca():MutableLiveData<String>{
        return hotelPrecoQuartoCrianca
    }
}