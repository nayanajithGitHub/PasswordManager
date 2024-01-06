package com.example.password_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDetails extends AppCompatActivity {


    EditText updateTitle, updateUsername, updatePassword;
    Button update,delete;

    String id, title, uname, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        updateTitle = findViewById(R.id.updatetitleid);
        updateUsername= findViewById(R.id.updateuserid);
        updatePassword = findViewById(R.id.updateuserpass);
        update = findViewById(R.id.updateadd);
        delete = findViewById(R.id.delete);

        getIntentData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper mydb = new DBHelper(UpdateDetails.this);
                mydb.updateData(id,updateTitle.getText().toString(),updateUsername.getText().toString(),updatePassword.getText().toString());

                Intent intent = new Intent(UpdateDetails.this,PasswordView.class);
                startActivity(intent);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper mydb = new DBHelper(UpdateDetails.this);
                mydb.deleteData(id);

                Intent intent = new Intent(UpdateDetails.this, PasswordView.class);
                startActivity(intent);
            }
        });


    }
    void getIntentData() {
        if (getIntent().hasExtra("id")) {
            id = getIntent().getStringExtra("id");
            uname = getIntent().getStringExtra("uname");
            password = getIntent().getStringExtra("password");
            title = getIntent().getStringExtra("title");

            updateTitle.setText(title);
            updateUsername.setText(uname);
            updatePassword.setText(password);
        } else {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }


    }
}