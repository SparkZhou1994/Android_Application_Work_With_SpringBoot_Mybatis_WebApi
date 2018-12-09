package com.a1321386zhoujuhui.myapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/11/27.
 */

public class Input extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.input);
        Button btInputScr =(Button)findViewById(R.id.btInputScr);
        btInputScr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = openOrCreateDatabase("scr.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
                String sql="create table scr(num integer primary key,scr integer)";
                db.execSQL(sql);
                int num = Integer.valueOf(((EditText)findViewById(R.id.editTextNum)).getText().toString());
                int scr= Integer.valueOf(((EditText)findViewById(R.id.editTextScr)).getText().toString());
                String sqlInsert="insert into scr values(?,?)";
                ContentValues input=new ContentValues();
                input.put("num",num);
                input.put("scr",scr);
                db.insert(sqlInsert,null,input);
            }
        });

        Button btBackMain =(Button) findViewById(R.id.btBackMain);
        btBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Input.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
