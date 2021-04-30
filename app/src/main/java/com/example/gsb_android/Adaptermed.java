package com.example.gsb_android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.material.transition.MaterialContainerTransform;

import java.util.ArrayList;

public class Adaptermed extends BaseAdapter{
    private Activity actimed;
    private ArrayList <Medecin> listmed;
    private LayoutInflater inflater;
public Adaptermed(Activity actimed, ArrayList <Medecin> listmed){
    this.actimed = actimed;
    this.listmed = listmed;
    this.inflater = this.actimed.getLayoutInflater();
}
    @Override
    public int getCount() {
        return this.listmed.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listmed.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = this.inflater.inflate(R.layout.adapter_medecin,null);
        TextView nom = view.findViewById(R.id.nom);
        TextView prenom = view.findViewById(R.id.prenom);
        TextView adresse = view.findViewById(R.id.adresse);
        TextView spe = view.findViewById(R.id.spe);
        TextView tel = view.findViewById(R.id.tel);

        Medecin med = (Medecin) getItem(position);
        nom.setText(med.getmNom());
        prenom.setText(med.getmPrenom());
        adresse.setText(med.getmAdresse());
        spe.setText(med.getmSpecialite());
        tel.setText(med.getmTel());
        return view;
    }
}
