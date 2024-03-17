package com.example.calculator

class NumberButton :Button(){

    fun AddInput(InputList:MutableList<String>,Number:String){
        InputList.add(Number);
    }

    fun ParseInt(InputList: MutableList<String>):Int{
        var num=0;
        var len=0;
        if(InputList.isEmpty()){
            num=0;
        }
        else{
            if(InputList[InputList.size-1].equals("!")){
                len=InputList.size-2;
                for(i in 0..InputList.size-2){
                    num+=((InputList[i].toInt())*(Math.pow(10.0, ((len-i).toDouble())))).toInt();
                }
            }
            else if(InputList[0].equals("√")||InputList[0].equals("log")||InputList[0].equals("sin")||InputList[0].equals("cos")||InputList[0].equals("1/")){
                len=InputList.size-1;
                for(i in 1..InputList.size-1){
                    num+=((InputList[i].toInt())*(Math.pow(10.0, ((len-i).toDouble())))).toInt();
                }
            }
            else{
                if(!InputList.contains("√")){
                    len=InputList.size-1;
                    for(i in 0..InputList.size-1) {
                        num += ((InputList[i].toInt()) * (Math.pow(10.0, ((len - i).toDouble())))).toInt();
                    }
                }
            }
        }
        return num;
    }
}