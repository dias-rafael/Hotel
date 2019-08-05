package br.com.rafaeldias.hotel.ui.hotel

import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.base.BaseViewModel

class DetailListViewModel: BaseViewModel(){

    val detailListAdapter: DetailListAdapter = DetailListAdapter()

    fun setHotel(detalhes: Hotel? = null) {
        detailListAdapter.updateDetailList(detalhes!!.rooms)
    }

}