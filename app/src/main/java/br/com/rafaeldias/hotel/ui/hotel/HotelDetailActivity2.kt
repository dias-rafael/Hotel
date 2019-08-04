package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ActivityHotelDetailBinding
import kotlinx.android.synthetic.main.activity_hotel_detail.*
import kotlinx.android.synthetic.main.item_detail.*

class HotelDetailActivity2 : AppCompatActivity() {
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        var nome_hotel = intent!!.getStringExtra("nome_hotel")
        var cidade_hotel = intent!!.getStringExtra("cidade_hotel")
        var detalhe_hotel = intent!!.getParcelableExtra<Room>("detalhe_hotel")

        hotel_detail.layoutManager = LinearLayoutManager(this)
        hotel_detail.adapter = HotelDetailListAdapter(detalhe_hotel)

        var title_hotel = nome_hotel
        var title_cidade = cidade_hotel

        tvDetalheHotel.setText(title_hotel)
        tvDetalheCidade.setText(title_cidade)

        supportActionBar?.title = getString(R.string.title_details_page)
    }

  */
    private lateinit var binding: ActivityHotelDetailBinding
    private lateinit var viewModel: HotelDetailListViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        var nome_hotel = intent!!.getStringExtra("nome_hotel")
        var cidade_hotel = intent!!.getStringExtra("cidade_hotel")
        var detalhe_hotel = intent!!.getParcelableExtra<Room>("detalhe_hotel")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hotel_detail)
        binding.hotelDetail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(HotelDetailListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        var title_hotel = nome_hotel
        var title_cidade = cidade_hotel

        tvDetalheHotel.setText(title_hotel)
        tvDetalheCidade.setText(title_cidade)

        supportActionBar?.title = getString(R.string.title_details_page)
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setText(R.string.retry)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }

}
