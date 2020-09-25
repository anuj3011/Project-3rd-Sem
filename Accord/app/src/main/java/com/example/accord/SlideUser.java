package com.example.accord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SlideUser extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SlideUser(Context context){
        this.context = context;
    }

    public int[] SlideAnimations = {
            R.raw.cute,
            R.raw.freelancer,
            R.raw.house,
    };

    public String[] SlideHeadings={
            "Heading1",
            "Heading2",
            "Heading3",
    };


    @Override
    public int getCount() {
        return SlideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slide_user,container,false);

        LottieAnimationView SlideAnimation = (LottieAnimationView) view.findViewById(R.id.lottieAnimationView);
        TextView SlideHeading = (TextView) view.findViewById(R.id.Heading);
        TextView SlideText = (TextView) view.findViewById(R.id.Text);
        SlideAnimation.setAnimation(SlideAnimations[position]);
        SlideHeading.setText(SlideHeadings[position]);
        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}