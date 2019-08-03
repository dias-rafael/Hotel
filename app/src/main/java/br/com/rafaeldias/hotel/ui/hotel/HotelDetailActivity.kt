package br.com.rafaeldias.hotel.ui.hotel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ActivityHotelDetailBinding
import kotlinx.android.synthetic.main.activity_hotel_detail.*

class HotelDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHotelDetailBinding
    private lateinit var viewModel: HotelDetailListViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hotel_detail)
        binding.hotelDetail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(HotelDetailListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        var title_hotel = intent!!.getStringExtra("title_hotel")
        var title_cidade = intent!!.getStringExtra("title_cidade")

        tvDetalheHotel.setText(title_hotel)
        tvDetalheCidade.setText(title_cidade)
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}