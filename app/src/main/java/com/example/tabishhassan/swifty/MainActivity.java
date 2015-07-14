package com.example.tabishhassan.swifty;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

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

    @Override
    protected void onResume() {
        super.onResume();
        imageAnimator = ObjectAnimator.ofFloat(iconImage,"x",-500f,-300f);
        imageAnimator.start();
        iconImage.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
