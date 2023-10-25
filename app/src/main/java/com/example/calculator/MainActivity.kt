package com.example.calculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
   private lateinit var  expression: TextView
   private lateinit var  result: TextView
   private  lateinit var  clear: Button
    private  lateinit var  clear1: Button
    private  lateinit var  backSpace: Button
    private  lateinit var  divide: Button
    private  lateinit var  multiply: Button
    private  lateinit var  add: Button
    private  lateinit var  subtract: Button
    private  lateinit var  equal: Button
    private  lateinit var  zero: Button
    private  lateinit var  one: Button
    private  lateinit var  two: Button
    private  lateinit var  three: Button
    private  lateinit var  four: Button
    private  lateinit var  five: Button
    private  lateinit var  six: Button
    private  lateinit var  seven: Button
    private  lateinit var  eight: Button
    private  lateinit var  nine: Button
    private  lateinit var  Nho: String
    private  lateinit var  CanCong:String
    private  lateinit var  PhepTinhNho:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expression = findViewById(R.id.PhepTinh)
        result = findViewById(R.id.KetQua)
        backSpace = findViewById(R.id.BtnBS)
        clear = findViewById(R.id.BtnC)
        clear1 = findViewById(R.id.BtnCE)
        divide = findViewById(R.id.BtnChia)
        multiply = findViewById(R.id.BtnNhan)
        add = findViewById(R.id.BtnCong)
        subtract = findViewById(R.id.BtnTru)
        equal = findViewById(R.id.BtnBang)
        zero = findViewById(R.id.Btn0)
        one = findViewById(R.id.Btn1)
        two = findViewById(R.id.Btn2)
        three = findViewById(R.id.Btn3)
        four = findViewById(R.id.Btn4)
        five = findViewById(R.id.Btn5)
        six = findViewById(R.id.Btn6)
        seven = findViewById(R.id.Btn7)
        eight = findViewById(R.id.Btn8)
        nine = findViewById(R.id.Btn9)
        Nho=""
        CanCong=""
        PhepTinhNho=""

        expression.movementMethod = ScrollingMovementMethod();
        expression.isActivated = true;
        expression.isPressed = true;

        result.movementMethod = ScrollingMovementMethod();
        result.isActivated = true;
        result.isPressed = true;

        result.text="0"
        var str: String

        clear.setOnClickListener() {
            expressionText("")
            Nho = ""
            result.text = "0"
            CanCong=""
            PhepTinhNho=""
        }
        clear1.setOnClickListener() {
            result.text = "0"
            CanCong=""
        }
        backSpace.setOnClickListener() {
            if (expression.text.toString().isNotEmpty()) {
                val lastIndex = expression.text.toString().lastIndex
                str = expression.text.toString().substring(0, lastIndex)
                expressionText(str)

            }
        }
        divide.setOnClickListener() {
            CanCong=""
            PhepTinhNho=""
            if (expression.text.toString().endsWith("*") || expression.text.toString().endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                Nho=Nho.dropLast(1)
                Nho+="/"
                expressionText(Nho)
            }
            else if (expression.text.toString().equals("")) {
                Nho = result.text.toString() + "/"
                expressionText(Nho)
                PhepTinhNho = "/" + result.text.toString()
            }
            else {
                resultText()
                Nho=result.text.toString()+"/"
                expressionText(Nho)
            }
        }
        multiply.setOnClickListener() {
            CanCong=""
            PhepTinhNho=""
            if (expression.text.toString().endsWith("*") || expression.text.toString().endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                Nho=Nho.dropLast(1)
                Nho+="*"
                expressionText(Nho)
            }
            else if (expression.text.toString().equals("")) {
                Nho = result.text.toString() + "*"
                expressionText(Nho)
                PhepTinhNho = "*" + result.text.toString()
            }
            else {
                resultText()
                Nho=result.text.toString()+"*"
                expressionText(Nho)
            }
        }
        add.setOnClickListener() {
            CanCong=""
            PhepTinhNho=""
            if (expression.text.toString().endsWith("*") || expression.text.toString().endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                Nho=Nho.dropLast(1)
                Nho+="+"
                expressionText(Nho)
            }
            else if (expression.text.toString().equals("")) {
                Nho = result.text.toString() + "+"
                expressionText(Nho)
                PhepTinhNho = "+" + result.text.toString()
            }
            else {
                resultText()
                Nho=result.text.toString()+"+"
                expressionText(Nho)

            }
        }
        subtract.setOnClickListener() {
            CanCong=""
            PhepTinhNho=""
            if (expression.text.toString().endsWith("*") || expression.text.toString().endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                Nho=Nho.dropLast(1)
                Nho+="-"
                expressionText(Nho)
            }
            else if (expression.text.toString().equals("")) {
                Nho = result.text.toString() + "-"
                expressionText(Nho)
                PhepTinhNho = "-" + result.text.toString()
            }
            else {
                resultText()
                Nho=result.text.toString()+"-"
                expressionText(Nho)
            }
        }
        equal.setOnClickListener() {
            if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")) {
                Nho +=  result.text.toString()
                resultText()
                Nho += "="
                expressionText(Nho)
            }
            else if (expression.text.toString().endsWith("=")) {
                Nho = Nho.dropLast(1)
                Nho = result.text.toString()
                Nho += PhepTinhNho
                resultText()
                Nho+="="
                expressionText(Nho)
                Nho=result.text.toString()

            }
            else if (expression.text.toString().equals("")) {
                Nho=result.text.toString()+"="
                expressionText(Nho)
                resultText()
            }
            else {
                resultText()
                Nho += "="
                expressionText(Nho)
            }

        }
        zero.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "0"
                Nho += "0"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="0"
                result.text=CanCong
                PhepTinhNho += CanCong
            } else {
                result.text = result.text.toString() + "0"
            }
        }
        one.setOnClickListener() {

            if (Nho.endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "1"
                Nho += "1"
            } else if (Nho.endsWith("*") || Nho.endsWith("/")
                || Nho.endsWith("+") || Nho.endsWith("-")
            ) {
                CanCong +="1"
                result.text=CanCong

            } else {
                result.text = result.text.toString() + "1"
            }
        }
        two.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "2"
                Nho += "2"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="2"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "2"
            }
        }
        three.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "3"
                Nho += "3"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="3"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "3"
            }
        }
        four.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "4"
                Nho += "4"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="4"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "4"
            }
        }
        five.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "5"
                Nho += "5"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="5"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "5"
            }
        }
        six.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "6"
                Nho += "6"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="6"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "6"
            }
        }
        seven.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "7"
                Nho += "7"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="7"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "7"
            }
        }
        eight.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "8"
                Nho += "8"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="8"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "8"
            }

        }
        nine.setOnClickListener() {
            if (expression.text.toString().endsWith("=")) {
                Nho = ""
                expressionText("")
                result.text = "9"
                Nho += "9"
            } else if (expression.text.toString().endsWith("*") || expression.text.toString()
                    .endsWith("/")
                || expression.text.toString().endsWith("+") || expression.text.toString()
                    .endsWith("-")
            ) {
                CanCong +="9"
                result.text=CanCong
            } else {
                result.text = result.text.toString() + "9"
            }
        }
    }

    private fun expressionText (str:String) {
        expression.text=str
    }
    private fun calculate(input:String): Float {
        var parsedFloat = ""
        var operator = ""
        var aggregate:Float = 0F
        for (i in input.indices) {
            val c = input[i]
            if (c.isDigit()) {
                parsedFloat += c
            }

            if (!c.isDigit() || i == input.length - 1) {
                val parsed = parsedFloat.toFloat()

                aggregate = when (operator) {
                    "" -> parsed
                    "+" -> (aggregate + parsed)
                    "-" -> (aggregate - parsed)
                    "/"  -> (aggregate/ parsed)
                    "*"  -> (aggregate*parsed)
                    else -> aggregate
                }
                parsedFloat = ""
                operator = c.toString()
            }
        }
        return aggregate
    }
    private fun resultText () {
       var exp = Nho
        if (exp.startsWith("-")) {
            exp="0"+exp
        }
        result.text = calculate(exp).toString()
    }
    }

