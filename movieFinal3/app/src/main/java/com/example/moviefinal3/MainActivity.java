package com.example.moviefinal3;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviefinal3.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MIClickListener {
    List<slid> lstslid;
    ViewPager slidpager;
    TabLayout indicator;
    List<movie>lstmovie;
    RecyclerView moviesrv;
    DatabaseReference reff ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //defin key
        slidpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        moviesrv = findViewById(R.id.rv_movis);
        //in. the list vr
        lstslid = new ArrayList<>();
        slid s1=new slid(R.drawable.slid1, "inception");
        slid s2 =new slid(R.drawable.slid2, "interstellar");
        slid s3 =new slid(R.drawable.slid5, "The Curious Case of Benjamin Button");
        slid s4 =new slid(R.drawable.slid6, "the wolf of street");
        lstslid.add(s1);
        lstslid.add(s2);
        lstslid.add(s3);
        lstslid.add(s4);


        slideAdapter a = new slideAdapter(this, lstslid);
        slidpager.setAdapter(a);

        //timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.slidtimer(), 3000, 4000);

        indicator.setupWithViewPager(slidpager, true);

        //in.the list movies
        lstmovie=new ArrayList<>();
        movie m1=new movie("incption",R.drawable.slid1,R.drawable.coverinception,"inception   is about Earth s last chance to find a habitable planet before a lack of resources causes the human race","Leonardo DiCaprio  Anne Hathaway ","Christopher Nolan");
        movie m2 = new movie("intersler",R.drawable.slid2,R.drawable.coverinter,"Interstellar is about Earth s last chance to find a habitable planet before a lack of resources causes the human race","Matthew McConaughey  Marion Cotillard","Marion Cotillard");
        movie m3= new movie ("Mr. e Mrs. Smith",R.drawable.slid3,R.drawable.coverslid3,"The events of the film revolve around John Smith and Jane Smith met in Colombia and got married, and after 5 years their marriage is on the verge of collapsing, and as part of their attempt to save their marriage, facts begin to emerge","Brad pitt anglina jolie ","Doug Liman");
        movie m4 = new movie("Wrath of Man",R.drawable.slid7,R.drawable.coverjosen,"The work deals with the story of a man who drives money trucks, carrying billions of money every day on the outskirts of Los Angeles, and facing many dangers and difficulties on his way.","josen statham and scott eastwood","Guy Ritchie");
        movie m5 = new movie ("The Curious Case of Benjamin Button",R.drawable.slid5,R.drawable.coverbinjmen,"The Curious Case of Benjamin Button: Directed by David Fincher. With Cate Blanchett, Brad Pitt, Julia Ormond, Faune Chambers Watkins. Tells the story of","Brad pitt","David Fincher");
        movie m6 = new movie ("The Wolf of Wall Street",R.drawable.slid6,R.drawable.coverthewolf,"The Wolf of Wall Street (2013) on IMDb: Plot summary, synopsis, and more. ... to Belfort featured on the cover of Forbes Magazine, being called The Wolf Of Wall St. He is about to explain to us the effects of quaaludes, but Donnie suddenly ","leonardo Dicaprio martdot robbie","7amad bzo");
        lstmovie.add(m1);
        lstmovie.add(m2);
        lstmovie.add(m3);
        lstmovie.add(m4);
        lstmovie.add(m5);
        lstmovie.add(m6);
        reff=FirebaseDatabase.getInstance().getReference().child("movie2");
        reff.push().setValue(m5);
        reff.push().setValue(m1);
        reff.push().setValue(m2);
        reff.push().setValue(m3);
        reff.push().setValue(m4);
        reff.push().setValue(m6);




        movieAdpter movieAdpter=new movieAdpter(this,lstmovie,this );
        moviesrv.setAdapter(movieAdpter);
        moviesrv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));







    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(movie m, ImageView iv) {

        Intent intent=new Intent(this, movieDetilActivity.class);
        intent.putExtra("title",m.getTitle());
        intent.putExtra("imgres",m.getReso());
        intent.putExtra("imgcover",m.getCover());
        intent.putExtra("desc.",m.getDescrption());
        intent.putExtra("name1",m.getNMAE1());
        intent.putExtra("name2",m.getCast());




        //startActivity(intent);
        Toast.makeText(this,"item click : "+m.getTitle(),Toast.LENGTH_LONG).show();

        //the way to transition from page to other
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this,iv,"sharedName");
        startActivity(intent,options.toBundle());
    }

    class slidtimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(() -> {
                if (slidpager.getCurrentItem() < lstslid.size() - 1) {
                    slidpager.setCurrentItem(slidpager.getCurrentItem() + 1);
                } else
                    slidpager.setCurrentItem(0);
            });
        }
    }
}