package adil.android.com.computerg;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class Splash extends ActionBarActivity {
    final timers tms=new timers(18000,1000);
    ImageView back;
    int i=0;
    float fl= (float) 0.1;
//Animation an,an2;
    ProgressBar prg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
 //   back=(ImageView)findViewById(R.id.back);
        prg=(ProgressBar)findViewById(R.id.prg);
        prg.setMax(80);
        tms.start();
//an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
  //      an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
  //      back.startAnimation(an);
    //    tms.start();
  /*  an.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {


        }

        @Override
        public void onAnimationEnd(Animation animation) {
 //           back.startAnimation(an2);
//   finish();
     //       Intent in=new Intent(Splash.this,Third.class);
     //       startActivity(in);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });  */
    }


    public class timers extends CountDownTimer
    {int j=5;
        public timers(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
          //  long millis=millisUntilFinished;
            String hms=String.format("%02d",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-TimeUnit.MILLISECONDS.toMinutes(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            System.out.println(hms);
            prg.setVisibility(View.VISIBLE);
            prg.setProgress(j);
            j+=5;
// /fl+=0.1;
 //        i++;
  //          back.setAlpha(fl);


        }

        @Override
        public void onFinish() {
            Intent inn=new Intent(Splash.this,Third.class);
            startActivity(inn);
        }
    }

}
