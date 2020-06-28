package basics.sockets.gameQuestions;

import java.io.Serializable;

public class StoringClients implements Serializable, Comparable<StoringClients> {
    static final long serialVersionUID=421L;
    String name;
    ClientAnswers[] clientAnswers;
    double time;
    int score;

    public StoringClients() {
        name="N/A";
        time=0;
        clientAnswers=new ClientAnswers[0];
        score=0;
    }

    public StoringClients(String name, ClientAnswers[] clientAnswers, double time, int score) {
        this.name = name;
        this.clientAnswers = clientAnswers;
        this.time = time;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientAnswers[] getClientAnswers() {
        return clientAnswers;
    }

    public void setClientAnswers(ClientAnswers[] clientAnswers) {
        this.clientAnswers = clientAnswers;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(StoringClients storingClients) {
        if(this.score<storingClients.score)
            return 1;
        else if(this.score>storingClients.score)
            return -1;
        else{
            if(this.time>storingClients.time)
                return 1;
            else if(this.time<storingClients.time)
                return -1;
            else
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Name  :"+name+"\n"+"Score :"+score+"\n"+"Time  :"+time;
    }
}
