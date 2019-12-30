package com.camrininfotech.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    protected static final String USERNAME = "username";
    protected static  final String PASSWORD="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void send_login_details(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText1=(EditText)findViewById(R.id.editText2);
        String password=editText1.getText().toString();
        String username = editText.getText().toString();
        intent.putExtra(USERNAME, username);
        intent.putExtra(PASSWORD,password);
        startActivity(intent);


    }
}
