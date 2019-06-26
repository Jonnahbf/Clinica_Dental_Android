package com.example.clinica_dental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Pacientes_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes_);
    }
    public void onClick(View v)
    {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public void onClickUbicacion(View v){
        Intent intent = new Intent(Pacientes_Activity.this, MapsActivity.class);
        startActivity(intent);
    }
}
