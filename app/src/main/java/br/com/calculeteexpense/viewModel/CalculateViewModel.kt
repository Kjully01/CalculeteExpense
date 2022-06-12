package br.com.calculeteexpense.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {

    private val _totalGasoline : MutableLiveData<Double> = MutableLiveData()
    val totalGasoline: LiveData<Double> get() =_totalGasoline

    private val _totalDiesel : MutableLiveData<Double> = MutableLiveData()
    val totalDiesel: LiveData<Double> get() =_totalDiesel

    fun calcGasoline(distance: Double, km: Double, price: Double){
        _totalGasoline.postValue(distance / km * price)
    }

    fun calcDiesel(distance: Double, km: Double, price: Double){
        _totalDiesel.postValue(distance / km * price)
    }

    fun clear(){

    }
}