package com.example.challengeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContent extends AppCompatActivity implements View.OnClickListener {

    EditText location,number,name,website;
    ImageView ivSad,ivOk,ivHappy;
    public static String PREFERENCE =  "may Preferences";
    public static String NAME ="name";
    public static String PHONE = "4234";
    public static String LOCATION = "loc";
    public static String WEB = "web";
    public static String MODE = "mode";
    public static String HAPPY = "happy";
    public static String SAD = "sad";
    public static String OK = "ok";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);
        location=(EditText)findViewById(R.id.location);
        name=(EditText)findViewById(R.id.name);
        number=(EditText)findViewById(R.id.number);
        website=(EditText)findViewById(R.id.website);
        ivHappy=(ImageView)findViewById(R.id.ivHappy);
        ivOk=(ImageView)findViewById(R.id.ivOk);
        ivSad=(ImageView)findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(this);
        ivSad.setOnClickListener(this);
        ivOk.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if (location.getText().toString().isEmpty()||website.getText().toString().isEmpty()||number.getText().toString().isEmpty()||name.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();

        }else {

            SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();


            editor.putString(NAME,name.getText().toString().trim());
            editor.putString(PHONE,number.getText().toString().trim());
            editor.putString(LOCATION,location.getText().toString().trim());
            editor.putString(WEB,website.getText().toString().trim());
            editor.commit();
            if (v.getId() == R.id.ivHappy){
                editor.putString(MODE,HAPPY);


            }else if (v.getId() == R.id.ivSad){
                editor.putString(MODE,SAD);

            }else  {
                editor.putString(MODE,OK);

            }
            editor.commit();

            CreateContent.this.finish();

        }

    }
}
