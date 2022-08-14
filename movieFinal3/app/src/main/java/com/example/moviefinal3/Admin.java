package com.example.moviefinal3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Admin extends AppCompatActivity {

    Button change,LOGOUT,GO,uplaod,Back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_lay);
        LOGOUT=findViewById(R.id.logout);
        change=findViewById(R.id.change);
        GO=findViewById(R.id.go_to_app);
        uplaod=findViewById(R.id.uploadmovie);


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin.this , "Change>>>" ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Admin.this , change_admin.class);
                startActivity(intent);
                finish();
            }

        });

        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , Main.class);
                startActivity(intent);
                finish();
            }
        });

   GO.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(Admin.this , MainActivity.class);
           startActivity(intent);
           finish();
       }
   });

        uplaod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this , addvideo.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
