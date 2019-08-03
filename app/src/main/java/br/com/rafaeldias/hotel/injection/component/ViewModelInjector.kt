package br.com.rafaeldias.hotel.injection.component

import br.com.rafaeldias.hotel.injection.module.NetworkModule
import br.com.rafaeldias.hotel.ui.hotel.HotelDetailListViewModel
import br.com.rafaeldias.hotel.ui.hotel.HotelListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(hotelListViewModel: HotelListViewModel)

    fun inject(hotelDetailListViewModel: HotelDetailListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}