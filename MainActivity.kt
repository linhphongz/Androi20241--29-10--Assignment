package com.example.exchangemoney
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
 
class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner

    private val exchangeRates = mapOf(
        "USD" to 1.0,
        "VND" to 23000.0,
        "EUR" to 0.85,
        "JPY" to 110.0,
        "CNY" to 6.5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.text1)
        editText2 = findViewById(R.id.text2)
        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)

        // Khởi tạo adapter cho spinner1 và spinner2
        val currencyAdapter = ArrayAdapter.createFromResource(this, R.array.currency_array1, android.R.layout.simple_spinner_item)
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = currencyAdapter

        val currencyAdapter2 = ArrayAdapter.createFromResource(this, R.array.currency_array2, android.R.layout.simple_spinner_item)
        currencyAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = currencyAdapter2

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                updateConversion(1)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                updateConversion(2)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun updateConversion(chedo: Int) {
        val amount1 = editText1.text.toString().toDoubleOrNull() ?: 0.0
        val amount2 = editText2.text.toString().toDoubleOrNull() ?: 0.0
        val currency1 = spinner1.selectedItem.toString()
        val currency2 = spinner2.selectedItem.toString()

        if (chedo == 2 ) {
            val convertedAmount = amount1 * (exchangeRates[currency2] ?: 1.0) / (exchangeRates[currency1] ?: 1.0)
            editText1.setText(String.format("%.2f", convertedAmount))
        } else if (chedo == 1 ) {
            val convertedAmount = amount2 * (exchangeRates[currency1] ?: 1.0) / (exchangeRates[currency2] ?: 1.0)
            editText2.setText(String.format("%.2f", convertedAmount))
        }
    }
}
