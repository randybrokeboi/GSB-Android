package com.example.gsb_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    private List<String> lesDeps;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //on va chercher la vue
        setContentView(R.layout.activity_main);
        new LisDeps().execute();

    }


    private class LisDeps extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
                lesDeps = DAO.getLesDeps();
            return null;
        }

        protected void onPostExecute(Object o) {
            ArrayAdapter<String> adapter = null;
            adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,lesDeps);
            ListView listeDep = findViewById(R.id.Dep);
            listeDep.setAdapter(adapter);
            listeDep.setClickable(true);
            listeDep.setOnItemClickListener((parent, view, position, id) -> {
                Intent medecin = new Intent(getApplicationContext(), MainActivity2.class);
                medecin.putExtra("dep", (String) listeDep.getItemAtPosition(position));
                startActivity(medecin);
            });



        }
    }
}