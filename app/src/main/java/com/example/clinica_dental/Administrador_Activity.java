package com.example.clinica_dental;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clinica_dental.Doctores.Agregar_Doctor_Activity;

public class Administrador_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_);
    }

    public void onClickVerDoctores(View v) {

    }

    public void onClickAgregarDoctor(View v){
        Intent intent = new Intent(Administrador_Activity.this, Agregar_Doctor_Activity.class);
        startActivityForResult(intent, 1234);//RequestCode para agregar doctor
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickInformacion(View v){

    }

    public void onClickVerCitas(View v){

    }
}
