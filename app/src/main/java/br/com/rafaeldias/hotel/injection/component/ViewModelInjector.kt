package br.com.rafaeldias.hotel.injection.component

import br.com.rafaeldias.hotel.injection.module.NetworkModule
import br.com.rafaeldias.hotel.ui.hotel.DetailListViewModel
import br.com.rafaeldias.hotel.ui.hotel.HotelListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(hotelListViewModel: HotelListViewModel)

    fun injectDetail(detailListViewModel: DetailListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}