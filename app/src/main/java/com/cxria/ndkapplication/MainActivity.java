package com.cxria.ndkapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import adapter.GVAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private GridView mGridView;
    private String result="";

    static {
        System.loadLibrary("hello");
    }

    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv_show_result);
        mTvContent = (TextView)findViewById(R.id.tv_show_content);
        mGridView = (GridView) findViewById(R.id.gv_number);
        GVAdapter gvAdapter=new GVAdapter(this);
        mGridView.setAdapter(gvAdapter);
        setListener();
    }

    private void setListener() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    // 1
                    case 0:
                        result+="1";
                        break;
                    // 2
                    case 1:
                        result+="2";
                      break;
                    // 3
                    case 2:
                        result+="3";
                        break;
                    // +
                    case 3:
                        if(result.length()>1&&!result.contains("+")&&!result.contains("-")&&!result.contains("*")&&!result.contains("/")){
                            result+="+";
                        }
                        break;
                    // 4
                    case 4:
                        result+="4";
                        break;
                    // 5
                    case 5:
                        result+="5";
                        break;
                    // 6
                    case 6:
                        result+="6";
                        break;
                    // -
                    case 7:
                        if(result.length()>1&&!result.contains("+")&&!result.contains("-")&&!result.contains("*")&&!result.contains("/")){

                            result+="-";
                        }
                        break;
                    // 7
                    case 8:
                        result+="7";
                        break;
                    // 8
                    case 9:
                        result+="9";
                        break;
                    // 9
                    case 10:
                        result+="10";
                        break;
                    // *
                    case 11:
                        if(result.length()>1&&!result.contains("+")&&!result.contains("-")&&!result.contains("*")&&!result.contains("/")){
                            result+="*";
                        }
                        break;
                    // 0
                    case 12:
                        result+="0";
                        break;
                    // .
                    case 13:
                        if(result.length()>1){
                            String substring = result.substring(result.length()-1, result.length());
                            if(!substring.equals(".")&&!substring.equals("+")&&!substring.equals("-")&&!substring.equals("*")&&!substring.equals("/")){
                                result+=".";
                            }
                        }
                        break;
                    //
                    case 14:
                        getResult();
                        break;
                    // /
                    case 15:
                        if(result.length()>1&&!result.contains("+")&&!result.contains("-")&&!result.contains("*")&&!result.contains("/")){
                            result+="/";
                        }
                        break;
                    // back
                    case 18:
                        if(result.length()>0){
                            result=result.substring(0,result.length()-1);
                        }
                        break;
                    // c
                    case 19:
                        result="";
                        break;
                }
                mTvContent.setText(result);
            }
        });
    }

    private void getResult() {
        String[] splitMinus = result.split("-");
        try {
            if (splitMinus.length == 2) {
                String minus = minus(Double.valueOf(splitMinus[0]), Double.valueOf(splitMinus[1])) + "";
                mTvContent.setText(minus);
                mTextView.setText(minus);
                result = minus;
                return;
            }
            String[] splitAdd = result.split("\\+");
            if (splitAdd.length == 2) {
                String add = add(Double.valueOf(splitAdd[0]), Double.valueOf(splitAdd[1])) + "";
                mTvContent.setText(add);
                mTextView.setText(add);
                result = add;
                return;
            }

            String[] splitMultiply = result.split("\\*");
            if (splitMultiply.length == 2) {
                String multiply = multiply(Double.valueOf(splitMultiply[0]), Double.valueOf(splitMultiply[1])) + "";
                mTvContent.setText(multiply);
                mTextView.setText(multiply);
                result = multiply;
                return;
            }

            String[] splitDivide = result.split("/");
            if (splitDivide.length == 2) {
                String divide = divide(Double.valueOf(splitDivide[0]), Double.valueOf(splitDivide[1])) + "";
                mTvContent.setText(divide);
                mTextView.setText(divide);
                result = divide;
                return;
            }
        }catch (Exception e){
            Toast.makeText(this, "计算出错", Toast.LENGTH_SHORT).show();
        }
    }

    //C语言实现的方法
    public static native double add(double number1,double number2);
    public static native double minus(double number1,double number2);
    public static native double multiply(double number1,double number2);
    public static native double divide(double number1,double number2);

}
