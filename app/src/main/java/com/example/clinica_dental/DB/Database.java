package com.example.clinica_dental.DB;

import android.graphics.Paint;

import androidx.room.RoomDatabase;

import com.example.clinica_dental.DAO.AdminDao;
import com.example.clinica_dental.DAO.PacienteDao;
import com.example.clinica_dental.TablasDB.Admin;
import com.example.clinica_dental.TablasDB.Paciente;

@androidx.room.Database(entities = {Admin.class, Paciente.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract AdminDao adminDao();
    public abstract PacienteDao pacienteDao();
}
