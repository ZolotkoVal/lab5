package com.example.lab5

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val ratesBank = arrayListOf(
        Rate(93.0),
        Rate(103.0),
        Rate(120.0))

    var selectedCurrencyID = 0
    var discount = 0
    var answer = 0.0
}