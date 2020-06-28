package basics.sockets.gameQuestions;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        ClientAnswers[] ca=new ClientAnswers[10];
        double d;
        Scanner sc=new Scanner(System.in);
        Socket s=new Socket("localhost",8020);
        Scanner din=new Scanner(s.getInputStream());
        Scanner sc2=new Scanner(System.in);
        PrintWriter dout=new PrintWriter(s.getOutputStream());
        System.out.println("Enter Name");
        dout.println(sc2.nextLine());
        dout.flush();

        for(int i=0;i<10;i++){
            ca[i]=new ClientAnswers();
            ca[i].qID=din.nextInt();
            ca[i].question=din.next();
            System.out.println(ca[i].qID+")"+ca[i].question);
            d=sc.nextDouble();
            dout.println(d);
            dout.flush();
            ca[i].clientAns=d;
            if(din.nextBoolean()){
                ca[i].rightWrong=true;
            }
            else{
                ca[i].rightWrong=false;
            }
        }
        for(int i=0;i<10;i++){
            System.out.println(ca[i]);
        }
    }
}