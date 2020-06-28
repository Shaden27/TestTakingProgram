package basics.sockets.gameQuestions;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Assessment {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("C:\\Coding\\CodeBlocks\\Projects\\Js\\First\\src\\basics\\sockets\\gameQuestions\\files\\ClientFiles.dat"));
        ArrayList<StoringClients> arrayList=new ArrayList<>();
        while(true){
            try {
                arrayList.add((StoringClients) oin.readObject());
            }catch (EOFException e){
                System.out.println(e);
                break;
            }
        }
        oin.close();
        Collections.sort(arrayList);
        int i=1;
        for(StoringClients s : arrayList){
            System.out.println(i++);
            System.out.println(s);
            System.out.println("");
        }
    }
}
