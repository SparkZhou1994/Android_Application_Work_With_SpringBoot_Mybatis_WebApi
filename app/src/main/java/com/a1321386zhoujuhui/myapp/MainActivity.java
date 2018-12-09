package com.a1321386zhoujuhui.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btInput = (Button) findViewById(R.id.btInput);
        Button btSelect = (Button) findViewById(R.id.btSelect);
        Button btSelectOnOff = (Button) findViewById(R.id.btSelectOnOff);

        btSelectOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectOnOff.class);
                startActivity(intent);
            }
        });

        btInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInput = new Intent(MainActivity.this,Input.class);
                startActivity(intentInput);
            }
        });

        btSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSelect = new Intent(MainActivity.this,Select.class);
                startActivity(intentSelect);
            }
        });
    }
}
