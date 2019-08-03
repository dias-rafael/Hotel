package br.com.rafaeldias.hotel.utils

import java.text.NumberFormat

class Format {
    companion object {
        fun Currency (valor: Double): String {
            return NumberFormat.getCurrencyInstance().format(valor)
        }
    }
}