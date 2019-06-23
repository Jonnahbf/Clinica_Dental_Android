package com.example.clinica_dental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.clinica_dental.DB.Database;
import com.example.clinica_dental.TablasDB.Admin;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Database db;
    public int tipo_usuario = 0;
    List<Admin> adminList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= Room.databaseBuilder(getApplicationContext(),
                Database.class, "Prestamo").allowMainThreadQueries().build();
        adminList = db.adminDao().ObtenerTodo();
        Toast.makeText(this, "Tamaño " + String.valueOf(adminList.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mn_admin:
                tipo_usuario = 1;
                Loggin();
                break;
            case R.id.mn_doctor:
                tipo_usuario = 2;
                Loggin();
                break;
            case R.id.mn_paciente:
                tipo_usuario = 3;
                Loggin();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Loggin(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("Usuario", tipo_usuario);
        startActivityForResult(intent, 1998);
    }
}
