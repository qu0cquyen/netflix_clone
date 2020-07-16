package com.example.netflix_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.androidessence.lib.RichTextView;

public class LoginScreen extends AppCompatActivity {

    private RichTextView txtRichText;
    private Button btnSigin;
    private EditText txtPassword;

    void init(){
        txtRichText = findViewById(R.id.txtRichText);
        btnSigin = findViewById(R.id.btnSignin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Initialize components
        init();

        // Bold text at a certain point of String
        // formatSpan(start Index, end Index, textStyle//(FORMAT))
        txtRichText.formatSpan(txtRichText.getText().toString().indexOf("Learn more"),
                txtRichText.getText().length(),
                RichTextView.FormatType.BOLD);

        // Navigate to Home Screen
        btnSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(LoginScreen.this, HomeScreen.class);
                // Extra info can be passed through homeIntent variable.
                startActivity(homeIntent);
            }
        });


    }
}