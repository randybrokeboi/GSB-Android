package com.example.gsb_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<String> lesMed;
    private String departement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        departement = (String) getIntent().getSerializableExtra("dep");
        new Lismed().execute();
    }

    public void revenir(View view) {
        Intent versvue1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(versvue1);
    }

    private class Lismed extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            lesMed = DAO.getLesNoms(departement);
            return null;
        }

        protected void onPostExecute(Object o) {
            ArrayAdapter<String> adapter = null;
            adapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, lesMed);
            ListView listeMed = findViewById(R.id.Med);
            listeMed.setAdapter(adapter);
        }
    }
}