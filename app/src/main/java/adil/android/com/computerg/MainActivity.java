package adil.android.com.computerg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity  {
private RadioGroup radiog;
 private int cor=0;
    private Button btn,btm,sto;
    private TextView id,qu,an,txt,yu;
    private ImageView im1,im2,im3,im4;
    private RadioButton on1,on2,on3,on4,checks;
    private  int i=1,j;
    private int h=8;
    DatabaseHelper dh=new DatabaseHelper(MainActivity.this);
    ArrayList<Mcq_model> mm=dh.get_alldata();
    ArrayList<String> given=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yu = (TextView) findViewById(R.id.your);
        btn = (Button) findViewById(R.id.next);
        sto = (Button) findViewById(R.id.stop);
        btm = (Button) findViewById(R.id.prev);
        id = (TextView) findViewById(R.id.sno);
        qu = (TextView) findViewById(R.id.ques);
        on1 = (RadioButton) findViewById(R.id.op1);
        on2 = (RadioButton) findViewById(R.id.op2);
        on3 = (RadioButton) findViewById(R.id.op3);
        on4 = (RadioButton) findViewById(R.id.op4);
        txt = (TextView) findViewById(R.id.txt);
        an = (TextView) findViewById(R.id.ans);
        radiog = (RadioGroup) findViewById(R.id.rag);
        im1 = (ImageView) findViewById(R.id.im1);
        im2 = (ImageView) findViewById(R.id.im2);
        im3 = (ImageView) findViewById(R.id.im3);
        im4 = (ImageView) findViewById(R.id.im4);
        txt.setText("15");
        final timers tms = new timers(15000, 1000);
        Mcq_model mcq = new Mcq_model();
        DatabaseHelper dh = new DatabaseHelper(MainActivity.this);

        sto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Third.class));
            }
        });

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // previous(4);

              //  show_data(h);
               // correct();
                h=i;
                previous(h);
                if (h == 1) {
                    btm.setVisibility(View.INVISIBLE);
                }
                h--;
                im1.setVisibility(View.VISIBLE);
                im2.setVisibility(View.VISIBLE);
                im3.setVisibility(View.VISIBLE);
                im4.setVisibility(View.VISIBLE);
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

                DatabaseHelper dc = new DatabaseHelper(MainActivity.this);
                ArrayList<Mcq_model> ms = dc.get_alldata();
                if (i == 8) {
                    openAlert(v);
                    //    Toast.makeText(getApplicationContext(),"Your Total Score::"+marks,Toast.LENGTH_LONG).show();
                    btm.setVisibility(View.VISIBLE);
btn.setVisibility(View.INVISIBLE);
                }

                eliminate();
                show_data(i);
                tms.start();
                yu.setText("::" + cor);
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
Answers();
            }
        });
    }
   //     radiog.setOnCheckedChangeListener(this);

