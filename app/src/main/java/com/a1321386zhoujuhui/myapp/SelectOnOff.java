package com.a1321386zhoujuhui.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.R.attr.visible;

/**
 * Created by Administrator on 2017/11/27.
 */

public class SelectOnOff extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences sp = getSharedPreferences("OnOff",MODE_PRIVATE);
        Boolean state = sp.getBoolean("state",false);

        if(state == false){
            setContentView(R.layout.select_off);
            Button on = (Button) findViewById(R.id.btOn);
            on.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("OnOff",true);
                    Button btSelect = (Button) findViewById(R.id.btSelect);
                    btSelect.setVisibility(View.VISIBLE);
                }
            });

            Button back = (Button) findViewById(R.id.btBack);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectOnOff.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        }else{
            setContentView(R.layout.select_on);
            Button off = (Button) findViewById(R.id.btOff);
            off.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("OnOff",false);
                    Button btSelect = (Button) findViewById(R.id.btSelect);
                    btSelect.setVisibility(View.INVISIBLE);
                }
            });

            Button back = (Button) findViewById(R.id.btBack);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectOnOff.this,MainActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}
