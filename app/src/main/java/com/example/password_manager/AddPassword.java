package com.example.password_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class AddPassword extends AppCompatActivity {

    EditText addtitle,adduname,addpassword;
    Button additem,showitems;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);

        addtitle = (EditText) findViewById(R.id.titleid);
        adduname = (EditText) findViewById(R.id.userid);
        addpassword = (EditText) findViewById(R.id.userpass);
        additem = (Button) findViewById(R.id.add);
        showitems = (Button) findViewById(R.id.showpass);
        imageView = (ImageView) findViewById(R.id.imageView);

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = addtitle.getText().toString();
                String uname = adduname.getText().toString();
                String password = addpassword.getText().toString();


                if(title.isEmpty() || uname.isEmpty() || password.isEmpty()){
                    Toast.makeText(AddPassword.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }else {

                    //call addPassword method() - 1 Create object and call

                    DBHelper dbHelper = new DBHelper(AddPassword.this);

                    dbHelper.addPasswords(title, uname, password);

                    Intent intent = new Intent(AddPassword.this, PasswordView.class);
                    startActivity(intent);
                }

            }
        });

        showitems.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(AddPassword.this,PasswordView.class);
            startActivity(intent);
         }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddPassword.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}