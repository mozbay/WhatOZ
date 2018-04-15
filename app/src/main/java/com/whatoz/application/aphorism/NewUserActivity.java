package com.whatoz.application.aphorism;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends Activity {

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

        final EditText password = (EditText) findViewById(R.id.password_new);
        final EditText passwordAgain = (EditText) findViewById(R.id.password_again);
        Button newLogin = (Button) findViewById(R.id. login_new);



        newLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.e(TAG,password.getText().toString());
                Log.e(TAG,passwordAgain.getText().toString());
                passwordString = password.getText().toString();
                newPasswordString = passwordAgain.getText().toString();

               checkPassword(passwordString);
            }
        });
    }

    public boolean checkPassword (String pas) {

        if(pas.equals(newPasswordString)) {
            Log.e(TAG,"true");
            return true;
        } {
            Log.e(TAG,"false");
            return false;
        }
    }
}
