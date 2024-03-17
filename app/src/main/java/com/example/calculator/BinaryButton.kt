package com.example.calculator

import kotlin.math.roundToInt

class BinaryButton:Button() {
    fun AddBinary(Operator:MutableList<String>,Binary:String){
        Operator.add(Binary);
    }

    fun operate(num1:Double,num2:Double,Operator:MutableList<String>):Double{
        var out=0.0;
        var operator=Operator.removeAt(0);
        if(operator.equals("+")){
            out=((num1+num2)*100).roundToInt()/100.0;
        }
        else if(operator.equals("-")){
            out=((num1-num2)*100).roundToInt()/100.0;
        }
        else if(operator.equals("x")){
            out=(num1*num2*100).roundToInt()/100.0;
        }
        else if(operator.equals("/")){
            out=(num1/num2*100).roundToInt()/100.0;
        }
        else if(operator.equals("=")){
            out=(num1*100).roundToInt()/100.0;
        }
        return out;
    }
}