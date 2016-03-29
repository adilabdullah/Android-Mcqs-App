package adil.android.com.computerg;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class Third extends ActionBarActivity {
    Button start,exit,inst,score,about,anim,quiz,account,css,js,jquery,alert;
String user;
    EditText username,password;
    DatabaseHelper dh;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        start=(Button)findViewById(R.id.start);
        score=(Button)findViewById(R.id.score);
        about=(Button)findViewById(R.id.about);
        exit=(Button)findViewById(R.id.exit);
        inst=(Button)findViewById(R.id.inst);
        anim=(Button)findViewById(R.id.anim);
account=(Button)findViewById(R.id.account);
        css=(Button)findViewById(R.id.css);
        js=(Button)findViewById(R.id.js);
        jquery=(Button)findViewById(R.id.jquery);
alert=(Button)findViewById(R.id.alert);
username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(Third.this);
                View promptsView = li.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Third.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.username);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                       // result.setText(userInput.getText());
                                       c=dh.getLogin(username.getText().toString(),password.getText().toString());
                                        if((username.getText().toString().equalsIgnoreCase(c.getString(3))) && (password.getText().toString().equalsIgnoreCase(c.getString(5))))
                                        {
                                            Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(),"Not Successfull",Toast.LENGTH_SHORT).show();
                                        }
                                        //user=username.getText().toString();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), Main2.class));
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                css.startAnimation(rotation);
            }
        });

        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main3.class));
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                js.startAnimation(rotation);
            }
        });

        jquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main4.class));
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                jquery.startAnimation(rotation);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Account.class));
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                account.startAnimation(rotation);
            }
        });


                anim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Second.class));

                    }
                });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   ObjectAnimator animation1 =ObjectAnimator.ofFloat(imageView,"translationY",-500,0);
                //   animation1.setDuration(1300);
                //   ObjectAnimator animation2 =ObjectAnimator.ofFloat(imageView,"rotation", 0, 360);
                //   animation2.setDuration(1300);
                //   AnimatorSet animatorset=new AnimatorSet();
                //   animatorset.playTogether(animation1,animation2);
                //   animatorset.start();
                Intent in = new Intent(Third.this, MainActivity.class);
                //in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             //   in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                start.startAnimation(rotation);
                startActivity(in);
               /// overridePendingTransition(R.anim.anim1, R.anim.anim2);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),Third.class);
               /* intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent); */
               // setResult(RESULT_CLOSE_ALL);
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                exit.startAnimation(rotation);
                finish();
            }
        });

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                inst.startAnimation(rotation);
                ViewInstruction();

            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAll();
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                score.startAnimation(rotation);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Third.this,About.class));
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling);
                rotation.setRepeatCount(Animation.INFINITE);
                about.startAnimation(rotation);
            }
        });
    }
  /*  public void Adddata()
    {
      //  fname=(EditText)findViewById(R.id.fname);
      //  lname=(EditText)findViewById(R.id.lname);
      //  email=(EditText)findViewById(R.id.email);
      //  fna=fname.getText().toString();
      //  lna=lname.getText().toString();
      //  ema=email.getText().toString();
      //  db.execSQL("INSERT into Student VALUES('"+fna+"','"+lna+"','"+ema+"');");
      //  Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
    }
    public void display()
    {
        Cursor c=db.rawQuery("select * from Student",null);
        int count=c.getCount();
        c.moveToFirst();
        TableLayout tbl=new TableLayout(getApplicationContext());
        tbl.setVerticalScrollBarEnabled(true);
        TableRow tablerow;
        TextView text,text1,text2,text3,text4,text5;
        tablerow=new TableRow(getApplicationContext());
        text=new TextView(getApplicationContext());
        text.setText("First Name");
        text.setTextColor(Color.RED);
        text.setTypeface(null, Typeface.BOLD);
        text.setPadding(20,20,20,20);
        tablerow.addView(text);
        text1=new TextView(getApplicationContext());
        text1.setText("Last Name");
        text1.setTextColor(Color.RED);
        text1.setTypeface(null, Typeface.BOLD);
        text1.setPadding(20,20,20,20);
        tablerow.addView(text1);
        text2=new TextView(getApplicationContext());
        text2.setText("Email");
        text2.setTextColor(Color.RED);
        text2.setTypeface(null, Typeface.BOLD);
        text2.setPadding(20,20,20,20);
        tablerow.addView(text2);
        tbl.addView(tablerow);
        for(int j=0;j<count;j++)
        {
            tablerow=new TableRow(getApplicationContext());
            text=new TextView(getApplicationContext());
            text.setTextColor(Color.BLUE);
            text.setText(c.getString(c.getColumnIndex("fname")));
            text1=new TextView(getApplicationContext());
            text1.setTextColor(Color.BLUE);
            text1.setText(c.getString(c.getColumnIndex("lanme")));
            text2=new TextView(getApplicationContext());
            text2.setTextColor(Color.BLUE);
            text2.setText(c.getString(c.getColumnIndex("email")));
            text.setPadding(20,20,20,20);
            text1.setPadding(20,20,20,20);
            text2.setPadding(20,20,20,20);
            tablerow.addView(text);
            tablerow.addView(text1);
            tablerow.addView(text2);
            tbl.addView(tablerow);
            c.moveToNext();
        }
        setContentView(tbl);
    }  */
  public void ViewAll()
  {
      DatabaseHelper de=new DatabaseHelper(Third.this);
      Cursor res=de.getallData();
      if(res.getCount()==0)
      {
          ShowMessage("Error","No Data Found");
      }
      else{
          StringBuffer buffer=new StringBuffer();
          while(res.moveToNext())
          {
              buffer.append("sno :"+res.getString(0)+"\n");
              buffer.append("round :"+res.getString(1)+"\n");
              buffer.append("marks :"+res.getString(2)+"\n");
              buffer.append("percentage :"+res.getString(3)+"\n");
              buffer.append("result 3 :"+res.getString(4)+"\n");
              buffer.append("remark 4 :"+res.getString(5)+"\n");
              buffer.append("date :"+res.getString(6)+"\n");
          }
          ShowMessage("Data",buffer.toString());

      }
  }
    public void ShowMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }

    public void ViewInstruction()
    {
        StringBuffer buffer=new StringBuffer();

        buffer.append("\tQuestion:\n");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("The question arise on the top the page with two or three line text in black color.There are 32 question in quiz divided in 4 parts each have 8 question.");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("\tOptions:\n");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("Each question can have 4 option few question can have 2 option as well true and false.The user have to select only one option at a time.If user select an option the other option disabled and next button enabled.The user have to select an option within 20 sec of time interval otherwise go to next question.");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("\tNext Button:\n");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("The next button pull the next question of your question.The next button \n" +
                "disabled when new question arrives and enbaled when you select an option.");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("\tCheck Correct Answer:\n");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("This question visible only when your quiz end or your question time finnish.By pressing this button you check correct answer of previously did questions.");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("\tResult:\n");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("After completing of round the dialog box occur to show the result of completig round.");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("\tConfirm Dialog:\n");
        buffer.append(Html.fromHtml("<hr>"));
        buffer.append("After pressing OK button on result dialog confirm dialog occur.The confirm dialog has 2 options 1:quit,2:continue.By pressing quit you can quit your app.While pressing continue you can continue to second round.");
        ShowInstruction("Instructions", buffer.toString());
    }
    public void ShowInstruction(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }
}
