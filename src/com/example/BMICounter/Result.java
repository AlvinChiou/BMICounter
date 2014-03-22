package com.example.BMICounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class Result extends Activity {
    private TextView tvBmi;
    private TextView tvStatus;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        findViews();
        try {
            showResult();
        } catch (NumberFormatException e) {
            tvStatus.setText(R.string.inputError_IllegalNumberFormat);
        }
    }

    public void showResult() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2); //取小數第二位
        Bundle bundle = this.getIntent().getExtras();
        Bmi BMI = (Bmi) bundle.getSerializable("Bmi");
        double height = BMI.getHeight();
        double weight = BMI.getWeight();
        double bmi = weight / ((height / 100) * (height / 100));
        tvBmi.setText("BMI=" + nf.format(bmi));
        if (bmi > 24) {
            tvStatus.setText(R.string.tooHeavy);
        } else if (bmi < 18.5) {
            tvStatus.setText(R.string.tooThin);
        } else {
            tvStatus.setText(R.string.normal);
        }
    }

    public void findViews() {
        tvBmi = (TextView) findViewById(R.id.tvBmi);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }
}

