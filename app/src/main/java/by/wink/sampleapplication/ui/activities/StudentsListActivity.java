package by.wink.sampleapplication.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import by.wink.sampleapplication.R;
import by.wink.sampleapplication.models.Student;
import by.wink.sampleapplication.ui.adapters.StudentsAdapter;

/**
 * Created by amine on 27/01/17.
 */
public class StudentsListActivity extends Activity {

    RecyclerView studentsRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    StudentsAdapter adapter;
    private static final String TAG = StudentsListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        studentsRecyclerView = (RecyclerView) findViewById(R.id.students_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new StudentsAdapter();

        studentsRecyclerView.setLayoutManager(layoutManager);
        studentsRecyclerView.setAdapter(adapter);
        fetchDataFromDB();
    }


    private void fetchDataFromDB() {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.mocky.io/v2/588b5b94300000411cfa8dd0";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d(TAG,response);
                        try {
                            JSONObject responseJson = new JSONObject(response);
                            adapter.setDataSet(Student.getStudentsListFromJson(responseJson.getJSONArray("students")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage());

            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
