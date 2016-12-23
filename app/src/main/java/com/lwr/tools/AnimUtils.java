package com.lwr.tools;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.bumptech.glide.request.animation.ViewPropertyAnimation;

/**
 * Created by liuwenrong on 2016/12/15.
 */
public class AnimUtils {

    /**
     * @param animationSet = new AnimationSet(true) //true表示使用Animation的interpolator,false则用自己的
     * @param durationMillis
     */
    public static AnimationSet configAlphaAnimationSet(AnimationSet animationSet, long durationMillis){

        //创建一个AlphaAnimation对象,参数从完全透明0到完全不透明1
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);

        //设置执行时间
        alphaAnimation.setDuration(durationMillis);
        alphaAnimation.setRepeatCount(1);

        animationSet.addAnimation(alphaAnimation);

        return animationSet;

    }

    public static AnimationSet configScaleAnimationSet(AnimationSet animationSet, long durationMillis){

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 0.8f, 0, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(durationMillis);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;

    }

    public static AnimationSet configTranslateAnimationSet(AnimationSet animationSet, long durationMillis){

//        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0.5f, Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0.5f);
//        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 1f);
        TranslateAnimation translateAnimation = new TranslateAnimation(-50, 0, 0, 0);
        animationSet.addAnimation(translateAnimation);
        return animationSet;

    }

    public static void alphaAnimation(View view, long durationMillis){
        //创建一个AnimationSet对象,参数为Boolean
        //true表示使用Animation的interpolator,false则用自己的
        AnimationSet animationSet = new AnimationSet(true);

        //创建一个AlphaAnimation对象,参数从完全透明0到完全不透明1
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);

        //设置执行时间
        alphaAnimation.setDuration(durationMillis);

        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    public static AnimationSet configRotateAnimationSet(AnimationSet animationSet, long durationMillis){

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(durationMillis);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;

    }

    public static ViewPropertyAnimation.Animator getAlphaAnimator(final long durationMillis){
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                // 渐显动画
                view.setAlpha( 0f );

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
                fadeAnim.setDuration(durationMillis);
                fadeAnim.start();
            }
        };
        return animationObject;
    }

}
