package com.example.calculator

import java.text.DecimalFormat
import kotlin.math.roundToInt

class UniaryButton : Button(){
    val df = DecimalFormat("#.##");
    fun AddUniary(InputList:MutableList<String>,Uniary:String){
        InputList.add(Uniary);
    }

    fun ParseNumber(InputList: MutableList<String>):Double{
        var numbtn=NumberButton();
        var num=0.0;
        if(InputList.isEmpty()){
            num=0.0;
        }
        else if(InputList.contains("√")){
            if(InputList[0].equals("√")){
                num=(Math.pow(numbtn.ParseInt(InputList).toDouble(),0.5)*100).roundToInt()/100.0;
            }
            else{
                var num1 = 0;
                var num2 = 0.0;
                for (i in 0..InputList.size - 1) {
                    if (InputList[i].equals("√")) {
                        var num1Arr = InputList.subList(0, i);
                        for (j in 0..num1Arr.size - 1) {
                            num1 += ((num1Arr[j].toInt()) * (Math.pow(10.0, ((num1Arr.size - j-1).toDouble())))).toInt();
                        }
                        var num2Arr = InputList.subList(i+1, InputList.size);
                        for (j in 0..num2Arr.size - 1) {
                            num2 += ((num2Arr[j].toInt()) * (Math.pow(10.0, ((num2Arr.size - j-1).toDouble())))).toInt();
                        }
                        num2=(Math.pow(num2.toDouble(), 0.5)).toDouble();
                        num = (num1 * num2*100).roundToInt()/100.0;
                        break;
                    }
                }
            }
        }
        else if(InputList.contains("log")){
            if(InputList[0].equals("log")){
                num=(Math.log10(numbtn.ParseInt(InputList).toDouble())*100).roundToInt()/100.0;
            }
            else{
                var num1 = 0;
                var num2 = 0;
                for (i in 0..InputList.size - 1) {
                    if (InputList[i].equals("log")) {
                        var num1Arr = InputList.subList(0, i);
                        for (j in 0..num1Arr.size - 1) {
                            num1 += ((num1Arr[j].toInt()) * (Math.pow(10.0, ((num1Arr.size - j-1).toDouble())))).toInt();
                        }
                        var num2Arr = InputList.subList(i+1, InputList.size);
                        for (j in 0..num2Arr.size - 1) {
                            num2 += ((num2Arr[j].toInt()) * (Math.pow(10.0, ((num2Arr.size - j-1).toDouble())))).toInt();
                        }
                        num = num1 * (Math.log10(num2.toDouble()));
                        break;
                    }
                }
            }
        }
        else if(InputList.contains("sin")){
            if(InputList[0].equals("sin")){
                num=(Math.sin(Math.toRadians(numbtn.ParseInt(InputList).toDouble()))*100).roundToInt()/100.0;
            }
            else{
                var num1 = 0;
                var num2 = 0.0;
                for (i in 0..InputList.size - 1) {
                    if (InputList[i].equals("sin")) {
                        var num1Arr = InputList.subList(0, i);
                        for (j in 0..num1Arr.size - 1) {
                            num1 += ((num1Arr[j].toInt()) * (Math.pow(10.0, ((num1Arr.size - j-1).toDouble())))).toInt();
                        }
                        var num2Arr = InputList.subList(i+1, InputList.size);
                        for (j in 0..num2Arr.size - 1) {
                            num2 += ((num2Arr[j].toInt()) * (Math.pow(10.0, ((num2Arr.size - j-1).toDouble())))).toInt();
                        }
                        num2=Math.sin(Math.toRadians(num2.toDouble()));
                        num = (num1 * num2*100).roundToInt()/100.0;
                        break;
                    }
                }
            }
        }
        else if(InputList.contains("cos")){
            if(InputList[0].equals("cos")){
                num=(Math.cos(Math.toRadians(numbtn.ParseInt(InputList).toDouble()))*100).roundToInt()/100.0;
            }
            else{
                var num1 = 0;
                var num2 = 0.0;
                for (i in 0..InputList.size - 1) {
                    if (InputList[i].equals("cos")) {
                        var num1Arr = InputList.subList(0, i);
                        for (j in 0..num1Arr.size - 1) {
                            num1 += ((num1Arr[j].toInt()) * (Math.pow(10.0, ((num1Arr.size - j-1).toDouble())))).toInt();
                        }
                        var num2Arr = InputList.subList(i+1, InputList.size);
                        for (j in 0..num2Arr.size - 1) {
                            num2 += ((num2Arr[j].toInt()) * (Math.pow(10.0, ((num2Arr.size - j-1).toDouble())))).toInt();
                        }
                        num2=Math.cos(Math.toRadians(num2.toDouble()));
                        num = (num1 * num2*100).roundToInt()/100.0;
                        break;
                    }
                }
            }
        }
        else if(InputList[InputList.size-1].equals("!")){
            num= 1.0;
            if(numbtn.ParseInt(InputList)!=0){
                for(i in 1..numbtn.ParseInt(InputList)){
                    num*=i;
                }
            }
        }
        else if(InputList[0].equals("1/")){
            num=1/(numbtn.ParseInt(InputList).toDouble());
            num=(num*100).roundToInt()/100.0;
        }
        else{
            num = numbtn.ParseInt(InputList).toDouble();
            num=(num*100).roundToInt()/100.0;
        }
        InputList.clear();
        return num;
    }
}