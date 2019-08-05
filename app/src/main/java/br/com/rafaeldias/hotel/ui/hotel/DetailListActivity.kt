package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ActivityHotelDetailBinding
import kotlinx.android.synthetic.main.activity_hotel_detail.*

class DetailListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHotelDetailBinding
    private lateinit var viewModel: DetailListViewModel

    private var detalhe_hotel: Hotel? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        detalhe_hotel = intent!!.getParcelableExtra<Hotel>("detalhe_hotel")

        var title_hotel = detalhe_hotel!!.name
        var title_cidade = detalhe_hotel!!.cityName

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hotel_detail)
        binding.rvDetalheHotel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(DetailListViewModel::class.java)
        viewModel.setHotel(detalhe_hotel!!)
        binding.viewModelDetail = viewModel

        tvDetalheHotel.setText(title_hotel)
        tvDetalheCidade.setText(title_cidade)

        //supportActionBar?.title = getString(R.string.title_details_page)
    }

}