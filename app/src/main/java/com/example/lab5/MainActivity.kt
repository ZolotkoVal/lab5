package com.example.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    private lateinit var okButton: Button
    private lateinit var priceInput: EditText
    private lateinit var discountAmountText: TextView
    private lateinit var discountSeekBar: SeekBar
    private lateinit var dollarRadioButton: RadioButton
    private lateinit var euroRadioButton: RadioButton
    private lateinit var poundRadioButton: RadioButton
    private val mainViewModel: MainViewModel by
    lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val provider: ViewModelProvider = ViewModelProvider(this)
        val mainViewModel = provider.get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
        okButton = findViewById(R.id.buttonOk)
        priceInput = findViewById(R.id.inputPrice)
        discountSeekBar = findViewById(R.id.seekBarDiscount)
        discountAmountText = findViewById(R.id.textDiscountAmount)
        dollarRadioButton = findViewById(R.id.radioButtonDollar)
        euroRadioButton = findViewById(R.id.radioButtonEuro)
        poundRadioButton = findViewById(R.id.radioButtonPound)
        discountSeekBar = findViewById(R.id.seekBarDiscount)

        dollarRadioButton.setOnClickListener{
            mainViewModel.selectedCurrencyID = 0
        }
        euroRadioButton.setOnClickListener{
            mainViewModel.selectedCurrencyID = 1
        }
        poundRadioButton.setOnClickListener{
            mainViewModel.selectedCurrencyID = 2
        }

        discountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mainViewModel.discount = progress
                discountAmountText.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {     }
        })

        okButton.setOnClickListener{
           if (priceInput.text.isNotEmpty()){
               val answer = (priceInput.text.toString().toDouble() * mainViewModel.ratesBank[mainViewModel.selectedCurrencyID].rateValue)
               mainViewModel.answer = answer-((answer*mainViewModel.discount)/100)
               val intent = Intent(this, AnswerActivity::class.java)
               intent.putExtra("answer", mainViewModel.answer)
               startActivity(intent)
           }
        }
    }


}