package basics.sockets.gameQuestions;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class QuestionCreator {
    public static void main(String[] args) throws IOException, ScriptException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Scanner sc=new Scanner(System.in);
        Questions[] q=new Questions[10];
        File myfile=new File("C:\\Coding\\CodeBlocks\\Projects\\Js\\First\\src\\basics\\sockets\\gameQuestions\\files\\Questions.dat");
        if(!myfile.exists()) {
            myfile.createNewFile();
        }
        ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream("C:\\Coding\\CodeBlocks\\Projects\\Js\\First\\src\\basics\\sockets\\gameQuestions\\files\\Questions.dat"));
        String k;
        Object obj;
        double a;
        for(int i=0;i<10;i++){
            System.out.println("Enter Question");
            q[i]=new Questions();
            q[i].setqID(i+1);
            k=sc.nextLine();
            q[i].setQuestion(k);
            obj=engine.eval(k);
            try{
                q[i].setAnswer((Integer)obj*1.0);
            }catch(ClassCastException c){
                q[i].setAnswer((Double) obj);
            }
            oout.writeObject(q[i]);
        }
        oout.close();
    }
}
