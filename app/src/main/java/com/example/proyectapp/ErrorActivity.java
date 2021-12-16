package com.example.proyectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle parametros = this.getIntent().getExtras();
        int error_code = 0;
        if(parametros !=null){
            error_code = parametros.getInt("error_code");
        }
        switch (error_code){
            case 0:
                setContentView(R.layout.activity_error_carga);
                break;
            case 1:
                setContentView(R.layout.activity_error_conexion);
                break;
        }
    }
}