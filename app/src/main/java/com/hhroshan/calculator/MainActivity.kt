package com.hhroshan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.grantland.widget.AutofitTextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator
import java.lang.Exception

var factorial: Operator = object:
Operator("!" , 1 ,true , PRECEDENCE_POWER+1) {
    override fun apply(vararg args: Double): Double {
        val arg = args[0].toInt()
        require(arg.toDouble() == args[0]){"Operand for factorial must be an integer"}
        require(arg>=0){"Operand of factorial must not be less than 0"}
        var result = 1.0
        for(i in 1..arg){
            result *= i.toDouble()
        }
        return result

    }

}

class MainActivity : AppCompatActivity() {
    var count: Int = 0
    var c:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var Result = findViewById<AutofitTextView>(R.id.TVOutput)
        var Expression = findViewById<AutofitTextView>(R.id.TVInput)


        val result = ExpressionBuilder("3!").operator(factorial).build().evaluate()




       btn0.setOnClickListener {
           evaluateExpression("0" , true)
       }

        btn1.setOnClickListener {
            evaluateExpression("1", true)
        }

        btn2.setOnClickListener {
            evaluateExpression("2" , true)
        }

        btn3.setOnClickListener {
            evaluateExpression("3" ,true)
        }

        btn4.setOnClickListener {
            evaluateExpression("4" ,true)
        }

        btn5.setOnClickListener {
            evaluateExpression("5" , true)
        }

        btn6.setOnClickListener {
            evaluateExpression("6" , true)
        }

        btn7.setOnClickListener {
            evaluateExpression("7" , true)
        }

        btn8.setOnClickListener {
            evaluateExpression("8" , true)
        }

        btn9.setOnClickListener {
            evaluateExpression("9" , true)
        }

        btndot.setOnClickListener {
            evaluateExpression("." , true)
        }

        btnadd.setOnClickListener {
            evaluateExpression("+" , false)
        }

        btnsub.setOnClickListener {
            evaluateExpression("-" , false)
        }

        btnmul.setOnClickListener {
            evaluateExpression("*" , false)
        }

        btndiv.setOnClickListener {
            evaluateExpression("/" , false)
        }

        btnleftbrace.setOnClickListener {
            evaluateExpression("(" , false)
        }

        btnrightbrace.setOnClickListener {
            evaluateExpression(")" ,false)
        }

        btnsin.setOnClickListener {
            evaluateExpression("sin(" , false)

        }

        btncos.setOnClickListener {
            evaluateExpression("cos(" , false)
            true
        }

        btntan.setOnClickListener {
            evaluateExpression("tan(" , false)
            true
        }

        btnroot.setOnClickListener {
            evaluateExpression("sqrt(" , false)
            true
        }

        btncuberoot.setOnClickListener {
            evaluateExpression("cbrt(" ,false)
            true
        }

        btnpi.setOnClickListener {
            evaluateExpression("π" , false)
            true
        }

        btnfact.setOnClickListener {
            evaluateExpression("!" , false)
            true
        }

        btnlog.setOnClickListener {
            evaluateExpression("log(" , false)
            true
        }

        btnin.setOnClickListener {
            evaluateExpression("log10(" , false)
            true
        }

        btnfrac.setOnClickListener {
            evaluateExpression("1/(" , false)
            true
        }

        btnclr.setOnClickListener {
            Expression.text = ""
            Result.text = ""
            true
        }

        btnc.setOnClickListener {
            val string = Expression.text.toString()
            if(string.isNotEmpty()){
                Expression.text = string.substring(0, string.length -1)
            }
            Result.text=""
        }

        btnequals.setOnClickListener {
            try {
                val expression =
                    ExpressionBuilder(Expression.text.toString()).operator(factorial).build()

                val result = expression.evaluate()

               val longResult = result.toLong()

                if (result == longResult.toDouble())

                  Result.text = longResult.toString()
                else

                    Result.text = result.toString()
            } catch (e: Exception){
                Log.d("Exception" , ""+e.message)

                val error = e.message.toString()

                Result.text = "0"
                Toast.makeText( applicationContext , "" +error , Toast.LENGTH_LONG).show()

            }


            }
        }


    private fun evaluateExpression(string: String, canClear: Boolean){

        val Result = findViewById<AutofitTextView>(R.id.TVOutput)
        val Expression = findViewById<AutofitTextView>(R.id.TVInput)

        if(Result.text.isNotEmpty()){
            Expression.text = ""
        }

        if(canClear){
            Result.text=""
            Expression.append(string)
        }else{
            Expression.append(Result.text)
            Expression.append(string)
            Result.text =""
        }
    }


    }




