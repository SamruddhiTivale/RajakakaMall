package com.example.rajakakamall.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rajakakamall.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {

  private static final String TAG = "PhoneAuth";


  private FirebaseAuth mAuth;
  String otpSent;
  private EditText enterName ,enterPhone, enterOtp;
  private Button sendOtp, loginBtn;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    // Initialize Firebase Auth
    mAuth = FirebaseAuth.getInstance();

    enterName = findViewById(R.id.register_username);
    enterPhone = findViewById(R.id.register_mob_number);
    enterOtp = findViewById(R.id.register_otp);
    sendOtp = findViewById(R.id.get_otp);
    loginBtn = findViewById(R.id.register_signinbtn);

    sendOtp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sendOtp();
      }
    });
    loginBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        verifyOtp();
      }
    });


  }

  private void verifyOtp() {

    String otp = enterOtp.getText().toString();
    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(otpSent, otp);
    signInWithPhoneAuthCredential(phoneAuthCredential);
  }

  private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
    mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
          loginBtn.setEnabled(true);
          enterOtp.setText("");
          FirebaseUser user = task.getResult().getUser();

        } else {
          if (task.getException() instanceof
                  FirebaseAuthInvalidCredentialsException) {
            // The verification code entered was invalid
          }
        }
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
      }
    });
  }

  private void sendOtp() {

    String phoneNumber = "+91" + enterPhone.getText().toString();

    if (phoneNumber.length() < 10) {
      enterPhone.setError("Enter a valid number");
      enterPhone.requestFocus();
      return;

    }
    PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,        // Phone number to verify
            60,                 // Timeout duration
            TimeUnit.SECONDS,   // Unit of timeout
            this,               // Activity (for callback binding)
            mCallbacks);        // OnVerificationStateChangedCallbacks
  }

  PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


    @Override
    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

      loginBtn.setEnabled(true);

        //Getting otp for auto verification
        enterOtp.setText(Objects.requireNonNull(phoneAuthCredential.getSmsCode()));
        signInWithPhoneAuthCredential(phoneAuthCredential);
        Toast.makeText(RegisterActivity.this, "Verified..", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onVerificationFailed(FirebaseException e) {

      if (e instanceof FirebaseAuthInvalidCredentialsException) {
        // Invalid request
        Log.d(TAG, "Invalid credential: "
                + e.getLocalizedMessage());
      } else if (e instanceof FirebaseTooManyRequestsException) {
        // SMS quota exceeded
        Log.d(TAG, "SMS Quota exceeded.");
      }

    }

    @Override
    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
      super.onCodeSent(s, forceResendingToken);

      otpSent = s;
    }
  };

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}