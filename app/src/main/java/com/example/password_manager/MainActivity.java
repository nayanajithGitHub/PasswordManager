package com.example.password_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.loginid);
        editText2 = (EditText) findViewById(R.id.loginpassid);
        button = (Button) findViewById(R.id.Logbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = "nayanajith936";
                String userpass = "43928846";

                String data1 = editText1.getText().toString();
                String data2 = editText2.getText().toString();

                if(data1.equals(username) && data2.equals(userpass)) {
                    Intent intent = new Intent(MainActivity.this, AddPassword.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}