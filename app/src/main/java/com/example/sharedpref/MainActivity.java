package com.example.sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {
    EditText uname, pwd,phn,email;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
   String Phone = "phoneKey";
     String Email = "emailKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = (EditText)findViewById(R.id.txtName);
        phn = (EditText)findViewById(R.id.phn);
        email = (EditText)findViewById(R.id.email);
        pwd = (EditText)findViewById(R.id.txtPwd);
        loginBtn = (Button)findViewById(R.id.btnLogin);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(MainActivity.this,DetailsActivity.class);
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String Ph = phn.getText().toString();
               String mail = email.getText().toString();
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                if(username != null){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.putString(Phone,Ph);
                    editor.putString(Email,mail);


                    editor.apply();
                    Toast.makeText(getApplicationContext(), "Login Successful", LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid", LENGTH_SHORT).show();
                }
            }
        });
    }
}