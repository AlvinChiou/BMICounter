package com.example.BMICounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText etHeight;
    private EditText etWeight;
    private Button btnSubmit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();
    }
    public void findViews(){
        etHeight = (EditText)findViewById(R.id.etHeight);
        etWeight = (EditText)findViewById(R.id.etWeight);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bmi BMI = new Bmi(Double.parseDouble(etHeight.getText().toString()),
                        Double.parseDouble(etWeight.getText().toString()));
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Result.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Bmi", BMI);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
