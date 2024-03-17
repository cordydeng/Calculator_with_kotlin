package com.example.calculator

class ExecuteButton :Button() {
    fun clear(InputList:MutableList<String>,Operator:MutableList<String>){
        InputList.clear();
        Operator.clear()
    }

    fun equalSign(Operator: MutableList<String>){
        Operator.add("=");
    }
}