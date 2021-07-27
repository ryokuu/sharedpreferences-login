package com.nooryoku.uasmoopkasus1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements Validation{
    EditText username, password;
    Button login, register;
    //untuk import check method
    RegisterActivity validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNotNull()){
                    login();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });


    }

    private void login(){

        String uname = username.getText().toString();
        String pwd = password.getText().toString();

        if(!checkUsername(uname) || !checkPass(pwd)){
            Toast.makeText(this, "Data salah", Toast.LENGTH_SHORT).show();
            if(checkUsername(uname)&& !checkPass(pwd)){
                password.setError("Password salah!");
            }
            else if(!checkUsername(uname)){
                username.setError("Username tidak ditemukan!");
            }
        }
        else{
            //jika data sesuai maka akan masuk ke halaman utama
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            Toast.makeText(this, "Welcome back.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void input(EditText txt, String s) {
        txt.setError(s+ " tidak boleh kosong");
        txt.requestFocus();
    }

    @Override
    public boolean isNotNull() {
         //check input form tidak kosong
        if (username.getText().toString().isEmpty()){
            input(username, "username");
            return false;
        }if (password.getText().toString().isEmpty()) {
            input(password, "password");
            return false;
        }
        return true;
    }

    @Override
    //jika username terdaftar
    public boolean checkUsername(String user) {
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }

    //jika password benar
    public boolean checkPass(String password) {
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }
}
//
//    public void input(EditText txt, String s){
//        txt.setError(s+ " tidak boleh kosong");
//        txt.requestFocus();
//    }
//    public boolean isNotNull(){
//        // check input form tidak kosong
//        if (username.getText().toString().isEmpty()){
//            input(username, "username");
//            return false;
//        }if (password.getText().toString().isEmpty()) {
//            input(password, "password");
//            return false;
//        }
//        return true;
//    }
//
//    public boolean checkUsername(String user){
//        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
//    }
//
//    private boolean checkPass(String password){
//        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
//    }
