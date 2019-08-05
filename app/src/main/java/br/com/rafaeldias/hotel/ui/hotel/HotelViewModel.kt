package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.MutableLiveData
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.utils.Format


class HotelViewModel: BaseViewModel() {
    private val hotelTitle = MutableLiveData<String>()
    private val hotelCidade = MutableLiveData<String>()
    private val hotelCategoriaQuarto = MutableLiveData<String>()
    private val hotelMenorPrecoQuartoAdulto = MutableLiveData<String>()

    fun bind(hotel: Hotel){
        hotelTitle.value = hotel.name
        hotelCidade.value = hotel.cityName
        hotelCategoriaQuarto.value = hotel.roomMinorPrice().categoryName+ " Adulto"
        hotelMenorPrecoQuartoAdulto.value = Format.Currency(hotel.roomMinorPrice().price.adult)
    }

    fun getHotelTitle():MutableLiveData<String>{
        return hotelTitle
    }

    fun getHotelCidade():MutableLiveData<String>{
        return hotelCidade
    }

    fun getHotelCategoriaQuarto():MutableLiveData<String>{
        return hotelCategoriaQuarto
    }

    fun getHotelMenorPrecoQuartoAdulto():MutableLiveData<String>{
        return hotelMenorPrecoQuartoAdulto
    }
}