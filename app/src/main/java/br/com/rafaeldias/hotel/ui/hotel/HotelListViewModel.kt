package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.base.BaseViewModel
import br.com.rafaeldias.hotel.network.HotelApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HotelListViewModel: BaseViewModel(){

    @Inject
    lateinit var hotelApi: HotelApi

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadHoteis() }

    val hotelListAdapter: HotelListAdapter = HotelListAdapter()

    private lateinit var subscription: Disposable

    init{
        loadHoteis()
    }

    private fun loadHoteis(){
        subscription = hotelApi.getHoteis()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveHotelListStart() }
            .doOnTerminate { onRetrieveHotelListFinish() }
            .subscribe(
                { result -> onRetrieveHotelListSuccess(result.sortedBy { it.roomMinorPrice().price.adult })},
                { onRetrieveHotelListError() }
            )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrieveHotelListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveHotelListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveHotelListSuccess(hotelList:List<Hotel>){
        hotelListAdapter.updateHotelList(hotelList)
    }

    private fun onRetrieveHotelListError(){
        errorMessage.value = R.string.hotel_error
    }
}