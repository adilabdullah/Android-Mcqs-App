package adil.android.com.computerg;

/**
 * Created by pc on 12/19/2015.
 */
public class Mcq_model
{
    private int id;
    private String ques,op1,op2,op3,op4,ans;

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4)
    {
        if(op4.equalsIgnoreCase("oo"))
        {
            this.op4=" ";
        }
        else
        {
            this.op4 = op4;
        }

    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3)
    {
        if(op3.equalsIgnoreCase("oo"))
        {
            this.op3=" ";
        }
        else
        {
            this.op3 = op3;
        }

    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
