package com.example.txon_task_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


    EditText editText;
    TextView textView;
    Button AC,B0,B1,B2,B3,B4,B5,B6,B7,B8,B9,CL,EQUAL,MUL,DIV,PLUS,MIN,MOD,POT,SING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName2);
        textView=findViewById(R.id.textView3);
        assingId(AC,R.id.button);
        assingId(CL,R.id.button2);
        assingId(SING,R.id.button3);
        assingId(DIV,R.id.button9);
        assingId(MUL,R.id.button8);
        assingId(MIN,R.id.button12);
        assingId(MOD,R.id.button17);
        assingId(PLUS,R.id.button16);
        assingId(POT,R.id.button19);
        assingId(EQUAL,R.id.button20);
        assingId(B0,R.id.button18);
        assingId(B1,R.id.button15);
        assingId(B2,R.id.button13);
        assingId(B3,R.id.button14);
        assingId(B4,R.id.button7);
        assingId(B5,R.id.button10);
        assingId(B6,R.id.button11);
        assingId(B7,R.id.button4);
        assingId(B8,R.id.button5);
        assingId(B9,R.id.button6);


    }
    void assingId(Button btn,int id)
    {
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button=(Button) view;
        String buttontext=button.getText().toString();
        String data=editText.getText().toString();

        if(buttontext.equals("AC"))
        {
            editText.setText("");
            textView.setText("");
            return;
        }
        if(buttontext.equals("="))
        {

            textView.setText( editText.getText());
            return;
        }
        if (buttontext.equals("+/-"))
        {

            int  da=Integer.parseInt(data);
            da=da*(-1);
            data=String.valueOf(da);
            editText.setText(data);
            return;

        }

        if(buttontext.equals("CL"))
        {
           if(data.length()>0) {
               data = data.substring(0, data.length() - 1);
           }
           else {
               editText.setText("");
               textView.setText("");
           }
        }
        else
        {
            data = data + buttontext;

        }
        editText.setText(data);
        String finalresult=result(data);
        if(!finalresult.equals("Err"))
        {
            textView.setText(finalresult);
        }
    }
        String result(String data)
        {
            try{
                Context context=Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable=context.initSafeStandardObjects();
                String finalresult =context.evaluateString(scriptable,data,"Javascript",1,null).toString();
                if(finalresult.endsWith(".0"))
                {
                  finalresult=finalresult.replace(".0","");
                }
                return finalresult;
            }


           catch (Exception e)
           {
               return "Err";

          }
        }

}