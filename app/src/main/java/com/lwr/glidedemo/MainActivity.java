package com.lwr.glidedemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lwr.tools.AnimUtils;

public class MainActivity extends AppCompatActivity {

    ImageView mInterImg;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInterImg = (ImageView) findViewById(R.id.inter_img);
        String url = "http://e.hiphotos.baidu.com/baike/crop%3D15%2C0%2C589%2C388%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=6d529b25d91373f0e17035df993e7ed7/f636afc379310a550f08ddaabf4543a9822610bb.jpg";

        AnimationSet animationSet = new AnimationSet(true);
//        AnimUtils.configRotateAnimationSet(animationSet, 2500);
//        AnimUtils.configScaleAnimationSet(animationSet, 2500);
        AnimUtils.configTranslateAnimationSet(animationSet, 2500);
        Glide.with(this)
//                .load(url)
                .load(R.drawable.ic_two_people)
                .placeholder(R.mipmap.ic_launcher)
                .animate(R.anim.slide_in_left)
//                .animate(AnimUtils.configAlphaAnimationSet(animationSet, 2500))
//                .crossFade()
//                .animate(animationObject)
                .into(mInterImg);
    }

    public void animRun(final View view){
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "rotationY", 0f, 360f)//X/Y轴旋转一周
                .setDuration(2500);
                anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float cVal = (Float) animation.getAnimatedValue()/360;
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

}
