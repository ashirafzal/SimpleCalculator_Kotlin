package com.kotlin_calculator_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.butons.*
import kotlinx.android.synthetic.main.screen.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

                            /*Created by AshirAfzal on Feb-26-2019*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


                            // Number Buttons Coding
        tvOne.setOnClickListener{appendOnExpression("1",  true)}
        tvTwo.setOnClickListener{appendOnExpression("2",  true)}
        tvThree.setOnClickListener{appendOnExpression("3",  true)}
        tvFour.setOnClickListener{appendOnExpression("4",  true)}
        tvFive.setOnClickListener{appendOnExpression("5",  true)}
        tvSix.setOnClickListener{appendOnExpression("6",  true)}
        tvSeven.setOnClickListener{appendOnExpression("7",  true)}
        tvEight.setOnClickListener{appendOnExpression("8",  true)}
        tvNine.setOnClickListener{appendOnExpression("9",  true)}
        tvZero.setOnClickListener{appendOnExpression("0",  true)}
        tvdot.setOnClickListener{appendOnExpression(".",  true)}


                            // Operators Buttons Coding

        tvPlus.setOnClickListener{appendOnExpression("+",  false)}
        tvMinus.setOnClickListener{appendOnExpression("-",  false)}
        tvMul.setOnClickListener{appendOnExpression("*",  false)}
        tvDivide.setOnClickListener{appendOnExpression("/",  false)}
        tvOpen.setOnClickListener{appendOnExpression("(",  false)}
        tvClose.setOnClickListener{appendOnExpression(")",  false)}

        /* Setting tvEpression the receiver of the Text and tvResult the resultant
        of the text to no value(null)
         */

        tvClear.setOnClickListener{
            tvExpression.text= ""
            tvResult.text = ""
        }

        /* Setting tvEpression tto a string by declaring and then checking if its empty or not
        if it is empty it will do nothing but if tis not empty  it will minus the last expression of
        the string and then setting result to null that there is no value to interrupt the clean view
        of the both tvEpression and tvResult
         */

        tvBack.setOnClickListener{
            val  string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring( 0,string.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener{
            try{

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result ==  longResult.toDouble()){
                    tvResult.text = longResult .toString()

                }else{
                    tvResult.text = result.toString()
                }

            }catch(e:Exception){
                Log.d("Exception" ,"message : " + e.message)
            }
        }

    }

    fun appendOnExpression(string: String ,canClear: Boolean ){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }
        if(canClear){

            tvResult.text = ""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }


}