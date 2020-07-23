package com.example.rajakakamall.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rajakakamall.home.HomePageActivity;
import com.example.rajakakamall.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginLoginBtn;
    private EditText mobNumber,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLoginBtn=(Button)findViewById(R.id.login_loginbtn);
        mobNumber=(EditText)findViewById(R.id.login_mob_number);
        password=(EditText)findViewById(R.id.login_password);


        loginLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });
    }
}
