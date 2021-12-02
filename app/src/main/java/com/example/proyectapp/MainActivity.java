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
        Button boton = (Button) findViewById(R.id.entradaButton);

        boton.setOnClickListener(new View.OnClickListener() { // hago clic en el botón

            @Override
            public void onClick(View v) {
                onContinuarAction(v);
            }
        });

    }

    public void onContinuarAction (View vista){
        if (connected() == true){
            Intent intent= new Intent (this, WebActivity.class);
            startActivity(intent);
        }else{
            goErrorActivity();
        }
    }
    public void goErrorActivity (){
        Intent intent= new Intent (this, ErrorActivity.class);
        startActivity(intent);
    }

    private boolean connected(){
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean activo;

        if (networkInfo != null && networkInfo.isConnected()) {
            activo=true;
        } else {
            activo=false;
        }
        return activo;
    }


}