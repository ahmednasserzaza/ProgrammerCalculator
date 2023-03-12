package com.fighter.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.fighter.programmercalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var converter: Converter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        initSpinners()
        converter = Converter()
        binding.buttonGetResult.setOnClickListener {
            binding.gifImage.setImageDrawable(null)
            convert()
        }
    }

    private fun initSpinners() {
        val items = listOf("binary", "decimal", "octal", "hexadecimal")
        val adapterFrom = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        adapterFrom.setDropDownViewResource(R.layout.spinner_item)
        binding.spinnerFrom.adapter = adapterFrom
        binding.spinnerFrom.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> binding.editTextEntering.hint = getString(R.string.binary_hint)
                    1 -> binding.editTextEntering.hint = getString(R.string.decimal_hint)
                    2 -> binding.editTextEntering.hint = getString(R.string.octal_hint)
                    3 -> binding.editTextEntering.hint = getString(R.string.hexadecimal_hint)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val adapterTo = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        adapterTo.setDropDownViewResource(R.layout.spinner_item)
        binding.spinnerTo.adapter = adapterTo
        binding.spinnerTo.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> binding.resultHeader.text = getString(R.string.binary_header)
                    1 -> binding.resultHeader.text = getString(R.string.decimal_header)
                    2 -> binding.resultHeader.text = getString(R.string.octal_header)
                    3 -> binding.resultHeader.text = getString(R.string.hexadecimal_header)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun convert() {
        val input = binding.editTextEntering.text.toString().trim()
        val result = binding.textViewResult

        try {
            val from = binding.spinnerFrom.selectedItemPosition
            val to = binding.spinnerTo.selectedItemPosition

            when (from) {
                0 -> when (to) {
                    0 -> result.text = input
                    1 -> result.text = converter.binaryToDecimal(input).toString()
                    2 -> result.text = converter.binaryToOctal(input)
                    3 -> result.text = converter.binaryToHexadecimal(input)
                }
                1 -> when (to) {
                    0 -> result.text = converter.decimalToBinary(input.toLong())
                    1 -> result.text = input
                    2 -> result.text = converter.decimalToOctal(input.toLong())
                    3 -> result.text = converter.decimalToHexadecimal(input.toLong())
                }
                2 -> when (to) {
                    0 -> result.text = converter.octalToBinary(input)
                    1 -> result.text = converter.octalToDecimal(input).toString()
                    2 -> result.text = input
                    3 -> result.text = converter.octalToHexadecimal(input)
                }
                3 -> when (to) {
                    0 -> result.text = converter.hexadecimalToBinary(input)
                    1 -> result.text = converter.hexadecimalToDecimal(input).toString()
                    2 -> result.text = converter.hexadecimalToOctal(input)
                    3 -> result.text = input
                }
            }
            if (input.isNotEmpty()){
                Glide.with(this).asGif().load(R.raw.right).into(binding.gifImage)
            }
        } catch (e: Exception) {
            result.text = getString(R.string.invalid)
            Glide.with(this).asGif().load(R.raw.think).into(binding.gifImage)
        }
    }
}