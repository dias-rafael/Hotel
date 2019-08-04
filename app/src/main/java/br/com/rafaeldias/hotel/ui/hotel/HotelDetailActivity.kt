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

        var nome_hotel = intent!!.getStringExtra("nome_hotel")
        var cidade_hotel = intent!!.getStringExtra("cidade_hotel")
        var detalhe_hotel = intent!!.getParcelableExtra<Hotel>("detalhe_hotel")

        hotel_detail.layoutManager = LinearLayoutManager(this)
        hotel_detail.adapter = HotelDetailListAdapter(detalhe_hotel.rooms)

        var title_hotel = nome_hotel
        var title_cidade = cidade_hotel

        tvDetalheHotel.setText(title_hotel)
        tvDetalheCidade.setText(title_cidade)

        supportActionBar?.title = getString(R.string.title_details_page)
    }
}
