package adil.android.com.computerg;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class About extends ActionBarActivity {
    Animation anim;
    TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
about=(TextView)findViewById(R.id.aboutus);

        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.aboutus);
        about.setText("\t\tDEVELOPED BY\n\n"+
                "\t\tADIL ABDULLAH ANSARI\n\n"+
                "\t\tSAYLANI MASS TRAINING STUDENT\n\n"+
                "\t\tANDROID BATCH 2015\n\n"+
                "\t\tROLL #: 1046\n\n");
        about.startAnimation(anim);
    }



}
