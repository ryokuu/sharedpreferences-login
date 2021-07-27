package com.nooryoku.uasmoopkasus1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements Validation{

    EditText username, password, repassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        repassword = findViewById(R.id.et_repassword);

        register = findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });

    }

    private void saveData(){

        String uname = username.getText().toString();
        String pwd = password.getText().toString();
        String repwd = repassword.getText().toString();

        if(isNotNull()) {
            if (checkUsername(uname)){
                username.setError("user already exist!");
            }
            else if (!checkPass(pwd,repwd)){
                password.setError("password doesn't match");
            }
            else {
                Preferences.setRegisteredUser(getBaseContext(),uname);
                Preferences.setRegisteredPass(getBaseContext(),pwd);
                Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

                // kembali ke halaman login setelah data di save
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        }
    }

    @Override
    public void input(EditText txt, String s) {
        txt.setError(s+ " tidak boleh kosong");
        txt.requestFocus();
    }

    @Override
    public boolean isNotNull() {
        // check input form tidak kosong
        if (username.getText().toString().isEmpty()){
            input(username, "username");
            return false;
        }if (password.getText().toString().isEmpty()) {
            input(password, "password");
            return false;
        }if (repassword.getText().toString().isEmpty()){
            input(repassword, "confirm password");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUsername(String user) {
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }

    //cek jika password pertama dan kedua sama
    public boolean checkPass(String password, String repassword){
        return password.equals(repassword);
    }
}

//    // muncul error pada text form
//    public void input(EditText txt, String s){
//        txt.setError(s+ " tidak boleh kosong");
//        txt.requestFocus();
//    }
//    public boolean inputValidation(){
//        // check input form tidak kosong
//        if (username.getText().toString().isEmpty()){
//            input(username, "username");
//            return false;
//        }if (password.getText().toString().isEmpty()) {
//            input(password, "password");
//            return false;
//        }if (repassword.getText().toString().isEmpty()){
//            input(repassword, "confirm password");
//            return false;
//        }
//        return true;
//    }
//
//    //cek jika username sudah ada
//    public boolean checkUsername(String user){
//        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
//    }
//

