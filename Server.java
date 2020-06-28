package basics.sockets.gameQuestions;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Questions> arrayList=new ArrayList<>();
        ServerSocket ss=new ServerSocket(8020);
        Socket s;
        Scanner din;
        PrintWriter dout;
        String name;
        ClientAnswers[] ca;
        int score;
        double start,stop,totalTime;
        File myfile=new File("C:\\Coding\\CodeBlocks\\Projects\\Js\\First\\src\\basics\\sockets\\gameQuestions\\files\\ClientFiles.dat");
        if(!myfile.exists()) {
            myfile.createNewFile();
        }
        ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream("YOURFILENAME FOR CLIENTDETAILS"));

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("YOURFILENAME FOR QUESTIONS"));
        for(int i=0;i<10;i++) {
            arrayList.add((Questions) oin.readObject());
        }
        double d;
        while(true){
            s=ss.accept();
            start=System.nanoTime();
            din=new Scanner(s.getInputStream());
            dout=new PrintWriter(s.getOutputStream());
            name=din.nextLine();
            ca=new ClientAnswers[10];
            score=0;
            for(int i=0;i<10;i++){
                ca[i]=new ClientAnswers();
                dout.println(arrayList.get(i).qID);
                dout.flush();
                dout.println(arrayList.get(i).question);
                dout.flush();
                ca[i].qID=arrayList.get(i).qID;
                ca[i].question=arrayList.get(i).question;
                d=din.nextDouble();
                ca[i].clientAns=d;
                if(arrayList.get(i).answer==d){
                    dout.println(true);
                    dout.flush();
                    ca[i].rightWrong=true;
                    score++;
                }
                else {
                    dout.println(false);
                    dout.flush();
                    ca[i].rightWrong=false;
                }
            }
            stop=System.nanoTime();
            totalTime=stop-start;
            totalTime=totalTime/1000000000;
            System.out.println("Time ="+totalTime);
            oout.writeObject(new StoringClients(name, ca,totalTime,score));
        }
    }
}
