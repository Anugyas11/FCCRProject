package com.example.swath.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    private EditText Phone, Message;
    private Button history,button;
    private static List<Model> modelArray=new ArrayList<>();
    private ArrayAdapter<String>adapter;
    private int intentItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button=(Button) findViewById(R.id.button);
        Phone=(EditText) findViewById(R.id.number);
        Message=(EditText) findViewById(R.id.text);
        history=(Button)findViewById(R.id.hist);

        if(getIntent().getExtras()!=null){
            Phone.setText(modelArray.get(intentItemPosition).getPhone());
            Message.setText(modelArray.get(intentItemPosition).getMsg());

        }



        if (ContextCompat.checkSelfPermission(SecondActivity.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(SecondActivity.this,
                    Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(SecondActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            } else {
                ActivityCompat.requestPermissions(SecondActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            }
        } else {
            //do something
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numb= Phone.getText().toString();
                String sms = Message.getText().toString();
                //Intent intent= new Intent(SecondActivity.this,History.class);
                //intent.putExtra("NUMBER",numb);
                //intent.putExtra("TEXT",sms);

                Model modelElement=new Model();
               // public Static List<Model>getModelArray(){
                 //   return modelArray;
                //}

                modelElement.setMsg(Message.getText().toString());
                modelElement.setPhone(Phone.getText().toString());


                try{

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(numb, null, sms, null, null);
                Toast.makeText(SecondActivity.this,"Sent!!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                    Toast.makeText(SecondActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }




                if(sms==null||sms.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Message Field is Empty",Toast.LENGTH_LONG).show();
                }

        }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(SecondActivity.this,
                            Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "No Permission Granted",Toast.LENGTH_SHORT).show();
                }
            } return;
        }
    }

    public void history(View view){
        Intent intent=new Intent (this,History.class);
        startActivity(intent);
    }
}
