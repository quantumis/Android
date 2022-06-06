package com.quanty.comp_firm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ComponentsAdapter mAdapter;
    private List<Components> mComponentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvComponents = findViewById(R.id.listviewcomponents);
        mAdapter = new ComponentsAdapter(MainActivity.this, mComponentsList);
        lvComponents.setAdapter(mAdapter);

        new GetComponents().execute();
    }

    private class GetComponents extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://10.0.2.2:62692/api/Components");
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();

                InputStreamReader stream = new InputStreamReader(connection.getInputStream());

                BufferedReader reader = new BufferedReader(stream);

                StringBuilder result = new StringBuilder();
                String line = "";


                while ((line = reader.readLine()) != null)
                {
                    result.append(line);
                }



                return result.toString();
            }
            catch (Exception ex){
                return ex.toString();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray temparray = new JSONArray(s);

                for (int i = 0; i < temparray.length(); i++)
                {
                    JSONObject componentJson = temparray.getJSONObject(i);

                    Components tempcomponents = new Components(
                            componentJson.getInt("id"),
                            componentJson.getString("idC"),
                            componentJson.getString("idM"),
                            componentJson.getString("Model"),
                            componentJson.getInt("Quantity"),
                            componentJson.getDouble("Price_R"),
                            componentJson.getString("Image")
                    );

                    mComponentsList.add(tempcomponents);
                    mAdapter.notifyDataSetChanged();
                }
            }
            catch (Exception ex)
            {

            }
        }
    }
}