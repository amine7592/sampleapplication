package by.wink.sampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends Activity {

    TextView nameTV;
    Intent intent;
    String username;

    RecyclerView studentsRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    StudentsAdapter adapter;
    private static final String VM_COURSE = "VM Sviluppo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameTV = (TextView)findViewById(R.id.name_tv);
        intent = getIntent();
        username = intent.getStringExtra(MainActivity.USERNAME_KEY);
        nameTV.setText(username);
        studentsRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        layoutManager = new LinearLayoutManager(this);
        adapter = new StudentsAdapter();

        studentsRecyclerView.setLayoutManager(layoutManager);
        studentsRecyclerView.setAdapter(adapter);
        fetchStudents();



    }


    private void fetchStudents(){
        ArrayList<Student> vmStudents = new ArrayList<>();
        Student s1 = new Student();
        s1.setNome("Bottone Valerio");
        s1.setCourse(VM_COURSE);
        Student s2 = new Student();
        s2.setNome("Calderone Luca");
        s2.setCourse(VM_COURSE);
        Student s3 = new Student();
        s3.setNome("Camposeo Francesco");
        s3.setCourse(VM_COURSE);

        vmStudents.add(s1);
        vmStudents.add(s2);
        vmStudents.add(s3);

        adapter.setDataSet(vmStudents);





    }
}
