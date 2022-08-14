package com.example.moviefinal3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviefinal3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class movieDetilActivity extends AppCompatActivity {
    Button back ;
    ImageView movieimg,moviecoverimg;
    TextView tv_title,tv_desc,name1,name2 ;
    FloatingActionButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detil);
        play=findViewById(R.id.play2);
        back=findViewById(R.id.back3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(movieDetilActivity.this , "Change>>>" ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(movieDetilActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        inviews();
    }


    void inviews(){

        String movietitle=getIntent().getExtras().getString("title");
        int moviereso = getIntent().getExtras().getInt("imgres");
        int coverimg =getIntent().getExtras().getInt("imgcover");
        String moviedec=getIntent().getExtras().getString("desc.");
        String Name1=getIntent().getExtras().getString("name1");
        String Name2=getIntent().getExtras().getString("name2");


        movieimg=findViewById(R.id.detail_movi_img);
        tv_title=findViewById(R.id.detel_movie_title);
        moviecoverimg=findViewById(R.id.dietel_movi_conver);
        tv_desc =findViewById(R.id.deteal_movie_desc);

        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        //  Glide.with(this).load(moviereso).into(movieimg);
        name1.setText(Name1);
        name2.setText(Name2);
        movieimg.setImageResource(moviereso);
        moviecoverimg.setImageResource(coverimg);
        tv_title.setText(movietitle);
        tv_desc.setText(moviedec);


    }
}
