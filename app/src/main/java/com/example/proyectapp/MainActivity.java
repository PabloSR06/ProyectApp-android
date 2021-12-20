package com.example.proyectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button entradaButton = (Button) findViewById(R.id.entradaButton);
        Button helpButton = (Button) findViewById(R.id.helpButton);

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHelpAction(v);
            }
        });

        entradaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContinuarAction(v);
            }
        });

    }

    public void onContinuarAction (View vista){
        if (connected()){
            Intent intent= new Intent (this, WebActivity.class);
            startActivity(intent);
        }else{
            goErrorActivity();
        }
    }
    public void goHelpAction (View vista){
        if (connected()){
            Intent intent= new Intent (this, HelpActivity.class);
            startActivity(intent);
        }else{
            goErrorActivity();
        }
    }
    public void goErrorActivity (){
        Intent intent= new Intent (this, ErrorActivity.class);
        intent.putExtra("error_code", 1);
        startActivity(intent);
    }

    private boolean connected(){
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean activo = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            activo = true;
        }
        return activo;
    }


}