package com.example.challengeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView immode,imlocation,imweb,imphone;
    Button butcreate,ok;
    final int REC = 1;
    String name1 = " ",num1 = "", web1 = "", loc1 = " ",mod = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imlocation = (ImageView) findViewById(R.id.imlocetion);
        immode = (ImageView) findViewById(R.id.immod);
        imphone = (ImageView) findViewById(R.id.imphone);
        imweb = (ImageView) findViewById(R.id.imweb);
        butcreate = (Button) findViewById(R.id.butcreate);
        ok =(Button)findViewById(R.id.OK);

        imweb.setVisibility(View.GONE);
        imphone.setVisibility(View.GONE);
        immode.setVisibility(View.GONE);
        imlocation.setVisibility(View.GONE);

        butcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.challengeintent.CreateContent.class);
                startActivityForResult(intent, REC);

            }
        });


        imlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + loc1));
                startActivity(intent);

            }
        });
        immode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);

            }
        });
        imweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web1));
                startActivity(intent);

            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(CreateContent.PREFERENCE,MODE_PRIVATE);





                        imweb.setVisibility(View.VISIBLE);
                        imphone.setVisibility(View.VISIBLE);
                        immode.setVisibility(View.VISIBLE);
                        imlocation.setVisibility(View.VISIBLE);
                        name1 = sharedPreferences.getString(CreateContent.NAME, "");
                        num1 = sharedPreferences.getString(CreateContent.PHONE, "");
                        loc1 = sharedPreferences.getString(CreateContent.LOCATION, "");
                        web1 = sharedPreferences.getString(CreateContent.WEB, "");
                        mod = sharedPreferences.getString(CreateContent.MODE, "");
                        if (mod.equals(CreateContent.HAPPY)) {
                            immode.setImageResource(R.drawable.hape);
                        } else if (mod.equals(CreateContent.SAD)) {

                            immode.setImageResource(R.drawable.sade);


                        } else {
                            immode.setImageResource(R.drawable.ok);

                        }


                    }




        });


}
}
