package com.example.rajakakamall.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.rajakakamall.R;

public class RegisterActivity extends AppCompatActivity {
    private Button createAccount;
    private EditText userName,mobNumber,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createAccount=(Button)findViewById(R.id.register_createaccountbtn);
        mobNumber=(EditText)findViewById(R.id.register_mob_number);
        password=(EditText)findViewById(R.id.register_password);
    }
}
