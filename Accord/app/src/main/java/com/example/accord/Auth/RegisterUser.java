package com.example.accord.Auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.accord.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class RegisterUser extends AppCompatActivity {
    String name = null;
    int pincode = 0;
    String Phone = "";
    String password;
    String email, add1 = null, area = null, city = null;
    private int RC_SIGN_IN = 1;
    private long backPressedTime;
    private Toast backToast;
    boolean emailSent = false;
    int flag = 0;
    EditText textInput;
    EmailAuth emailAuth = new EmailAuth();
    public Button signInButton;
    Activity self;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        self = this;
       Button registerButton=(Button) findViewById(R.id.button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              NewUser();
            }
        });
    }

    public void registerUser(View view) {


        int flag = 1;
        TextView textView = (TextView) findViewById(R.id.inputName);
        name = textView.getText().toString();

        textView = (TextView) findViewById(R.id.inputNumber);
        Phone = textView.getText().toString();

        textView = (TextView) findViewById(R.id.inputZip);
        pincode = Integer.parseInt(textView.getText().toString());



        textView = (TextView) findViewById(R.id.inputAdd1);
        add1 = textView.getText().toString();

        textView = (TextView) findViewById(R.id.inputArea);
        area = textView.getText().toString();

        textView = (TextView) findViewById(R.id.inputCity);
        city = textView.getText().toString();



        if (name.length() == 0) {
            flag = 0;
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_LONG).show();
        } else if (Phone.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter Phone", Toast.LENGTH_LONG).show();
        } else if (email.length() == 0) {
            flag = 0;
            Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_LONG).show();
        } else if (String.valueOf(pincode).length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter Pincode", Toast.LENGTH_LONG).show();
        } else if (add1.length() == 0) {
            flag = 0;
            Toast.makeText(getApplicationContext(), "EnterAddress line 1", Toast.LENGTH_LONG).show();
        } else if (area.length() == 0) {
            flag = 0;
            Toast.makeText(getApplicationContext(), "Enter the Date of Complaint", Toast.LENGTH_LONG).show();
        } else if (city.length() == 0) {
            flag = 0;
            Toast.makeText(getApplicationContext(), "Enter city", Toast.LENGTH_LONG).show();
        } else if (password.length() == 0) {
            flag = 0;
            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_LONG).show();
        }
        if (flag == 1) {

              //NewUser();
//            Intent intent = new Intent(getApplicationContext(),.class);
//            startActivity(intent);
//            finish();
//            // Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();   //to add intent of next activity of user i.e. email verification page
        }


    }

    public void NewUser() {

        TextView textView;
        textView = (TextView) findViewById(R.id.inputEmail);
        email = textView.getText().toString();
        textView = (TextView) findViewById(R.id.inputPass);
        password = textView.getText().toString();

                if (emailSent) {
                    final FirebaseUser user = emailAuth.mAuth.getCurrentUser();
                    assert user != null;
                    user.reload().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (user.isEmailVerified()) {
                                Toast.makeText(getBaseContext(), "Verified", Toast.LENGTH_SHORT).show();
                                // got to dashboard
                                //navigate ahead to Profile Page
                            } else {
                                Toast.makeText(getBaseContext(), "Not Verified", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    //text input
                    if (email == null || email.length() < 1) {
                        Toast.makeText(getBaseContext(), "Email Empty", Toast.LENGTH_SHORT).show();
                    } else if (password.length() < 1) {
                        Toast.makeText(getBaseContext(), "Password Empty", Toast.LENGTH_SHORT).show();

                    } else {

                        emailSent = true;
                        emailAuth.registerUser(email, password, self);
                    }


                }

                // email link
            }



}
