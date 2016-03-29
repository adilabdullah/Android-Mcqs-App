package adil.android.com.computerg;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Account extends Activity {
EditText fname,lname,email,username,password;
   Button save,clear;
    DatabaseHelper dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.save);
        clear=(Button)findViewById(R.id.clear);
   dh=new DatabaseHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           dh.insertUser(dh,fname.toString(),lname.toString(),username.toString(),email.toString(),password.toString());
           Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();
       }
   });
    }


}
