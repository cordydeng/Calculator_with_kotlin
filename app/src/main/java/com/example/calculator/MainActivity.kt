package com.example.calculator

import android.media.VolumeShaper.Operation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Math

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num1=0.0;
        var num2=0.0;
        var numbtn=NumberButton();
        var uniarybtn=UniaryButton();
        var binarybtn=BinaryButton();
        var exebtn=ExecuteButton();

        var InputList= mutableListOf<String>();
        var Operator= mutableListOf<String>();

        var resultText=findViewById<TextView>(R.id.resultText);
        resultText.setText("");

        var clearBtn=findViewById<Button>(R.id.ClearBtn);
        clearBtn.setOnClickListener(){
            resultText.setText("");
            exebtn.clear(InputList,Operator);
        }

        var Btn1=findViewById<Button>(R.id.btn1);
        Btn1.setOnClickListener(){
            numbtn.AddInput(InputList,"1");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn2=findViewById<Button>(R.id.btn2);
        Btn2.setOnClickListener(){
            numbtn.AddInput(InputList,"2");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn3=findViewById<Button>(R.id.btn3);
        Btn3.setOnClickListener(){
            numbtn.AddInput(InputList,"3");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn4=findViewById<Button>(R.id.btn4);
        Btn4.setOnClickListener(){
            numbtn.AddInput(InputList,"4");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn5=findViewById<Button>(R.id.btn5);
        Btn5.setOnClickListener(){
            numbtn.AddInput(InputList,"5");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn6=findViewById<Button>(R.id.btn6);
        Btn6.setOnClickListener(){
            numbtn.AddInput(InputList,"6");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn7=findViewById<Button>(R.id.btn7);
        Btn7.setOnClickListener(){
            numbtn.AddInput(InputList,"7");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn8=findViewById<Button>(R.id.btn8);
        Btn8.setOnClickListener(){
            numbtn.AddInput(InputList,"8");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn9=findViewById<Button>(R.id.btn9);
        Btn9.setOnClickListener(){
            numbtn.AddInput(InputList,"9");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Btn0=findViewById<Button>(R.id.btn0);
        Btn0.setOnClickListener(){
            numbtn.AddInput(InputList,"0");
            resultText.setText(numbtn.PrintOnScreen(InputList));
        }

        var Plus=findViewById<Button>(R.id.plus);
        Plus.setOnClickListener(){
            if(Operator.isEmpty()){
                binarybtn.AddBinary(Operator,"+");
                num1=uniarybtn.ParseNumber(InputList);
                resultText.setText(num1.toString());
            }
            else{
                binarybtn.AddBinary(Operator,"+");
                num2=uniarybtn.ParseNumber(InputList);
                num1=binarybtn.operate(num1.toDouble(),num2.toDouble(),Operator).toDouble();
                resultText.setText(num1.toString());
                num2=0.0;
            }
        }

        var Minus=findViewById<Button>(R.id.minus);
        Minus.setOnClickListener(){
            if(Operator.isEmpty()){
                binarybtn.AddBinary(Operator,"-");
                num1=uniarybtn.ParseNumber(InputList);
                resultText.setText(num1.toString());
            }
            else{
                binarybtn.AddBinary(Operator,"-");
                num2=uniarybtn.ParseNumber(InputList);
                num1=binarybtn.operate(num1.toDouble(),num2.toDouble(),Operator).toDouble();
                resultText.setText(num1.toString());
                num2=0.0;
            }
        }

        var Multiple=findViewById<Button>(R.id.multiple);
        Multiple.setOnClickListener(){
            if(Operator.isEmpty()){
                binarybtn.AddBinary(Operator,"x");
                num1=uniarybtn.ParseNumber(InputList);
                resultText.setText(num1.toString());
            }
            else{
                binarybtn.AddBinary(Operator,"x");
                num2=uniarybtn.ParseNumber(InputList);
                num1=binarybtn.operate(num1.toDouble(),num2.toDouble(),Operator).toDouble();
                resultText.setText(num1.toString());
                num2=0.0;
            }
        }

        var Divide=findViewById<Button>(R.id.divide);
        Divide.setOnClickListener(){
            if(Operator.isEmpty()){
                binarybtn.AddBinary(Operator,"/");
                num1=uniarybtn.ParseNumber(InputList);
                resultText.setText(num1.toString());
            }
            else{
                binarybtn.AddBinary(Operator,"/");
                num2=uniarybtn.ParseNumber(InputList);
                num1=binarybtn.operate(num1.toDouble(),num2.toDouble(),Operator).toDouble();
                resultText.setText(num1.toString());
                num2=0.0;
            }
        }

        var root=findViewById<Button>(R.id.root);
        root.setOnClickListener(){
            uniarybtn.AddUniary(InputList,"√");
            resultText.setText(uniarybtn.PrintOnScreen(InputList));
        }

        var sin=findViewById<Button>(R.id.sin);
        sin.setOnClickListener(){
            uniarybtn.AddUniary(InputList,"sin");
            resultText.setText(uniarybtn.PrintOnScreen(InputList));
        }

        var cos=findViewById<Button>(R.id.cos);
        cos.setOnClickListener(){
            uniarybtn.AddUniary(InputList,"cos");
            resultText.setText(uniarybtn.PrintOnScreen(InputList));
        }

        var log=findViewById<Button>(R.id.log);
        log.setOnClickListener(){
            uniarybtn.AddUniary(InputList,"log");
            resultText.setText(uniarybtn.PrintOnScreen(InputList));
        }

        var factorial=findViewById<Button>(R.id.factorial);
        factorial.setOnClickListener(){
            uniarybtn.AddUniary(InputList,"!");
            resultText.setText(uniarybtn.PrintOnScreen(InputList));
        }

        var reciprocal=findViewById<Button>(R.id.reciprocal);
        reciprocal.setOnClickListener(){
            uniarybtn.AddUniary(InputList,"1/");
            resultText.setText(uniarybtn.PrintOnScreen(InputList));
        }

        var equal=findViewById<Button>(R.id.equal);
        equal.setOnClickListener(){
            if(Operator.isEmpty()){
                exebtn.equalSign(Operator);
                num1=uniarybtn.ParseNumber(InputList);
                resultText.setText(num1.toString());
            }
            else{
                exebtn.equalSign(Operator);
                num2=uniarybtn.ParseNumber(InputList);
                num1=binarybtn.operate(num1.toDouble(),num2.toDouble(),Operator).toDouble();
                resultText.setText(num1.toString());
                num2=0.0;
            }
            resultText.setText(num1.toString());
        }
    }
}