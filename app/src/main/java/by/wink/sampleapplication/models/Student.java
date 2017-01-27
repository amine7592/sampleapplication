package by.wink.sampleapplication.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amine on 27/01/17.
 */
public class Student {

    private String nome;
    private String course;


    public Student(){}
    public Student(JSONObject studentJson) {
        try {
            nome = studentJson.getString("name");
            course = studentJson.getString("course");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public static ArrayList<Student> getStudentsListFromJson(JSONArray jsonArray){
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i<jsonArray.length();i++) {
            try {
                JSONObject studentJson = jsonArray.getJSONObject(i);
                students.add(new Student(studentJson));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return students;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
