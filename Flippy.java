package com.irecallapp.main;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Research Admin on 12/30/2015.
 */
public class Flippy extends Activity implements  View.OnClickListener, Animation.AnimationListener {

    private Animation animation1;
    private Animation animation2;

    private Animation animation3;
    private Animation animation4;

    private Animation animation5;
    private Animation animation6;

    private Animation animation7;
    private Animation animation8;

    private Animation animation9;
    private Animation animation10;

    private Animation animation11;
    private Animation animation12;

    private Drawable.ConstantState first;
    private Drawable.ConstantState second;
    private Drawable.ConstantState third;
    private Drawable.ConstantState fourth;
    private Drawable.ConstantState fifth;
    private Drawable.ConstantState sixth;

    private Handler mHandler = new Handler();
    private Handler mHandler2 = new Handler();
    private boolean isBackOfCardShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flippy);
        animation1 = AnimationUtils.loadAnimation(this, R.anim.right);
        animation1.setAnimationListener(this);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.left);
        animation2.setAnimationListener(this);

        animation3 = AnimationUtils.loadAnimation(this, R.anim.right);
        animation3.setAnimationListener(this);
        animation4 = AnimationUtils.loadAnimation(this, R.anim.left);
        animation4.setAnimationListener(this);

        animation5 = AnimationUtils.loadAnimation(this, R.anim.right);
        animation5.setAnimationListener(this);
        animation6 = AnimationUtils.loadAnimation(this, R.anim.left);
        animation6.setAnimationListener(this);

        animation7 = AnimationUtils.loadAnimation(this, R.anim.right);
        animation7.setAnimationListener(this);
        animation8 = AnimationUtils.loadAnimation(this, R.anim.left);
        animation8.setAnimationListener(this);

        animation9 = AnimationUtils.loadAnimation(this, R.anim.right);
        animation9.setAnimationListener(this);
        animation10 = AnimationUtils.loadAnimation(this, R.anim.left);
        animation10.setAnimationListener(this);

        animation11 = AnimationUtils.loadAnimation(this, R.anim.right);
        animation11.setAnimationListener(this);
        animation12 = AnimationUtils.loadAnimation(this, R.anim.left);
        animation12.setAnimationListener(this);


        findViewById(R.id.backimage).setOnClickListener(this);
        findViewById(R.id.backimage2).setOnClickListener(this);
        findViewById(R.id.backimage3).setOnClickListener(this);
        findViewById(R.id.backimage4).setOnClickListener(this);
        findViewById(R.id.backimage5).setOnClickListener(this);
        findViewById(R.id.backimage6).setOnClickListener(this);

    }

    public void onClick(View v) {
        v.setEnabled(false);

        if(((ImageView)findViewById(R.id.backimage)).isPressed()) {
            ((ImageView)findViewById(R.id.backimage)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage)).setAnimation(animation1);
            ((ImageView)findViewById(R.id.backimage)).startAnimation(animation1);
            check();
            /*if(first != second)
            {
                System.out.println("role no match");

                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



            }
            else if(first != third)
            {
                System.out.println("role no match");

                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);



            }
           else if(first!= fourth)
            {
                System.out.println("role no match");

                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);



            }
            else if(first!= fifth)
            {
                System.out.println("role no match");

                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                ((ImageView)findViewById(R.id.backimage5)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage5)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage5)).setAnimation(animation10);
                ((ImageView)findViewById(R.id.backimage5)).startAnimation(animation10);



            }
            else if(first!= sixth)
            {
                System.out.println("role no match");

                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                ((ImageView)findViewById(R.id.backimage6)).setImageResource(R.drawable.brain);
                ((ImageView)findViewById(R.id.backimage6)).clearAnimation();
                ((ImageView)findViewById(R.id.backimage6)).setAnimation(animation12);
                ((ImageView)findViewById(R.id.backimage6)).startAnimation(animation12);



            }*/
        }


        if(((ImageView)findViewById(R.id.backimage2)).isPressed()) {
            ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation3);
            ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation3);
            Scheck();
        }


        if(((ImageView)findViewById(R.id.backimage3)).isPressed()) {
            ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation5);
            ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation5);
            Tcheck();}

        if(((ImageView)findViewById(R.id.backimage4)).isPressed()) {
            ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation7);
            ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation7);
            Fcheck();}

        if(((ImageView)findViewById(R.id.backimage5)).isPressed()) {
            ((ImageView)findViewById(R.id.backimage5)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage5)).setAnimation(animation9);
            ((ImageView)findViewById(R.id.backimage5)).startAnimation(animation9);
            Ficheck();
        }

        if(((ImageView)findViewById(R.id.backimage6)).isPressed()) {
            ((ImageView)findViewById(R.id.backimage6)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage6)).setAnimation(animation11);
            ((ImageView)findViewById(R.id.backimage6)).startAnimation(animation11);
            SIcheck();
        }

    }


    @Override
    public void onAnimationEnd(Animation animation) {


        if (animation==animation1) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.nerve);
                first= ((ImageView)findViewById(R.id.backimage)).getDrawable().getConstantState();

            } else {
                ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
            }


            ((ImageView)findViewById(R.id.backimage)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
            ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);


        } else {
            isBackOfCardShowing=!isBackOfCardShowing;
            findViewById(R.id.backimage).setEnabled(true);

        }

        if (animation==animation3) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.back);
                second= ((ImageView)findViewById(R.id.backimage2)).getDrawable().getConstantState();

            } else {
                ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);

            }


            ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
            ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);


        } else {
            isBackOfCardShowing=!isBackOfCardShowing;
            ((ImageView)findViewById(R.id.backimage2)).setEnabled(true);

        }

        if (animation==animation5) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.logo);
                third= ((ImageView)findViewById(R.id.backimage3)).getDrawable().getConstantState();

            } else {
                ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);

            }


            ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
            ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);


        } else {
            isBackOfCardShowing=!isBackOfCardShowing;
            ((ImageView)findViewById(R.id.backimage3)).setEnabled(true);

        }

        if (animation==animation7) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.logo);
                fourth= ((ImageView)findViewById(R.id.backimage4)).getDrawable().getConstantState();

            } else {
                ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);

            }


            ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
            ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);


        } else {
            isBackOfCardShowing=!isBackOfCardShowing;
            ((ImageView)findViewById(R.id.backimage4)).setEnabled(true);

        }

        if (animation==animation9) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.backimage5)).setImageResource(R.drawable.nerve);
                fifth= ((ImageView)findViewById(R.id.backimage5)).getDrawable().getConstantState();

            } else {
                ((ImageView)findViewById(R.id.backimage5)).setImageResource(R.drawable.brain);

            }


            ((ImageView)findViewById(R.id.backimage5)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage5)).setAnimation(animation10);
            ((ImageView)findViewById(R.id.backimage5)).startAnimation(animation10);


        } else {
            isBackOfCardShowing=!isBackOfCardShowing;
            ((ImageView)findViewById(R.id.backimage5)).setEnabled(true);

        }

        if (animation==animation11) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.backimage6)).setImageResource(R.drawable.back);
                sixth= ((ImageView)findViewById(R.id.backimage6)).getDrawable().getConstantState();

            } else {
                ((ImageView)findViewById(R.id.backimage6)).setImageResource(R.drawable.brain);

            }


            ((ImageView)findViewById(R.id.backimage6)).clearAnimation();
            ((ImageView)findViewById(R.id.backimage6)).setAnimation(animation12);
            ((ImageView)findViewById(R.id.backimage6)).startAnimation(animation12);


        } else {
            isBackOfCardShowing=!isBackOfCardShowing;
            ((ImageView)findViewById(R.id.backimage6)).setEnabled(true);

        }

        System.out.println("role first: "+ first);
        System.out.println("role second: " + second);
        System.out.println("role third: " + third);
        System.out.println("role fourth: " + fourth);
        System.out.println("role fourth: " + fifth);
        System.out.println("role fourth: " + sixth);






    }
    Animation animation;
    public void check()
    {
        mHandler.postDelayed(new Runnable() {
            public void run() {
                if (first == (second)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);


                }
                else if(first!= second)
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                    ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                    ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                    ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);
                }

                if (first == (third)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);

                }



                if (first == (fourth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);

                }


                if (first == (fifth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);

                }


                if (first == (sixth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);

                }

            }

        }, 3000);




    }

    public void Tcheck() {
        mHandler2.postDelayed(new Runnable() {
            public void run() {
                if (third == (first)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);


                }
              /*  else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                    ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                    ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                    ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);



                }*/
                if (third == (second)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);


                }
              /*  else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                    ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);

                    ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                    ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                }*/
                if (third == (fourth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }

                /*else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                    ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);

                    ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                    ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);



                }*/

                if (third == (fifth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);


                }

                if (third == (sixth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);


                }
            }

        }, 3000);
    }

    public void Scheck()
    {
        mHandler2.postDelayed(new Runnable() {
            public void run() {
                if (second==(first)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);


                }

              /*  else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                    ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);

                    ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                    ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                }*/

                if (third==(second)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);


                }
                /* else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                     ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);

                     ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                     ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                 }*/

                if (second==(fourth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }
               /*  else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                     ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                 }*/

                if (second==(fifth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);


                }

                if (second==(sixth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);


                }
            }

        }, 3000);




    }

    public void Fcheck()
    {
        mHandler2.postDelayed(new Runnable() {
            public void run() {
                if (fourth==(first)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }
               /* else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                    ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                    ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                    ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);



                }*/

                if (fourth==(second)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);


                }
                 /*else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                     ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                 }*/

                if (fourth==(third)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }
                /* else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                     ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);



                 }*/
                if (fourth==(fifth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }

                if (fourth==(sixth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }
            }

        }, 3000);




    }

    public void Ficheck()
    {
        mHandler2.postDelayed(new Runnable() {
            public void run() {
                if (fifth==(first)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);


                }
               /* else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                    ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                    ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                    ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);



                }*/

                if (fifth==(second)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);


                }
                 /*else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                     ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                 }*/

                if (fifth==(third)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);


                }
                /* else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                     ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);



                 }*/
                if (fourth==(fifth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }

                if (fifth==(sixth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);


                }
            }

        }, 3000);
    }

    public void SIcheck()
    {
        mHandler2.postDelayed(new Runnable() {
            public void run() {
                if (sixth==(first)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);


                }
               /* else
                {
                    System.out.println("role no match");

                    ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                    ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                    ((ImageView)findViewById(R.id.backimage)).setImageResource(R.drawable.brain);
                    ((ImageView)findViewById(R.id.backimage)).clearAnimation();
                    ((ImageView)findViewById(R.id.backimage)).setAnimation(animation2);
                    ((ImageView)findViewById(R.id.backimage)).startAnimation(animation2);



                }*/

                if (sixth==(second)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage2)).setVisibility(View.INVISIBLE);


                }
                 /*else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage2)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage2)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage2)).setAnimation(animation4);
                     ((ImageView)findViewById(R.id.backimage2)).startAnimation(animation4);



                 }*/

                if (sixth==(third)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage3)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);


                }
                /* else
                 {
                     System.out.println("role no match");

                     ((ImageView)findViewById(R.id.backimage4)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage4)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage4)).setAnimation(animation8);
                     ((ImageView)findViewById(R.id.backimage4)).startAnimation(animation8);

                     ((ImageView)findViewById(R.id.backimage3)).setImageResource(R.drawable.brain);
                     ((ImageView)findViewById(R.id.backimage3)).clearAnimation();
                     ((ImageView)findViewById(R.id.backimage3)).setAnimation(animation6);
                     ((ImageView)findViewById(R.id.backimage3)).startAnimation(animation6);



                 }*/
                if (sixth==(fifth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage5)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);


                }

                if (fourth==(sixth)) {
                    System.out.println("role hakonna matata");

                    ((ImageView) findViewById(R.id.backimage6)).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.backimage4)).setVisibility(View.INVISIBLE);


                }
            }

        }, 3000);




    }



    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub
    }
}
