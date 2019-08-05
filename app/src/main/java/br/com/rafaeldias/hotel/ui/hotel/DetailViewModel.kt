package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.MutableLiveData
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.utils.Format

class DetailViewModel: BaseViewModel() {
    private val detalheTipoQuarto = MutableLiveData<String>()
    private val detalheValorQuartoAdulto = MutableLiveData<String>()
    private val detalheValorQuartoCrianca = MutableLiveData<String>()

    fun bind(hotel: Room){
        detalheTipoQuarto.value = hotel.categoryName
        detalheValorQuartoAdulto.value = Format.Currency(hotel.price.adult)
        detalheValorQuartoCrianca.value = Format.Currency(hotel.price.child)
    }

    fun getDetalheTipoQuarto():MutableLiveData<String>{
        return detalheTipoQuarto
    }

    fun getDetalheValorQuartoAdulto():MutableLiveData<String>{
        return detalheValorQuartoAdulto
    }

    fun getDetalheValorQuartoCrianca():MutableLiveData<String>{
        return detalheValorQuartoCrianca
    }
}