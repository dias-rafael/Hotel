package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.MutableLiveData
import br.com.rafaeldias.cvchotel.ui.model.HoteisList
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.utils.Format


class HotelDetailViewModel: BaseViewModel() {
    private val hotelCategoriaQuarto = MutableLiveData<String>()
    private val hotelPrecoQuarto = MutableLiveData<String>()

    fun bind(hotel: Hotel){
        hotelCategoriaQuarto.value = hotel.rooms[0].categoryName + " Adulto"
        hotelPrecoQuarto.value = Format.Currency(hotel.rooms[0].price.adult)
    }

    fun getHotelDetailCategoriaQuarto():MutableLiveData<String>{
        return hotelCategoriaQuarto
    }

    fun getHotelDetailPrecoQuarto():MutableLiveData<String>{
        return hotelPrecoQuarto
    }
}