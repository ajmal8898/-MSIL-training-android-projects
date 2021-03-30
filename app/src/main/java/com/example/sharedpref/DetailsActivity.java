package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tutlane on 03-01-2018.
 */

public class DetailsActivity extends AppCompatActivity {
    SharedPreferences prf;
    Intent intent;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView result = (TextView)findViewById(R.id.resultView);
        TextView na = (TextView)findViewById(R.id.usname);
        TextView ph = (TextView)findViewById(R.id.phnam);
        TextView ma = (TextView)findViewById(R.id.usmail);

        Button btnLogOut = (Button)findViewById(R.id.btnLogOut);
        Button btnshow = (Button)findViewById(R.id.show);
        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(DetailsActivity.this,MainActivity.class);
        result.setText("Hello   "+prf.getString("username",null));

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prf.edit();
                na.setText("Username : "+prf.getString("username",null));
                ph.setText("Phone No : "+prf.getString(Phone,null));
                ma.setText("Email : "+prf.getString(Email,null));


                editor.commit();

            }
        });
    }
}