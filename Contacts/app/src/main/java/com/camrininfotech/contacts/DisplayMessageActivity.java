package com.camrininfotech.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.USERNAME);
        String password=intent.getStringExtra(MainActivity.PASSWORD);
        assert message != null;
        if(message.equals("jerald")){
    TextView textView = findViewById(R.id.textView);
    textView.setText("jacob");
    TextView textView1=findViewById(R.id.textView1);
    textView1.setText(password);
}
else{
    TextView textView = findViewById(R.id.textView);
    textView.setText("Not a valid user");
    TextView textView1=findViewById(R.id.textView1);
    textView1.setText(password);
}
        // Capture the layout's TextView and set the string as its text

    }
}
