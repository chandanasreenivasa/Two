package com.example.chandanasrinivas.two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listAndArray extends AppCompatActivity {

    ListView simpleList;
    String animalList[]={"Lion","Cat"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_array);

        simpleList=(ListView) findViewById(R.id.simpleList);

        ListAdapter ar=new ArrayAdapter<String>(this,R.layout.activity_listview,R.id.textView,animalList);
        simpleList.setAdapter(ar);

    }
}
