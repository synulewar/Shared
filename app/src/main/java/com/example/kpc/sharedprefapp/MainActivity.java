package com.example.kpc.sharedprefapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button sign_in;
    private EditText email_input;
    private EditText password_input;
    private CheckBox remember_username;
    final private String REMEMBER_ME = "remember";
    final private String USERNAME = "user";
    final private  String PASSWORD = "pass";
    final private String CHECKBOX_STATUS = "check";
    final private  String DEFAULT_VALUE = "";
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_in = (Button) findViewById(R.id.sign_in);
        email_input = (EditText) findViewById(R.id.email_input);
        password_input = (EditText) findViewById(R.id.passowrd_input);
        remember_username = (CheckBox) findViewById(R.id.remember_username);


        prefs = getSharedPreferences(REMEMBER_ME, Context.MODE_PRIVATE);

        email_input.setText(prefs.getString(USERNAME, DEFAULT_VALUE));
        password_input.setText(prefs.getString(PASSWORD, DEFAULT_VALUE));
        remember_username.setChecked(prefs.getBoolean(CHECKBOX_STATUS, false));



        sign_in.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (remember_username.isChecked())
                {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(USERNAME,email_input.getText().toString());
                    editor.putString(PASSWORD, password_input.getText().toString());
                    editor.putBoolean(CHECKBOX_STATUS, remember_username.isChecked());
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Log  in", Toast.LENGTH_LONG).show();
                }

            }
        });





    }
}
