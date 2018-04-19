package com.whatoz.application.aphorism;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by muratozbay on 13.04.2018.
 */

public class MainActivity extends AppCompatActivity {

    EditText password;
    EditText userName;
    CheckBox rememberMe;
    TextView forgetPassword;
    Button login;
    TextView newUser;

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        password = (EditText) findViewById(R.id.password);
        userName = (EditText) findViewById(R.id.user_name);
        rememberMe = (CheckBox) findViewById(R.id.checkBox);
        forgetPassword = (TextView) findViewById(R.id.forget_password);
        login = (Button) findViewById(R.id.login_button);
        newUser = (TextView) findViewById(R.id.new_user);


        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: yeni kayıt sayfasına yönlendir
                Intent newUserIntent = new Intent(MainActivity.this, NewUserActivity.class);
                Log.e(TAG, "yeni kullanıcı ekleye tıklandı");
                MainActivity.this.startActivity(newUserIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: kullanıcıyı kontrol edip aforizmanın olacağı sayfaya yönlendir
                Log.e(TAG, "logine tıklandı");
            }
        });

        rememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rememberMe.isChecked()) {
                    // TODO: direk aforizma sayfasına yönlendir
                    Log.e(TAG, "checkbox check edildi");
                }
            }
        });


        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: mail isteyip yeni şifreyi mail atma sayfasına yönlendir
                Log.e(TAG, "şifremi unuttuma tıklandı");
                Intent forgetPasswordIntent = new Intent(MainActivity.this,ForgetPasswordActivity.class);
                MainActivity.this.startActivity(forgetPasswordIntent);
            }
        });
    }
}
