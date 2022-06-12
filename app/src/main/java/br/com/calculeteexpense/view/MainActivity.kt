package br.com.calculeteexpense.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.calculeteexpense.databinding.ActivityMainBinding
import br.com.calculeteexpense.viewModel.CalculateViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: CalculateViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CalculateViewModel::class.java)

        listener()
        observer()
    }

    private fun observer(){
        viewModel?.apply {
            totalGasoline.observe(this@MainActivity, Observer{
                binding.layoutResult.tvInfoGasolinePrice.text = it.toString()
            })
            totalAlcohol.observe(this@MainActivity, Observer{
                binding.layoutResult.tvInfoAlcoholPrice.text = it.toString()
            })
        }
    }

    private fun listener(){
        binding.run {
            btnCalc.setOnClickListener {

                val distance = etDistance.text.toString()
                val km = etKm.text.toString()
                val gasoline = etGasolinePrice.text.toString()
                val alcohol = etAlcoholPrice.text.toString()

                viewModel?.calcGasoline(distance.toDouble(), km.toDouble(), gasoline.toDouble())
                viewModel?.calcAlcohol(distance.toDouble(), km.toDouble(), alcohol.toDouble())
            }

            btnClear.setOnClickListener {
                viewModel?.clear()
                etDistance.setText("")
                etKm.setText("")
                etGasolinePrice.setText("")
                etAlcoholPrice.setText("")
            }
        }
    }
}