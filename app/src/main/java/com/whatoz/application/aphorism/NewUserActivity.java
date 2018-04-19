package com.whatoz.application.aphorism;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {

    EditText email;
    EditText userName;
    EditText password;
    EditText passwordAgain;
    Button newLogin;
    String passwordString = "";
    String newPasswordString = "";
    public static final String TAG = "NewUserActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_layout);

        password = (EditText) findViewById(R.id.password_new);
        passwordAgain = (EditText) findViewById(R.id.password_again);
        newLogin = (Button) findViewById(R.id.login_new);
        email = (EditText) findViewById(R.id.email);
        userName = (EditText) findViewById(R.id.user_name_new);


        newLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, password.getText().toString());
                Log.e(TAG, passwordAgain.getText().toString());
                passwordString = password.getText().toString();
                newPasswordString = passwordAgain.getText().toString();

                Utils.checkTheseEqual(passwordString, newPasswordString);
            }
        });
    }
}
