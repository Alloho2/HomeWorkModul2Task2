package com.alloho.homeworkmodul2task2;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private double biscuit = 10.0;
    private double cream = 14.0;
    private double fruits = 3.0;
    private double nuts = 5.0;
    private double berries = 7.0;
    private int biscuitDiscount = 5;
    private int creamDiscount = 5;
    private int fruitsDiscount = 12;
    private int nutsDiscount = 55;
    private int berriesDiscount = 0;
    double balance = 0;

    private double calc(double coin) {
        double count = coin - ((biscuit - (biscuit * biscuitDiscount / 100)) +
                (cream - (cream * creamDiscount / 100)) +
                (fruits - (fruits * fruitsDiscount / 100)) + (nuts - (nuts * nutsDiscount / 100)) +
                (berries - (berries * berriesDiscount / 100)));
        return count;
    }

    private boolean possibility() {
        return calc(balance) >= 0;
    }

    private double change() {
        if (possibility()) {
            return calc(balance);
        } else return -1.0;
    }

    private TextView possibilityOut;
    private TextView balanceOut;
    private EditText textUserBalance;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);
        textUserBalance = findViewById(R.id.userBalance1);
        textUserBalance.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(textUserBalance.getText().toString())) {
                    return;
                }
                balance = Double.parseDouble(textUserBalance.getText().toString());
                if (possibility()) {
                    possibilityOut.setText("Ваших денег достаточно для покупки");
                    balanceOut.setText("остаток Баланса:  " + String.format("%.2f", change()) + " руб");
                } else {
                    possibilityOut.setText("У Вас не хватает денег");
                    balanceOut.setText("---");
                }
            }
        });
    }
}


