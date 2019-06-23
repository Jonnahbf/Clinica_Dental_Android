package com.example.clinica_dental;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clinica_dental.DB.Database;
import com.example.clinica_dental.TablasDB.Admin;
import com.example.clinica_dental.TablasDB.Paciente;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Database db;
    Admin admin;
    String pwd, name;
    EditText user_name, password;
    Button btn_registrarse;
    int tipo_usuario = 0;
    List<Admin> adminList = new ArrayList<>();
    List<Paciente> pacienteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle = getIntent().getExtras();
        tipo_usuario = bundle.getInt("Usuario");
        user_name = findViewById(R.id.et_user_name);
        btn_registrarse = findViewById(R.id.btn_registro);
        password = findViewById(R.id.et_password);
        db= Room.databaseBuilder(getApplicationContext(),
                Database.class, "Prestamo").allowMainThreadQueries().build();
        pacienteList.addAll(db.pacienteDao().ObtenerTodo());
    }

    public void onClickIngresar(View v){
        ValidarUsuario();
    }

    public void onClickNuevoPaciente(View v){
        Intent intent = new Intent(this, Registro_Paciente_Activity.class);
        startActivityForResult(intent, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2000 && resultCode!=0){
            Paciente paciente = (Paciente) data.getExtras().getSerializable("paciente");
            try{
                long id = db.pacienteDao().Insertar(paciente);
                paciente.setId_paciente((int)id);
                pacienteList.add(paciente);
                Toast.makeText(this, "100%", Toast.LENGTH_SHORT).show();
            }
            catch (SQLiteConstraintException e){
                Toast.makeText(this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void ValidarUsuario(){
        if(user_name.getText().length() == 0){
           user_name.setError("Debe llenar este campo");
        }
        else if(password.getText().length()==0)
            password.setError("Debe llenar este campo");
        else{
            pwd = password.getText().toString();
            name = user_name.getText().toString();
            if(tipo_usuario == 1){
                EsUnAdmin();
            }
            else if(tipo_usuario == 2){
                EsUnDoctor();
            }
            else if(tipo_usuario == 3){
                EsUnPaciente();
            }
        }
    }

    public void EsUnAdmin(){
        for(int i = 0; i<adminList.size(); i++){
            if(name.equalsIgnoreCase(adminList.get(i).getUser_name())){
                if(pwd.equalsIgnoreCase(adminList.get(i).getPassword())){
                    Toast.makeText(this, "Todo bien, todo correcto", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    public void EsUnDoctor(){
        for(int i = 0; i<adminList.size(); i++){
            if(name.equalsIgnoreCase(adminList.get(i).getUser_name())){
                if(pwd.equalsIgnoreCase(adminList.get(i).getPassword())){
                    Toast.makeText(this, "Todo bien, todo correcto", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    public void EsUnPaciente(){
        for(int i = 0; i<pacienteList.size(); i++){
            if(name.equalsIgnoreCase(pacienteList.get(i).getUser_name())){
                if(pwd.equalsIgnoreCase(pacienteList.get(i).getPassword())){
                    Toast.makeText(this, "Todo bien, todo correcto", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }
}
