package com.example.gsb_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ArrayList<Medecin> lesMed;
    private String departement;

    @Override
    /**
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        departement = (String) getIntent().getSerializableExtra("dep");
        new Lismed().execute();
    }

    /**
     *
     * @param view
     */
    public void revenir(View view) {
        Intent versvue1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(versvue1);
    }

    /**
     *
     */
    private class Lismed extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            lesMed = DAO.getLesInfos(departement);
            return null;
        }

        /**
         *
         * @param o
         */
        protected void onPostExecute(Object o) {
            ListView listeMed = findViewById(R.id.Med);
            listeMed.setAdapter(new Adaptermed(MainActivity2.this,lesMed));
        }
    }
}