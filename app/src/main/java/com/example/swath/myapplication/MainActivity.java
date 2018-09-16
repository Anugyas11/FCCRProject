package com.example.swath.myapplication;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvinfo);
        Login =(Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword) {
        Credentials credentials = Credentials.getInstance();

        if ((userName.equals(credentials.getUsername())) && (userPassword.equals(credentials.getPassword()))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
             startActivity(intent);

        }else {
            counter --;

            Info.setText("No of attempts  :" + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);


            }


        }
    }
    //move this to ChangePasswordActivity
    private void changePassword(String oldPassword, String newPassword, String confirmPassword) {
        Credentials credentials = Credentials.getInstance();

        Credentials credential=(Credentials) getIntent().getSerializableExtra("credential");
        credentials.setPassword(newPassword);
    }

    public void changepassword(View view){
        Intent myIntent= new Intent(this,ChangePassword.class);
        startActivity(myIntent);

    }



}
