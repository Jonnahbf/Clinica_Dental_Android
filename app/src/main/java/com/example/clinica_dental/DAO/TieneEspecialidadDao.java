package com.example.clinica_dental.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.clinica_dental.POJOS.DoctorTieneEspecialidad;
import com.example.clinica_dental.TablasDB.Doctor;
import com.example.clinica_dental.TablasDB.DoctorhasEspecialidad;

import java.util.List;

@Dao
public interface TieneEspecialidadDao {

    @Insert
    long Insertar(DoctorhasEspecialidad doctorhasEspecialidad);

    @Query("SELECT * FROM TieneEspecialidadTB where id_Doctor=:id_doctor")
    List<DoctorTieneEspecialidad> ESPECIALIDAD_LIST(String id_doctor);

    @Query("SELECT *FROM Tieneespecialidadtb")
    List<DoctorhasEspecialidad> ObtenerTodo();
}
