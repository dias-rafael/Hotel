package br.com.rafaeldias.hotel.base

import android.arch.lifecycle.ViewModel
import br.com.rafaeldias.hotel.injection.component.DaggerViewModelInjector
import br.com.rafaeldias.hotel.injection.component.ViewModelInjector
import br.com.rafaeldias.hotel.injection.module.NetworkModule
import br.com.rafaeldias.hotel.ui.hotel.HotelListViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is HotelListViewModel -> injector.inject(this)
        }
    }
}