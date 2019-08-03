package br.com.rafaeldias.hotel.network

import br.com.rafaeldias.cvchotel.ui.model.HoteisList
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import io.reactivex.Observable
import retrofit2.http.GET

interface HotelApi {
    @GET("/hotels/avail/1032")
    fun getHoteis(): Observable<List<Hotel>>
}
