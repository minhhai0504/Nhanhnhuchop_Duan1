package com.example.nhanhnhuchop_duan1.model;

public class Question {
    public String Id,Question,A,B,C,D,True;

    public Question(String id, String question, String a, String b, String c, String d, String aTrue) {
        Id = id;
        Question = question;
        A = a;
        B = b;
        C = c;
        D = d;
        True = aTrue;
    }

    public Question() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getQuestion() {
        return Question;
    }


    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getTrue() {
        return True;
    }

    public void setTrue(String aTrue) {
        True = aTrue;
    }

}
