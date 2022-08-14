package com.example.moviefinal3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class slideAdapter extends PagerAdapter {

    private Context mcontext ;
    private List<com.example.moviefinal3.slid> lst ;

    public slideAdapter(Context mcontext, List<com.example.moviefinal3.slid> lst) {
        this.mcontext = mcontext;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view,  Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull  Object object) {

        container.removeView((View)object);
    }



    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slidelayout = inflater.inflate(R.layout.slide_item,null);

        ImageView slidimage =slidelayout.findViewById(R.id.slid_image);
        TextView slidtext = slidelayout.findViewById(R.id.slide_title);
        slidimage.setImageResource(lst.get(position).getImage());
        slidtext.setText(lst.get(position).getTitle());
        container.addView(slidelayout);
        return slidelayout;


    }

}
