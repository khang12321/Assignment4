package com.example.project4_1phonephotoprintsapp;

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

    int number;
    double total;
    double cost4X9 = 0.19;
    double cost5X7 = 0.49;
    double cost8X10 = 0.79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final RadioButton photo4X9 = (RadioButton) findViewById(R.id.rB4X6);
        final RadioButton photo5X7 = (RadioButton) findViewById(R.id.rB5X7);
        final RadioButton photo8X10 = (RadioButton) findViewById(R.id.rB8X10);
        final EditText numberOfPrints = (EditText) findViewById(R.id.txtNumberOfPrints);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button calculate = (Button)findViewById(R.id.btnOrder);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = Integer.parseInt(numberOfPrints.getText().toString());
                DecimalFormat usCurrency = new DecimalFormat("$ #,###.##");
                if (number>50){
                    Toast.makeText(MainActivity.this,"Number of Prints must be no more than 50",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    // less or 50
                    if (photo4X9.isChecked()){
                        total = number * cost4X9;
                    }
                    else if (photo5X7.isChecked()){
                        total = number * cost5X7;
                    }
                    else if (photo8X10.isChecked()){
                        total = number * cost8X10;
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Please select photo size.",
                                Toast.LENGTH_LONG).show();
                    }
                    result.setText("The order cost is " + usCurrency.format(total));

                }
            }
        });
    }
}