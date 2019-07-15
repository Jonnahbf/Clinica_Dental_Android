package com.example.clinica_dental.Doctores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.clinica_dental.DB.Database;
import com.example.clinica_dental.Doctores.RV_Doctores;
import com.example.clinica_dental.R;
import com.example.clinica_dental.TablasDB.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Ver_Doctores_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    Database db;
    List<Doctor> doctorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__doctores_);
        db= Room.databaseBuilder(getApplicationContext(),
                Database.class, "Prestamo").allowMainThreadQueries().build();
        recyclerView = findViewById(R.id.rv_doctores);
        doctorList.addAll(db.doctorDao().ObtenerTodo());
        final RV_Doctores rv_doctores = new RV_Doctores(doctorList);
    }
}
