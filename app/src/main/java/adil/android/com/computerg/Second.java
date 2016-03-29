package adil.android.com.computerg;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Second extends ActionBarActivity {
ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
img=(ImageView)findViewById(R.id.anim);
animation();
   //     bitmaps=new ArrayList<Bitmap>();
   //     bitmaps.add(BitmapFactory.decodeResource(getResources(),R.drawable.bitmap1));
   //     bitmaps.add(BitmapFactory.decodeResource(getResources(),R.drawable.bitmap2));
   //     bitmaps.add(BitmapFactory.decodeResource(getResources(),R.drawable.bitmap3));
   //     bitmaps.add(BitmapFactory.decodeResource(getResources(),R.drawable.bitmap4));


    }
    public void animation()
    {
        img.setImageResource(R.drawable.animtaion);
        AnimationDrawable ballanimation=(AnimationDrawable)img.getDrawable();
        if(ballanimation.isRunning())
        {
            ballanimation.stop();
        }
        ballanimation.start();

    }

}
