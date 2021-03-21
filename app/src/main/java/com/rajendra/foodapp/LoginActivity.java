package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button button;
    private  SharedPreferenceConfig sharedPreferenceConfig;
    EditText username;
    EditText password;
    private DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.signupemail);
        password = (EditText) findViewById(R.id.signupusername);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        myDb = new DatabaseHelper(this);


        button = (Button) findViewById(R.id.log_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    private void Login() {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        boolean val = myDb.checkUser(user, pass);
        if(user.equals(getResources().getString(R.string.username)) && pass.equals(getResources().getString(R.string.password))){
            Intent intent = new Intent(LoginActivity.this, HomeGerant.class);
            startActivity(intent);
            sharedPreferenceConfig.login_status(true);
            finish();
        }else {

            if(val){
                Intent intent = new Intent(LoginActivity.this, HomeClientActivity.class);
                startActivity(intent);
                sharedPreferenceConfig.login_status(true);
                finish();
            }else{
                Toast.makeText(this, "Login ou mot de passe invalide", Toast.LENGTH_SHORT).show();
                username.setText("");
                password.setText("");
            }

        }
    }

}