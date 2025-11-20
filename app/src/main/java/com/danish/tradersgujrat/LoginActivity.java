package com.danish.tradersgujrat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> {
            if ((username.getText().toString().equals("admin") && password.getText().toString().equals("admin123"))
                    || (username.getText().toString().equals("salesman") && password.getText().toString().equals("1234"))) {
                startActivity(new Intent(this, MainActivity.class));
            } else {
                username.setError("Invalid Credentials");
            }
        });
    }
}
