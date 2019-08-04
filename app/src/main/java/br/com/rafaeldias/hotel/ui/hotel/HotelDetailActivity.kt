package br.com.rafaeldias.hotel.ui.hotel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.R
import kotlinx.android.synthetic.main.activity_hotel_detail.*

class HotelDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        var detalhe_hotel = intent!!.getParcelableExtra<Hotel>("detalhe_hotel")

        rvDetalheHotel.layoutManager = LinearLayoutManager(this)
        rvDetalheHotel.adapter = HotelDetailListAdapter(detalhe_hotel.rooms)

        var title_hotel = detalhe_hotel.name
        var title_cidade = detalhe_hotel.cityName

        tvDetalheHotel.setText(title_hotel)
        tvDetalheCidade.setText(title_cidade)

        supportActionBar?.title = getString(R.string.title_details_page)
    }
}
