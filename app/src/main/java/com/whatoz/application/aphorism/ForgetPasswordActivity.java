package com.whatoz.application.aphorism;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * Created by muratozbay on 17.04.2018.
 */

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText email;
    EditText emailAgain;
    ProgressBar progressBar;
    Button sendMail;
    String emailString = "";
    String emailAgainString = "";

    public final static String TAG = "ForgetPasswordActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_layout);

        email = (EditText) findViewById(R.id.e_mail);
        emailAgain = (EditText) findViewById(R.id.email_again);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        sendMail = (Button) findViewById(R.id.send_mail_button);

        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailString = email.getText().toString();
                emailAgainString = emailAgain.getText().toString();
                Log.e(TAG, emailAgainString);
                Log.e(TAG, emailString);

                Utils.checkTheseEqual(emailString, emailAgainString);
            }
        });
    }
}
