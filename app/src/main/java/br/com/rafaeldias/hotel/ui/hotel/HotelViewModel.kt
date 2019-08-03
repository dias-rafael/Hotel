package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.MutableLiveData
import br.com.rafaeldias.cvchotel.ui.model.HoteisList
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.utils.Format


class HotelViewModel: BaseViewModel() {
    private val hotelTitle = MutableLiveData<String>()
    private val hotelCidade = MutableLiveData<String>()
    private val hotelCategoriaQuarto = MutableLiveData<String>()
    private val hotelPrecoQuarto = MutableLiveData<String>()

    fun bind(hotel: Hotel){
        hotelTitle.value = hotel.name
        hotelCidade.value = hotel.cityName
        hotelCategoriaQuarto.value = hotel.rooms[0].categoryName+ " Adulto"
        hotelPrecoQuarto.value = Format.Currency(hotel.rooms[0].price.adult)
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

    fun getHotelPrecoQuarto():MutableLiveData<String>{
        return hotelPrecoQuarto
    }
}