package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var textViewDisplay : TextView
    val calculatorBrain = CalculatorBrain()
    var isInTheMiddleOfIntroduction = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)
        findViewById<Button>(R.id.button0)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button1)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button2)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button3)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button4)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button5)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button6)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button7)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button8)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.button9)
            .setOnClickListener(onClickNumber)
        findViewById<Button>(R.id.buttonDot)
            .setOnClickListener(onClickNumber)

        findViewById<Button>(R.id.buttonAC)
            .setOnClickListener {
                textViewDisplay.text = "0"
                isInTheMiddleOfIntroduction = false
                calculatorBrain.clear()
            }

        findViewById<Button>(R.id.buttonPlus)
            .setOnClickListener(this)
        findViewById<Button>(R.id.buttonMinus)
            .setOnClickListener(this)
        findViewById<Button>(R.id.buttonMultiply)
            .setOnClickListener(this)
        findViewById<Button>(R.id.buttonDivision)
            .setOnClickListener(this)

        findViewById<Button>(R.id.buttonEqual)
            .setOnClickListener{
                if (calculatorBrain
                        .doBinaryOperation(
                            textViewDisplay.text.toString().toDouble()))
                {
                    textViewDisplay.text = calculatorBrain.operand.toString()
                    isInTheMiddleOfIntroduction = false
                    calculatorBrain.operand =  null
                }
            }
    }

    var onClickNumber : ((view: View)->Unit) = {
        val buttonClicked = it as Button
        if (isInTheMiddleOfIntroduction) {
            if (!(buttonClicked.text == "." &&
                        textViewDisplay.text.contains("."))
            ) {
                if (textViewDisplay.text == "0") {
                    if (buttonClicked.text == ".") {
                        textViewDisplay.text = "0."
                    } else {
                        textViewDisplay.text = buttonClicked.text
                    }
                } else {
                    textViewDisplay.text =
                        textViewDisplay.text.toString() + buttonClicked.text
                }
            }
        }else{
            if (buttonClicked.text == ".") {
                textViewDisplay.text = "0."
            }else{
                textViewDisplay.text = buttonClicked.text
            }
        }
        isInTheMiddleOfIntroduction = true
    }

    override fun onClick(view: View?) {
        if (calculatorBrain
                .doBinaryOperation(
                    textViewDisplay.text.toString().toDouble()))
        {
            textViewDisplay.text = calculatorBrain.operand.toString()
        }else{
            calculatorBrain.operand =
                textViewDisplay.text.toString().toDouble()
        }

        val buttonClicked = view as Button
        val operator = when (buttonClicked.text) {
            "+" -> { Operator.add }
            "-" -> { Operator.subtract }
            "*" -> { Operator.multiply }
            "/" -> { Operator.divide }
            else -> {
                Operator.add
            }
        }
        calculatorBrain.operator = operator


        isInTheMiddleOfIntroduction=false





    }


}