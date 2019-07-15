package com.example.clinica_dental.Doctores;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinica_dental.R;
import com.example.clinica_dental.TablasDB.Doctor;

import org.w3c.dom.Text;

import java.util.List;

public class RV_Doctores extends RecyclerView.Adapter<RV_Doctores.DoctorHolder> implements View.OnClickListener{

    private List<Doctor> doctorList;
    private onClickItemListener onClickItemListener;
    private onClickDeleteListener onClickDeleteListener;

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public DoctorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_doctores, parent, false);
        view.setOnClickListener(this);
        DoctorHolder doctorHolder = new DoctorHolder(view);
        return doctorHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorHolder holder, int position) {
        holder.tvApellido.setText(doctorList.get(position).getApellidos());
        holder.tvNombre.setText(doctorList.get(position).getNombres());
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public interface onClickDeleteListener{
        void onItemClick(Doctor doctor, int position);
    }

    public void setOnClickDeleteListener(onClickDeleteListener onClickDeleteListener){
        this.onClickDeleteListener = onClickDeleteListener;
    }

    public interface onClickItemListener{
        void onItemClick(Doctor doctor, int position);
    }

    public void setOnClickItemListener(onClickItemListener onClickItemListener){
        this.onClickItemListener = onClickItemListener;
    }

    public RV_Doctores(List<Doctor> doctorList){
        this.doctorList = doctorList;
    }

    public class DoctorHolder extends RecyclerView.ViewHolder{
        public TextView tvNombre;
        public TextView tvApellido;

        public DoctorHolder(@NonNull View itemView) {
            super(itemView);

            this.tvApellido = itemView.findViewById(R.id.tv_nombre_doctor);
            this.tvApellido = itemView.findViewById(R.id.tv_apellido_doctor);
        }
    }
}
