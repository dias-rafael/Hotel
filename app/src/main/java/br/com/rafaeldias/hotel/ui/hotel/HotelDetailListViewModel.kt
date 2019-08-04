package br.com.rafaeldias.hotel.ui.hotel

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.network.HotelApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HotelDetailListViewModel: BaseViewModel(){

    @Inject
    lateinit var hotelApi: HotelApi

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    val hotelDetailListAdapter: HotelDetailListAdapter2 = HotelDetailListAdapter2()

    private lateinit var subscription: Disposable

    init{
        loadDetalhes()
    }

    private fun loadDetalhes(){
        subscription = hotelApi.getHoteis()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveHotelDetailListStart() }
            .doOnTerminate { onRetrieveHotelDetailListFinish() }
            .subscribe(
                { result -> onRetrieveHotelDetailListSuccess(result)},
                { onRetrieveHotelDetailListError() }
            )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrieveHotelDetailListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveHotelDetailListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveHotelDetailListSuccess(hotelList:List<Hotel>){
        hotelDetailListAdapter.updateHotelDetailList(hotelList)
    }

    private fun onRetrieveHotelDetailListError(){
        errorMessage.value = R.string.hotel_error
    }
}