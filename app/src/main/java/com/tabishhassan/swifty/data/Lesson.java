package com.tabishhassan.swifty.data;

/**
 * Created by tabishhassan on 7/15/15.
 */
public class Lesson {
    private String name = "";
    private boolean is_Learned = false;

    public Lesson(String name , Boolean is_Learned)
    {
        this.name = name;
        this.is_Learned = is_Learned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_Learned(boolean is_Learned) {
        this.is_Learned = is_Learned;
    }

    public boolean getis_Learned() {
        return is_Learned;
    }
}
