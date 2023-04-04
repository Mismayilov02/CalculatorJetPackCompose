package com.master.calculator

import android.view.View
import androidx.lifecycle.MutableLiveData

class ViewModelRepository {
      val number: MutableLiveData<String>
       var firstNumber:MutableLiveData<kotlin.String>
       var operatorSet:MutableLiveData<kotlin.String>
       var dataText:MutableLiveData<kotlin.String>
       var ansverText:MutableLiveData<kotlin.String>
      val first: MutableLiveData<Boolean>
       var firstEquals:MutableLiveData<kotlin.Boolean>
       var abc:MutableLiveData<kotlin.Boolean>
       var ansver: MutableLiveData<Float>

    init{
        ansver = MutableLiveData(0f)
        abc = MutableLiveData(false)
        firstEquals = MutableLiveData(false)
        first = MutableLiveData(false)
        ansverText = MutableLiveData("0")
        dataText = MutableLiveData("")
        operatorSet = MutableLiveData("")
        firstNumber = MutableLiveData("")
        number = MutableLiveData("")
    }

    fun operator(view: String) {
        abc.setValue(true)
        when (view) {
            "AC" -> {
                dataText.value = ""
                number.value = ""
                firstNumber.value = ""
                ansverText.value = "0"
                firstEquals.value = true
                ansver.setValue(0f)
            }
            "*" -> equals("*")
            "+" -> equals("+")
            "-" -> equals("-")
            "/" -> equals("/")
            "=" -> equals("=")
        }
    }

    fun equals(choose: String) {
        if (firstEquals.value!!) {
            if (choose == "=") {
            } else {
                firstNumber.value = dataText.value
                operatorSet.value = choose
                try {
                    ansver.setValue(java.lang.Float.valueOf(dataText.value))
                } catch (e: Exception) {
                }
                if (dataText.value != "") {
                    firstEquals.value = false
                    dataText.value = "0"
                    ansverText.value = firstNumber.value
                    number.value = ""
                }
            }
        } else {
            if (dataText.value.toString() != "" && dataText.value.toString() != "0") {
                when (operatorSet.value) {
                    "=" -> ansverText.setValue(ansver.toString())
                    "+" -> ansver.setValue(ansver.value!! + java.lang.Float.valueOf(dataText.value))
                    "-" -> ansver.setValue(ansver.value!! - java.lang.Float.valueOf(dataText.value))
                    "/" -> ansver.setValue(ansver.value!! / java.lang.Float.valueOf(dataText.value))
                    "*" -> ansver.setValue(ansver.value!! * java.lang.Float.valueOf(dataText.value))
                }
                equalsSetText(choose)
            } else {
                operatorSet.setValue(choose)
            }
        }
    }

    private fun equalsSetText(choose: String) {
        ansverText.value = ondalik(ansver.value!!)
        dataText.value = "0"
        operatorSet.value = choose
        number.value = ""
    }

    fun btnClick(view: String) {
        when (view) {
            "0" -> if (!first.value!!) {
                number.value = number.value + 0
                dataText.value = number.value
            }
            "0" -> btnClickSetText("1")
            "2" -> btnClickSetText("2")
            "9"-> btnClickSetText("9")
            "3" -> btnClickSetText("3")
            "4"-> btnClickSetText("4")
            "5" -> btnClickSetText("5")
            "6" -> btnClickSetText("6")
            "7"-> btnClickSetText("7")
            "8" -> btnClickSetText("8")
            "." -> btnClickSetText(".")
            "+-" ->                 // number  = "-"+number;
                if (abc.value!!) {
                    number.setValue("-" + number.value)
                    dataText.setValue("-" + dataText.value)
                    abc.setValue(false)
                } else {
                    val abc = dataText.value
                    val son = abc!!.substring(1, abc.length)
                    number.setValue(number.value!!.substring(1, number.value!!.length))
                    dataText.setValue(son)
                    this.abc.setValue(true)
                }
        }
    }

    private fun btnClickSetText(value: String) {
        number.value = number.value + value
        dataText.value = number.value
        first.value = false
    }



    private fun ondalik(a: Float): String? {
        val b = a.toInt()
        return if (a - b == 0f) {
            // System.out.println("denemeye");
            Math.round(b.toFloat()).toString()
        } else {
            a.toString()
        }
    }
}