package com.example.password_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class PasswordView extends AppCompatActivity {


    RecyclerView recyclerView;
    Button button;

    DBHelper db;
    MyAdapter ad;
    ArrayList<String> listid,addtitle,adduname,addpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewid);




        db = new DBHelper(PasswordView.this);
        listid = new ArrayList<>();
        addtitle = new ArrayList<>();
        adduname = new ArrayList<>();
        addpassword = new ArrayList<>();


        dataSetArray();
        ad = new MyAdapter(PasswordView.this,listid,addtitle,adduname,addpassword);
        recyclerView.setAdapter(ad);

        recyclerView.setLayoutManager(new LinearLayoutManager(PasswordView.this));
        
    }

    private void dataSetArray() {

        Cursor cursor = db.selectAllRecords();

        if (cursor.getCount() == 0 ){
            Toast.makeText(this,"No records found",Toast.LENGTH_SHORT).show();
        }else {
            while(cursor.moveToNext()){
                listid.add(cursor.getString(0));
                addtitle.add(cursor.getString(1));
                adduname.add(cursor.getString(2));
                addpassword.add(cursor.getString(3));


            }
        }
    }
}