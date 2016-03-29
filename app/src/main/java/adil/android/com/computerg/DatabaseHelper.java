package adil.android.com.computerg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by pc on 12/19/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_Name = "adil.sqlite";
    private Context mcontext;
    private String path = "/data/data/adil.android.com.computerg/databases/";
    private SQLiteDatabase myDatabase;
    ArrayList<Mcq_model> arr = new ArrayList<Mcq_model>();

    public DatabaseHelper(Context context) {
        super(context, DB_Name, null, 1);
        this.mcontext = context;
    }

    public void create_database() {
        if (check_database()) {

        } else {
            copydatabase();
        }
    }

    public boolean check_database() {
        File f = new File(path + DB_Name);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void copydatabase() {
        try {
            InputStream is = mcontext.getAssets().open(DB_Name);
            String ou_filename = path + DB_Name;
            OutputStream mystream = new FileOutputStream(ou_filename);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                mystream.write(buffer, 0, length);
            }
            mystream.flush();
            mystream.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open_database() {
        myDatabase = SQLiteDatabase.openDatabase(path + DB_Name, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public void close_database() {
        if (myDatabase != null) {
            myDatabase.close();
        }
    }

    public ArrayList<Mcq_model> get_alldata() {
        open_database();
        Cursor c = myDatabase.query("first", null, null, null, null, null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    Mcq_model mcq = new Mcq_model();
                    mcq.setId(c.getInt(0));
                    mcq.setQues(c.getString(1));
                    mcq.setOp1(c.getString(2));
                    mcq.setOp2(c.getString(3));
                    mcq.setOp3(c.getString(4));
                    mcq.setOp4(c.getString(5));
                    mcq.setAns(c.getString(6));
                    arr.add(mcq);

                }
                while (c.moveToNext());
            }
        }
        c.close();
        myDatabase.close();
        return arr;
    }
        public Cursor Show_data()
        {
            open_database();
            String[] col={"sno","image","question","op1","op2","op3","op4","ans"};
            Cursor cc=myDatabase.query("second",col,null,null,null,null,null);

            cc.close();
            myDatabase.close();
            return cc;
        }

    public void putInformation(DatabaseHelper dx,int round,int marks,double per,String res,String rem)
    {
        open_database();
        SQLiteDatabase sq=dx.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("round",round);
        cv.put("marks",marks);
        cv.put("percentage",per);
        cv.put("result",res);
        cv.put("remark",rem);
        long k=sq.insert("score",null,cv);
        Log.d("Database Operation", "One Row Inserted");
    }
    public Cursor getallData()
    {
        open_database();
      //  Cursor cc=myDatabase.query("score",null,null,null,null,null,null);
        return myDatabase.rawQuery("SELECT * FROM score ORDER BY marks DESC LIMIT 5",null);
    }

    public void insertUser(DatabaseHelper dx,String fname,String lname,String username,String email,String password)
    {
        open_database();
        SQLiteDatabase sq=dx.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("fname",fname);
        cv.put("lname",lname);
        cv.put("email",email);
        cv.put("username",username);
        cv.put("password",password);
        long k=sq.insert("user_info",null,cv);
        Log.d("Database Operation", "One Row Inserted");
    }

    public Cursor getLogin(String user,String pass)
    {
        open_database();
        //  Cursor cc=myDatabase.query("score",null,null,null,null,null,null);
        return myDatabase.rawQuery("select * from user_info where username='"+user+"' and password='"+pass+"'",null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
