package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.text_status);
        Button btn_write=findViewById(R.id.button_write);
        Button btn_read=findViewById(R.id.button_read);

        EditText ed1= findViewById(R.id.ed1);
        EditText ed2= findViewById(R.id.ed2);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            SharedPreferences sharedPreferences=getSharedPreferences("StudentInfo",MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("username",ed1.getText().toString());
            editor.putString("email",ed2.getText().toString());
            editor.commit();
            tv.setText("Values are successfully stored");

            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("StudentInfo",MODE_PRIVATE);
                String username,email;
                username=sharedPreferences.getString("username","");
                email=sharedPreferences.getString("email","");
                ed1.setText(username);
                ed2.setText(email);

                tv.setText("Username: " +username+"\n"+"Email: "+email+"\n");
            }
        });
    }
}