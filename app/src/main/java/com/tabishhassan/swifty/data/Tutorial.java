package com.tabishhassan.swifty.data;

/**
 * Created by tabishhassan on 7/14/15.
 */
public class Tutorial {
    private String name = "";
    private int totalNumberOfLec = 0;
    private int learnedLesson = 0;
    private int imageResource = 0;

    public Tutorial(String name,int totalNumberOfLec,int learnedLesson,int imageResource )
    {
        this.name = name;
        this.totalNumberOfLec = totalNumberOfLec;
        this.learnedLesson = learnedLesson;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getLearnedLesson() {
        return learnedLesson;
    }

    public int getTotalNumberOfLec() {
        return totalNumberOfLec;
    }
}
