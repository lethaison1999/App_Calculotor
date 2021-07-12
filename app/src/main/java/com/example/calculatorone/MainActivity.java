package com.example.calculatorone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private String input ,answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv =(TextView) findViewById(R.id.tv);
    }

    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();

        switch (data){
            case "CE":
                input="";
                break;
            case "=":
                Solve();
                answer=input;
                break;
            case "÷":
                Solve();
                input+="/";
            case "×":
                Solve();
                input+="*";
                break;
            default:
                if(input==null){
                    input="";
                }
                if (data.equals("+")|| data.equals("-")|| data.equals("/")){
                    Solve();
                    //in kết quả
                }
                input+=data;
        }
        tv.setText(input);

    }

    public void Solve(){
      if (input.split("\\*").length==2){
          String number[]=input.split("\\*");
          try {
            double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
            input=mul+"";
          }
          catch (Exception e){

          }
      }
        if (input.split("\\/").length==2){
            String number[]=input.split("\\/");
            try {
                double chia=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input=chia+"";
            }
            catch (Exception e){

            }
        }
        if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input=sum+"";
            }
            catch (Exception e){

            }
        }
        if (input.split("\\-").length==2){
            String number[]=input.split("\\-");
            try {
                double Hieu=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input=Hieu+"";
            }
            catch (Exception e){

            }
        }
        //xử lý bỏ dấu 0 trong phép tính
        String n[] = input.split("\\.");
        if(n.length>1){
            if (n[1].equals("0")){
                input=n[0];
            }
        }
    }
}