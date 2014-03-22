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
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Result.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("height", etHeight.getText().toString());

            }
        });
    }
}
