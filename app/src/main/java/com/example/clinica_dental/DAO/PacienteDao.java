package com.example.clinica_dental.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clinica_dental.TablasDB.Paciente;

import java.util.List;

@Dao
public interface PacienteDao {

    @Insert
    long Insertar(Paciente paciente);

    @Query("SELECT * FROM PacienteTB")
    List<Paciente> ObtenerTodo();
}