/*        public void Answering() {
        on1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String yours=null;
                if (on1.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im1.setImageResource(R.drawable.right);
                      im1.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im1.setImageResource(R.drawable.wrong);
                     im1.setVisibility(View.VISIBLE);
                }
                given.add(on1.getText().toString());
                on2.setEnabled(false);
                on3.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
                yours = on1.getText().toString();
                yu.setText("" + yours);
            }
        });

        on2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String yours=null;
                if (on2.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im2.setImageResource(R.drawable.right);
                     im2.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im2.setImageResource(R.drawable.wrong);
                         im2.setVisibility(View.VISIBLE);
                }
                given.add(on2.getText().toString());
                on1.setEnabled(false);
                on3.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
                yours = on2.getText().toString();
                yu.setText("" + yours);
            }
        });

        on3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String yours=null;
                if (on3.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im3.setImageResource(R.drawable.right);
                     im3.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im3.setImageResource(R.drawable.wrong);
                         im3.setVisibility(View.VISIBLE);
                }
                given.add(on3.getText().toString());
                on1.setEnabled(false);
                on2.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
                yours = on3.getText().toString();
                yu.setText("" + yours);
            }
        });

        on4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String yours=null;
                if (on4.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im4.setImageResource(R.drawable.right);
                          im4.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im4.setImageResource(R.drawable.wrong);
                          im4.setVisibility(View.VISIBLE);
                }
                given.add(on4.getText().toString());
                on1.setEnabled(false);
                on2.setEnabled(false);
                on3.setEnabled(false);
                btn.setEnabled(true);
                yours = on4.getText().toString();
                yu.setText("" + yours);
            }
        });

    }  */

    public void Answers()
    {
        on1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yours=null;
                if (on1.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im1.setImageResource(R.drawable.right);
                         im1.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im1.setImageResource(R.drawable.wrong);
                    im1.setVisibility(View.VISIBLE);
                }
                given.add(on1.getText().toString());
                on2.setEnabled(false);
                on3.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
                yours = on1.getText().toString();
                yu.setText("" + yours);

            }
        });
        on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yours=null;
                if (on2.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im2.setImageResource(R.drawable.right);
                      im2.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im2.setImageResource(R.drawable.wrong);
                       im2.setVisibility(View.VISIBLE);
                }
                given.add(on2.getText().toString());
                on1.setEnabled(false);
                on3.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
                yours = on2.getText().toString();
                yu.setText("" + yours);

            }
        });
        on3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yours=null;
                if (on3.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im3.setImageResource(R.drawable.right);
                             im3.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im3.setImageResource(R.drawable.wrong);
                   im3.setVisibility(View.VISIBLE);
                }
                given.add(on3.getText().toString());
                on1.setEnabled(false);
                on2.setEnabled(false);
                on4.setEnabled(false);
                btn.setEnabled(true);
                yours = on3.getText().toString();
                yu.setText("" + yours);

            }
        });
        on4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yours=null;
                if (on4.getText().toString().equalsIgnoreCase(an.getText().toString())) {
                    im4.setImageResource(R.drawable.right);
                         im4.setVisibility(View.VISIBLE);
                    cor += 1;
                } else {
                    im4.setImageResource(R.drawable.wrong);
                           im4.setVisibility(View.VISIBLE);
                }
                given.add(on4.getText().toString());
                on1.setEnabled(false);
                on2.setEnabled(false);
                on3.setEnabled(false);
                btn.setEnabled(true);
                yours = on4.getText().toString();
                yu.setText("" + yours);
            }
        });

    }
    /*    radiog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

               switch(checkedId)
               {
                   case R.id.op1:
                   {
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
                       btn.setEnabled(true);
                     given.add(on1.getText().toString());
                       break;
                   }
                   case R.id.op2:
                   {
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
                       btn.setEnabled(true);
                       given.add(on2.getText().toString());
                       break;
                   }
                   case R.id.op3:
                   {
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
                       btn.setEnabled(true);
                       given.add(on3.getText().toString());
                       break;
                   }
                   case R.id.op4:
                   {
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
                       btn.setEnabled(true);
                       given.add(on4.getText().toString());
                       break;
                   }
                   default:
                   {
                     Toast.makeText(getApplicationContext(),"No Option Selected",Toast.LENGTH_SHORT).show();
                   break;
                   }


               }
            }
        });  */

    public void previous(int i)
    {
        id.setText(""+mm.get(i).getId());
        qu.setText(""+mm.get(i).getQues());
        on1.setText(""+mm.get(i).getOp1());
        on2.setText("" + mm.get(i).getOp2());
        on3.setText("" + mm.get(i).getOp3());
        on4.setText("" + mm.get(i).getOp4());
        an.setText("" + mm.get(i).getAns());
       if(given.get(i-1).equalsIgnoreCase(on1.getText().toString()))
       {
           im1.setImageResource(R.drawable.right);

       }
        else
       {
           im1.setImageResource(R.drawable.wrong);
       }

        if(given.get(i-1).equalsIgnoreCase(on2.getText().toString()))
        {
            im2.setImageResource(R.drawable.right);

        }
        else
        {
            im2.setImageResource(R.drawable.wrong);
        }

        if(given.get(i-1).equalsIgnoreCase(on3.getText().toString()))
        {
            im3.setImageResource(R.drawable.right);

        }
        else
        {
            im3.setImageResource(R.drawable.wrong);
        }

        if(given.get(i-1).equalsIgnoreCase(on4.getText().toString()))
        {
            im4.setImageResource(R.drawable.right);

        }
        else
        {
            im4.setImageResource(R.drawable.wrong);
        }

        im1.setVisibility(View.VISIBLE);
        im2.setVisibility(View.VISIBLE);
        im3.setVisibility(View.VISIBLE);
        im4.setVisibility(View.VISIBLE);

    /*    for(int k=1;k<=4;k++)
        {
            if(given.get(i-1).equalsIgnoreCase(mm.get(i).toString()))
            {
                im1.setImageResource(R.drawable.right);
            }
            else
            {

            }
        }  */
  /*      if(given.get(i-1).toString().equalsIgnoreCase(an.getText().toString()))
        {

        }


        if((given.get(i-1).toString())!=(on1.getText().toString()))
   {
       im1.setImageResource(R.drawable.wrong);
   }
        else if((given.get(i-1).toString())!=(on2.getText().toString()))
        {
            im2.setImageResource(R.drawable.wrong);
        }
        else if((given.get(i-1).toString())!=(on3.getText().toString()))
        {
            im3.setImageResource(R.drawable.wrong);
        }
        else if((given.get(i-1).toString())!=(on4.getText().toString()))
        {
            im4.setImageResource(R.drawable.wrong);
        }  */


    }




    public void openAlert(View v)
    {double per;String res,rem;
       final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Result");
        alertDialog.setMessage("Total marks in part 1 "+cor*5+"\n"+
        "Total correct answer "+cor);
        alertDialog.setIcon(R.drawable.abc_btn_check_material);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                openConfirm();
            }
        });
        alertDialog.show();
    }
    public double getPercentage()
    {
        return ((cor*5)*100.0)/40.0;
    }
    public String getResult()
    {
        if(getPercentage()>90.0 || getPercentage()<=100.0)
        {return "A-one";}
        else if(getPercentage()>80.0 || getPercentage()<=90.0)
        {return "A";}
        else if(getPercentage()>60.0 || getPercentage()<=80.0)
        {return "B";}
        else if(getPercentage()>40.0 || getPercentage()<=60.0)
        {return "C";}
        else if(getPercentage()>20.0 || getPercentage()<=40.0)
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
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Status");
        alertDialog.setMessage("Would you like to go in next part");
        alertDialog.setIcon(R.drawable.abc_btn_check_material);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent ie = new Intent(MainActivity.this, Main2.class);
                ie.putExtra("correct", cor);
                ie.putExtra("sm", cor * 5);
                // ie.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ie.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(ie);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHelper dh = new DatabaseHelper(MainActivity.this);
                dh.putInformation(dh, 1, cor * 5, getPercentage(), getResult(), getRemarks());
                // Intent ie = new Intent(MainActivity.this, Third.class);
                //ie.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //  ie.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //  startActivity(ie);
                Givenanswer();
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

    public void Givenanswer()
    {
        StringBuffer buffer = new StringBuffer();
        for(int j=0;j<given.size();j++)
        {
            buffer.append("\n"+j+":"+given.get(j).toString());
        }
        ShowMessage("Data", buffer.toString());
    }

    public void ShowMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }

    public class timers extends CountDownTimer
    {
        public timers(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
         //   long millis=millisUntilFinished;
            String hms=String.format("%02d",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-TimeUnit.MILLISECONDS.toMinutes(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            System.out.println(hms);
            txt.setText(hms);
        }

        @Override
        public void onFinish() {
            btn.setEnabled(false);
            txt.setText("Finished");
        btm.setVisibility(View.VISIBLE);
            sto.setVisibility(View.VISIBLE);
        }
    }

}
