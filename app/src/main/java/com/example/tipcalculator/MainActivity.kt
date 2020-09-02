// PANCHAL SMIT, B00828070
package com.example.tipcalculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    // Declaring the variables
    lateinit var seekBar: SeekBar
    lateinit var textView: TextView
    lateinit var calcEt1: EditText
    lateinit var totalEt1: EditText

    // creating global myClass() object to access the method in myClass.kt
    var myObj = myClass()

    // creating global boolean variable which is used in few methods
    var checkdot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        seekBar = findViewById(R.id.seekBar)
        textView = findViewById(R.id.textView5)
        calcEt1 = findViewById(R.id.calcEt)
        totalEt1 = findViewById(R.id.totalEt)



        /*
            setting the seek bar value to maximum 25%
            created a listener event on seekbar which update the value as the seekbar is moved
            and also will go to myCalculator() method to display the value of tip amount and total
        */
        seekBar.max = 25
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.setText("" + progress.toString() + "%")
                var check: String = calcEt1.getText().toString()
                if (check.equals("")) {
                    textView.setText("" + progress.toString() + "%")
                } else {
                    myCalculator()
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })




        /*
            Creating onClickListener on every button and calling the method in myClass()
        */

        b1.setOnClickListener {
            var value = myObj.PutonEt("1")
            calcEt.append(value)

        }

        b2.setOnClickListener {
            var value = myObj.PutonEt("2")
            calcEt.append(value)
        }

        b3.setOnClickListener {
            var value = myObj.PutonEt("3")
            calcEt.append(value)
        }
        b4.setOnClickListener {
            var value = myObj.PutonEt("4")
            calcEt.append(value)
        }
        b5.setOnClickListener {
            var value = myObj.PutonEt("5")
            calcEt.append(value)
        }
        b6.setOnClickListener {
            var value = myObj.PutonEt("6")
            calcEt.append(value)
        }

        b7.setOnClickListener {
            var value = myObj.PutonEt("7")
            calcEt.append(value)
        }
        b8.setOnClickListener {
            var value = myObj.PutonEt("8")
            calcEt.append(value)
        }
        b9.setOnClickListener {
            var value = myObj.PutonEt("9")
            calcEt.append(value)
        }
        b0.setOnClickListener {
            var value = myObj.PutonEt("0")
            calcEt.append(value)
        }

        // Setting onClickListener on clear button
        bClear.setOnClickListener {
            ClearFun()
        }

        // Setting onClickListener on dot button
        bDot.setOnClickListener {
            bDotFun(".")
        }

        // Setting onClickListener on calculate button
        bEquals.setOnClickListener {
            var check: String = calcEt1.getText().toString()
            if (check.equals("")) {
                val myToast = Toast.makeText(
                    applicationContext,
                    "Please provide the Bill Amount",
                    Toast.LENGTH_LONG
                )
                myToast.show()
            } else if (check.equals(".")) {

                val myToast = Toast.makeText(
                    applicationContext,
                    "Need to enter some digit",
                    Toast.LENGTH_LONG
                )
                myToast.show()
            } else {
                myCalculator()
            }
        }

        // Setting onClickListener on delete
        bX.setOnClickListener {
            var check: String = calcEt1.getText().toString()
            if (check.equals("")) {
                val myToast =
                    Toast.makeText(applicationContext, "Nothing to Clear", Toast.LENGTH_LONG)
                myToast.show()
            } else {

                Xfun()
            }
        }


    }

    // ClearFun() will clear all the values on the EditText
    fun ClearFun() {
        checkdot = false
        calcEt.setText("")
        TipEt.setText("")
        totalEt.setText("")
    }

    // bDotFun() will put a . and will not allow more than one .
    fun bDotFun(string: String) {

        if (!checkdot) {
            if (calcEt1.getText().equals("")) {
                calcEt1.setText(".")
            } else {
                calcEt1.setText(calcEt1.getText().toString() + ".")
            }
            checkdot = true
        }

    }

    // Xfun() will delete the values
    fun Xfun() {
        val myX = calcEt.text.toString()

        var a: CharArray = myX.toString().toCharArray()


        if (a[myX.length - 1].equals('.')) {
            checkdot = false
        }

        if (!myX.isEmpty()) {
            calcEt.setText(myX.substring(0, myX.length - 1))

        }


    }

    // myCalculator() will do all the calculation to calculate tip amount and the total
    fun myCalculator() {


        var value = seekBar.progress
        var check = value.toDouble()
        var istr1: String = calcEt1.getText().toString()
        var int1: Double = istr1.toDouble()

        var tipamount: Double = check / 100
        var finaltipamount: Double = Math.round(tipamount * 100.0) / 100.0
        var amount: Double = finaltipamount * int1
        var finalamount: Double = Math.round(amount * 100.0) / 100.0
        TipEt.setText("$" + finalamount)

        var total: Double = amount + int1
        var finaltotal: Double = Math.round(total * 100.0) / 100.0
        totalEt.setText("$" + finaltotal)


    }


}
