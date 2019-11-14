package com.example.incurance_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "Item = ${spinnerAge.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this

        buttonCalculate.setOnClickListener{
            calculatePremium()
        }
    }

    private fun calculatePremium(){
        var premium: Int = 0
        //position = index of an item selected by user
        val age: Int = spinnerAge.selectedItemPosition
        premium = when(age){
            0 -> 60
            1 -> 70
            2 -> 90
            3 -> 120
            //TODO add the remaining values
            else -> 150
        }

        //ID of a radiobutton checked by user
        val gender: Int = radioGroupGender.checkedRadioButtonId
        if(gender == R.id.radioButtonMale){
            premium += when(age){
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                //TODO add the remaining values
                else -> 200
            }
        }
        else{
        }
        //Boolean value
        val smoker: Boolean = checkBoxSmoker.isChecked
        if(smoker == true){
            premium += when(age){
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                //TODO add the remaining values
                else -> 300
            }
        }

        textViewPremium.text = getString(R.string.premium) + premium.toString()
    }

    fun calculate(view:View?){
        calculatePremium()
    }

    fun resetinput(view: View?){
        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck()
        checkBoxSmoker.setChecked(false)
        textViewPremium.text = getString(R.string.premium)
    }
}
