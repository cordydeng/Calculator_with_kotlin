package com.example.calculator

open class Button {
    fun PrintOnScreen(InputList:MutableList<String>):String{
        var output="";
        for(i in InputList){
            output+=i;
        }
        return output;
    }
}