package com.master.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel():ViewModel(){
       val number: MutableLiveData<String>
        var firstNumber: MutableLiveData<String>
        var operatorSet: MutableLiveData<String>
        var dataText: MutableLiveData<String>
        var ansverText: MutableLiveData<String>
       val first: MutableLiveData<Boolean>
        var firstEquals: MutableLiveData<Boolean>
        var abc: MutableLiveData<Boolean>
        var ansver: MutableLiveData<Float>
       var repostory: ViewModelRepository

    init {
        repostory =  ViewModelRepository()
        ansver =  repostory.ansver
        abc =  repostory.abc
        first =  repostory.first
        firstEquals =  repostory.firstEquals
        ansverText =  repostory.ansverText
        dataText =  repostory.dataText
        operatorSet =  repostory.operatorSet
        firstNumber =  repostory.firstNumber
        number =  repostory.number


    }


    fun btnClick(view: String) {
        repostory.btnClick(view)
    }

    fun eguals(choose: String?) {
        repostory.equals(choose)
    }

    fun operator(view:String) {
        repostory.operator(view)
    }
}