package com.example.project4_5currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double usDollars;

    double EUR = 0.91140;
    double MXN = 23.5772;
    double CAD = 1.39032;

    double convertedResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final RadioButton exchangeEUR = (RadioButton) findViewById(R.id.rBEuros);
        final RadioButton exchangeMXN = (RadioButton) findViewById(R.id.rBMexicanPesos);
        final RadioButton exchangeCAD = (RadioButton) findViewById(R.id.rBCanadianDollars);
        final EditText inPut = (EditText) findViewById(R.id.txtInput);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button calculate = (Button)findViewById(R.id.btnCovert);
        calculate.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usDollars = Double.parseDouble(inPut.getText().toString());

                DecimalFormat usCurrency = new DecimalFormat("$ #,###.##");
                DecimalFormat eurCurrency = new DecimalFormat("#,###.## €");
                DecimalFormat mxnCurrency = new DecimalFormat("Mex$ #,###.##");
                DecimalFormat cadCurrency = new DecimalFormat("CA$ #,###.##");


                if (usDollars < 100000){

                    if (exchangeEUR.isChecked()){
                        convertedResult = usDollars * EUR;
                        result.setText(usCurrency.format(usDollars) + " in US Currency is \n" +
                                eurCurrency.format(convertedResult) + " in EUR Currency.");
                    }
                    else if (exchangeMXN.isChecked()){
                        convertedResult = usDollars * MXN;
                        result.setText(usCurrency.format(usDollars) + " in US Currency is \n" +
                                mxnCurrency.format(convertedResult) + " in MXN Currency.");

                    }
                    else if (exchangeCAD.isChecked()){
                        convertedResult = usDollars * CAD;
                        result.setText(usCurrency.format(usDollars) + " in US Currency is \n" +
                                cadCurrency.format(convertedResult) + " in CAD Currency.");

                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please Select Exchange Currency.",
                                Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Only Convert Values Below $100,000.",
                            Toast.LENGTH_LONG).show();
                }
            }
        }));
    }
}
