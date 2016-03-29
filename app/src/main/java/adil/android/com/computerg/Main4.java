package adil.android.com.computerg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Main4 extends ActionBarActivity {
    private int cor=0,c=0,sum=0;
    private Button btn,btm,sto;
    private TextView id,qu,an,txt,yu;
    private ImageView im1,im2,im3,im4;
    private RadioButton on1,on2,on3,on4,checks;
    private int i=24,h=32;
    DatabaseHelper dh=new DatabaseHelper(Main4.this);
    ArrayList<Mcq_model> mm=dh.get_alldata();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        yu=(TextView)findViewById(R.id.your);
        btn=(Button)findViewById(R.id.next);
        btm=(Button)findViewById(R.id.prev);
        id=(TextView)findViewById(R.id.sno);
        sto=(Button)findViewById(R.id.stop);
        qu=(TextView)findViewById(R.id.ques);
        on1=(RadioButton)findViewById(R.id.op1);
        on2=(RadioButton)findViewById(R.id.op2);
        on3=(RadioButton)findViewById(R.id.op3);
        on4=(RadioButton)findViewById(R.id.op4);
        txt=(TextView)findViewById(R.id.txt);
        an=(TextView)findViewById(R.id.ans);
        im1=(ImageView)findViewById(R.id.im1);
        im2=(ImageView)findViewById(R.id.im2);
        im3=(ImageView)findViewById(R.id.im3);
        im4=(ImageView)findViewById(R.id.im4);
        txt.setText("15");
        final timers tms=new timers(15000,1000);
        Mcq_model mcq=new Mcq_model();
        DatabaseHelper dh=new DatabaseHelper(Main4.this);
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // previous(4);
                show_data(h);
                correct();
                if(h==25)
                {
                    btm.setVisibility(View.INVISIBLE);
                }
                h--;

//eliminate();
                // h--;
                //  eliminate();
                //   btn.setEnabled(true);
                //   if(h==1)
                //   {
                //       btm.setEnabled(false);
                // }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dc=new DatabaseHelper(Main4.this);
                ArrayList<Mcq_model> ms=dc.get_alldata();
                if(i==31)
                {
                    openAlert(v);
                    //    Toast.makeText(getApplicationContext(),"Your Total Score::"+marks,Toast.LENGTH_LONG).show();
                    btm.setVisibility(View.VISIBLE);

                }

                eliminate();
                show_data(i);
                tms.start();
                yu.setText("::"+cor);
                //   check(i);
                on1.setChecked(false);
                on2.setChecked(false);
                on3.setChecked(false);
                on4.setChecked(false);
                btn.setEnabled(false);

                on1.setEnabled(true);
                on2.setEnabled(true);
                on3.setEnabled(true);
                on4.setEnabled(true);
                im1.setVisibility(View.INVISIBLE);
                im2.setVisibility(View.INVISIBLE);
                im3.setVisibility(View.INVISIBLE);
                im4.setVisibility(View.INVISIBLE);
                i++;

            }
        });

        sto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Third.class));
            }
        });
        //     radiog.setOnCheckedChangeListener(this);
        on1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(on1.getText().toString().equalsIgnoreCase(an.getText().toString()))
                {
                    im1.setImageResource(R.drawable.right);
                    im1.setVisibility(View.VISIBLE);
                    cor+=1;
                }
                else
                {
                    im1.setImageResource(R.drawable.wrong);
                    im1.setVisibility(View.VISIBLE);
                }
                on2.setEnabled(false);
                on3.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
            }
        });

        on2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(on2.getText().toString().equalsIgnoreCase(an.getText().toString()))
                {
                    im2.setImageResource(R.drawable.right);
                    im2.setVisibility(View.VISIBLE);
                    cor+=1;
                }
                else
                {
                    im2.setImageResource(R.drawable.wrong);
                    im2.setVisibility(View.VISIBLE);

                }
                on1.setEnabled(false);
                on3.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
            }
        });

        on3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(on3.getText().toString().equalsIgnoreCase(an.getText().toString()))
                {
                    im3.setImageResource(R.drawable.right);
                    im3.setVisibility(View.VISIBLE);
                    cor+=1;
                }
                else
                {
                    im3.setImageResource(R.drawable.wrong);
                    im3.setVisibility(View.VISIBLE);
                }
                on1.setEnabled(false);
                on2.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
            }
        });

        on4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(on4.getText().toString().equalsIgnoreCase(an.getText().toString()))
                {
                    im4.setImageResource(R.drawable.right);
                    im4.setVisibility(View.VISIBLE);
                    cor+=1;
                }
                else
                {
                    im4.setImageResource(R.drawable.wrong);
                    im4.setVisibility(View.VISIBLE);
                }
                on1.setEnabled(false);
                on2.setEnabled(false);
                on3.setEnabled(false);
                btn.setEnabled(true);
            }
        });


    }

    public void openAlert(View v)
    {double per;String res,rem;
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main4.this);
        alertDialog.setTitle("Result");
        alertDialog.setMessage("Total marks in part 1 "+cor*20+"\n"+
                "Total correct answer "+cor);
        alertDialog.setIcon(R.drawable.abc_btn_check_material);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                c=getIntent().getExtras().getInt("correct")+cor;
                openConfirm();
            }
        });
        alertDialog.show();
    }
    public double getPercentage()
    {
        return ((cor*20)*100.0)/160.0;
    }
    public String getResult()
    {
        if(getPercentage()>90 || getPercentage()<=100)
        {return "A-one";}
        else if(getPercentage()>80 || getPercentage()<=90)
        {return "A";}
        else if(getPercentage()>60 || getPercentage()<=80)
        {return "B";}
        else if(getPercentage()>40 || getPercentage()<=60)
        {return "C";}
        else if(getPercentage()>20 || getPercentage()<=40)
        {return "D";}
        else
        { return "Fail";}

    }
    public String getRemarks()
    {
        if(getResult()=="A-one")
        {return "Excellent! Proud of you";}
        else if(getResult()=="A")
        {return "Welldone! Keep it up";}
        else if(getResult()=="B")
        {return "Good! Nice effort";}
        else if(getResult()=="C")
        {return "Fair! Not satisfy";}
        else if(getResult()=="D")
        {return "Poor! Do again";}
        else
        { return "Fail! Need practice";}
    }


    public void openConfirm()
    {
        c=getIntent().getExtras().getInt("correct")+cor;
        sum=getIntent().getExtras().getInt("sm")+cor*20;
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main4.this);
        alertDialog.setTitle("Over all report");
        alertDialog.setMessage("Total Marks:"+sum+"\n"+
        "Total Correct:"+c);
        alertDialog.setIcon(R.drawable.abc_btn_check_material);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent ie=new Intent(Main4.this,Third.class);

                DatabaseHelper dh=new DatabaseHelper(Main4.this);
                dh.putInformation(dh,4,sum,getPercentage(),getResult(),getRemarks());
                ie.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(ie);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

              finish();
            }
        });
        alertDialog.show();
    }

    public void show_data(int i)
    {
        id.setText(""+mm.get(i).getId());
        qu.setText(""+mm.get(i).getQues());
        on1.setText(""+mm.get(i).getOp1());
        on2.setText(""+mm.get(i).getOp2());
        on3.setText(""+mm.get(i).getOp3());
        on4.setText(""+mm.get(i).getOp4());
        an.setText(""+mm.get(i).getAns());

    }

    public void prev_data(int i)
    {
        id.setText(""+mm.get(i).getId());
        qu.setText(""+mm.get(i).getQues());
        on1.setText(""+mm.get(i).getOp1());
        on2.setText("" + mm.get(i).getOp2());
        on3.setText("" + mm.get(i).getOp3());
        on4.setText("" + mm.get(i).getOp4());
        an.setText("" + mm.get(i).getAns());
        //   yu.setText(rm.get(i).toString());
    }
    public void correct()
    {
        if(on1.getText().toString().equalsIgnoreCase(an.getText().toString()))
        {
            im1.setImageResource(R.drawable.right);
            im1.setVisibility(View.VISIBLE);
            im2.setVisibility(View.INVISIBLE);
            im3.setVisibility(View.INVISIBLE);
            im4.setVisibility(View.INVISIBLE);
        }
        else if(on2.getText().toString().equalsIgnoreCase(an.getText().toString()))
        {
            im2.setImageResource(R.drawable.right);
            im2.setVisibility(View.VISIBLE);
            im1.setVisibility(View.INVISIBLE);
            im3.setVisibility(View.INVISIBLE);
            im4.setVisibility(View.INVISIBLE);
        }
        else if(on3.getText().toString().equalsIgnoreCase(an.getText().toString()))
        {
            im3.setImageResource(R.drawable.right);
            im3.setVisibility(View.VISIBLE);
            im1.setVisibility(View.INVISIBLE);
            im2.setVisibility(View.INVISIBLE);
            im4.setVisibility(View.INVISIBLE);
        }
        else
        {
            im4.setImageResource(R.drawable.right);
            im4.setVisibility(View.VISIBLE);
            im1.setVisibility(View.INVISIBLE);
            im2.setVisibility(View.INVISIBLE);
            im3.setVisibility(View.INVISIBLE);
        }
    }


    public void eliminate()
    {
        if(mm.get(i).getOp3()==" " && mm.get(i).getOp4()==" ")
        {
            on3.setVisibility(View.INVISIBLE);
            on4.setVisibility(View.INVISIBLE);
        }
        else
        {
            on3.setVisibility(View.VISIBLE);
            on4.setVisibility(View.VISIBLE);
        }
    }


    public class timers extends CountDownTimer
    {
        public timers(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
          //  long millis=millisUntilFinished;
            String hms=String.format("%02d",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-TimeUnit.MILLISECONDS.toMinutes(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            System.out.println(hms);
            txt.setText(hms);
        }

        @Override
        public void onFinish() {
            btn.setEnabled(false);
            txt.setText("Finished");
            btm.setEnabled(true);
            sto.setVisibility(View.VISIBLE);
        }
    }

}
