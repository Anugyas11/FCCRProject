package com.example.swath.myapplication;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    }

            public void password(View view)
            {
                changePassword();
            }

        private void changePassword(){
        String newpswrd;
            EditText oldpassword=findViewById(R.id.editText);
            EditText newpassword=findViewById(R.id.editText2);
            EditText currentpassword=findViewById(R.id.editText5);


            Credentials credential = Credentials.getInstance();
            System.out.println(credential.getPassword());

            if(oldpassword.getText().toString().equals(credential.getPassword())){

            if(newpassword.getText().toString().equals(oldpassword.getText().toString()))
            {
                Toast.makeText(getBaseContext(), "Enter the valid password", Toast.LENGTH_SHORT).show();
            }
            else {
                if (!newpassword.getText().toString().equals(currentpassword.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Password does not match with your new password", Toast.LENGTH_SHORT).show();
                } else {
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    newpswrd = newpassword.getText().toString();
                    myIntent.putExtra("newpsrd",newpswrd);
                    startActivity(myIntent);
                    credential.setPassword(newpswrd);
                    }
                }

            }else{
                Toast.makeText(getBaseContext(),"Password does not match",Toast.LENGTH_SHORT).show();
            }











        }
    }
