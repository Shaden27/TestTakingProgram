package basics.sockets.gameQuestions;

import java.io.Serializable;

public class Questions implements Serializable,Comparable<Questions> {
    static final long serialVersionUID=420L;
    String question;
    double answer;
    int qID;

    public Questions() {
        qID=0;
        question="N/A";
        answer=0;
    }

    public Questions(int qID, String question, double answer) {
        this.qID = qID;
        this.question = question;
        this.answer = answer;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return qID+")"+question+"\n"+"A:"+answer;
    }

    @Override
    public int compareTo(Questions q) {
        return Integer.compare(this.qID, q.qID);
    }
}

