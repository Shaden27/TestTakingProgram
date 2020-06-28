package basics.sockets.gameQuestions;

import java.io.Serializable;

public class ClientAnswers implements Serializable {
    int qID;
    double clientAns;
    String question;
    boolean rightWrong;

    public ClientAnswers() {
        qID=0;
        clientAns=0;
        question="N/A";
        rightWrong=false;
    }

    public ClientAnswers(int qID, double clientAns, String question, boolean rightWrong) {
        this.qID = qID;
        this.clientAns = clientAns;
        this.question = question;
        this.rightWrong=rightWrong;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public double getClientAns() {
        return clientAns;
    }

    public void setClientAns(double clientAns) {
        this.clientAns = clientAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isRightWrong() {
        return rightWrong;
    }

    public void setRightWrong(boolean rightWrong) {
        this.rightWrong = rightWrong;
    }

    @Override
    public String toString() {
        return qID+") "+question+"\n"+"Ans:"+clientAns+"\n"+rightWrong;
    }
}
