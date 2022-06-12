package br.com.calculeteexpense.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {

    private val _totalGasoline : MutableLiveData<Double> = MutableLiveData()
    val totalGasoline: LiveData<Double> get() =_totalGasoline

    private val _totalAlcohol : MutableLiveData<Double> = MutableLiveData()
    val totalAlcohol: LiveData<Double> get() =_totalAlcohol

    fun calcGasoline(distance: Double, km: Double, price: Double){
        _totalGasoline.postValue(distance / km * price)
    }

    fun calcAlcohol(distance: Double, km: Double, price: Double){
        _totalAlcohol.postValue(distance / km * price)
    }

    fun clear(){
        _totalGasoline.postValue(0.0)
        _totalAlcohol.postValue(0.0)
    }
}