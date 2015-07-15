package com.example.tabishhassan.swifty;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView instructionOne , instructionTwo , nextButton;
    ImageView iconImage;
    ObjectAnimator textOneAnimator,textOne1Animator,textTwo1Animator, imageAnimator,textTwoAnimator;
    Animator.AnimatorListener animationListener;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructionOne = (TextView)findViewById(R.id.textView);
        instructionTwo = (TextView)findViewById(R.id.textView2);
        nextButton = (TextView)findViewById(R.id.textView3);
        iconImage = (ImageView)findViewById(R.id.imageView);
        imageAnimator = ObjectAnimator.ofFloat(iconImage,"x",-300f);
        imageAnimator.start();
        iconImage.setVisibility(View.VISIBLE);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0)
                {
                    imageAnimator = ObjectAnimator.ofFloat(iconImage,"x",-300f,-150f);
                    imageAnimator.setDuration(1000);
                    imageAnimator.start();
                    textOneAnimator = ObjectAnimator.ofFloat(instructionOne,"x",0f,-1000f);
                    textOneAnimator.setDuration(400);
                    textOne1Animator = ObjectAnimator.ofFloat(instructionOne,"x",1000f,0f);
                    textOne1Animator.setDuration(400);
                    textOne1Animator.addListener(animationListener);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(textOneAnimator).before(textOne1Animator);
                    animatorSet.start();
                    textTwoAnimator = ObjectAnimator.ofFloat(instructionTwo,"x",0f,-1000f);
                    textTwoAnimator.setDuration(400);
                    textTwo1Animator = ObjectAnimator.ofFloat(instructionTwo,"x",1000f,0f);
                    textTwo1Animator.setDuration(400);
                    animatorSet = new AnimatorSet();
                    animatorSet.play(textTwoAnimator).before(textTwo1Animator);
                    animatorSet.start();
                    count++;
                }
                else if(count == 1)
                {
                    imageAnimator = ObjectAnimator.ofFloat(iconImage,"x",-150f,0);
                    imageAnimator.setDuration(1000);
                    imageAnimator.start();
                    textOneAnimator = ObjectAnimator.ofFloat(instructionOne,"x",0f,-1000f);
                    textOneAnimator.setDuration(400);
                    textOne1Animator = ObjectAnimator.ofFloat(instructionOne,"x",1000f,0f);
                    textOne1Animator.setDuration(400);
                    textOne1Animator.addListener(animationListener);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(textOneAnimator).before(textOne1Animator);
                    animatorSet.start();
                    textTwoAnimator = ObjectAnimator.ofFloat(instructionTwo,"x",0f,-1000f);
                    textTwoAnimator.setDuration(400);
                    textTwo1Animator = ObjectAnimator.ofFloat(instructionTwo,"x",1000f,0f);
                    textTwo1Animator.setDuration(400);
                    animatorSet = new AnimatorSet();
                    animatorSet.play(textTwoAnimator).before(textTwo1Animator);
                    animatorSet.start();
                    count++;
                }
                else {
                    Intent miIntent = new Intent(MainActivity.this,TutorialActivity.class);
                    startActivity(miIntent);
                    count= 0 ;
                }
            }
        });

        animationListener =  new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if(count==1) {
                    instructionOne.setText("This app is going \n to be very helpfull for handsome\n learning of Swift");
                    instructionTwo.setText("This app is \n going to be very helpfull for \n learning");
                }
                else if(count==2)
                {
                    instructionOne.setText("There are almost \n 20 tutorials each containing 15+ \n lectures");
                    instructionTwo.setText("This app is \n going to be very helpfull for \n learning");
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };

    }
}
