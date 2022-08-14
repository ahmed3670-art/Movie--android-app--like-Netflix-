package com.example.moviefinal3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class movieAdpter extends RecyclerView.Adapter<movieAdpter.MyviewHolder> {

    Context context ;
    List<com.example.moviefinal3.movie> mdata;
    MIClickListener miClickListener;

    public movieAdpter(Context context, List<com.example.moviefinal3.movie> mdata, MIClickListener listener) {
        this.context = context;
        this.mdata = mdata;
        miClickListener=listener;
    }

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyviewHolder holder, int position) {
        holder.tvtitle.setText(mdata.get(position).getTitle());
        holder.imgmovie.setImageResource(mdata.get(position).getReso());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        private TextView tvtitle;
        private ImageView imgmovie;
        public MyviewHolder(@NonNull  View itemView) {
            super(itemView);
            tvtitle=itemView.findViewById(R.id.item_movie_title);
            imgmovie=itemView.findViewById(R.id.item_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    miClickListener.onMovieClick(mdata.get(getAdapterPosition()),imgmovie);

                }
            });
        }
    }
}
