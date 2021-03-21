package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private DatabaseHelper myDB;
    EditText nom;
    EditText mail;
    EditText password;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mail = findViewById(R.id.signupemail);
        nom = findViewById(R.id.signupusername);
        password = findViewById(R.id.siguppassword);

        myDB = new DatabaseHelper(this);


        button = findViewById(R.id.sign_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                boolean var = myDB.registerUser(nom.getText().toString() , mail.getText().toString() , password.getText().toString());
                if(var){
                    Toast.makeText(SignUpActivity.this, "Utilisateur enregistree!!", Toast.LENGTH_SHORT).show();
                }
                else
                    mail.setText("");
                    nom.setText("");
                    password.setText("");
                    Toast.makeText(SignUpActivity.this, "Erreur !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}