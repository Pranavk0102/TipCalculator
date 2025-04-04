package com.example.tip_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etBillAmount;
    private RadioGroup radioGroup;
    private Button btnCalculate;
    private TextView tvTipAmount;
    private TextView tvTotalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBillAmount = findViewById(R.id.etBillAmount);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvTipAmount = findViewById(R.id.tvTipAmount);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        String billInput = etBillAmount.getText().toString().trim();

        if (billInput.isEmpty()) {
            Toast.makeText(this, "Please enter the bill amount", Toast.LENGTH_SHORT).show();
            return;
        }

        double billAmount = Double.parseDouble(billInput);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        double tipPercentage = 0;
        if (selectedId == R.id.rbTip2) {
            tipPercentage = 2;
        } else if (selectedId == R.id.rbTip5) {
            tipPercentage = 5;
        } else if (selectedId == R.id.rbTip10) {
            tipPercentage = 10;
        } else if (selectedId == R.id.rbTip20) {
            tipPercentage = 20;
        }

        double tipAmount = (billAmount * tipPercentage) / 100;
        double totalAmount = billAmount + tipAmount;

        tvTipAmount.setText(String.format("Tip Amount: ₹%.2f", tipAmount));
        tvTotalAmount.setText(String.format("Total Amount: ₹%.2f", totalAmount));

        Toast.makeText(this, "You have successfully calculated your tip amount", Toast.LENGTH_SHORT).show();
    }
}
