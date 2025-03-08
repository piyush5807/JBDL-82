package main;

import java.util.Date;

public class Video {     // blue print of the real world entity

    public Video(){

    }

    private String name; // properties
    protected int duration;
    public String createdBy;

    Date createdOn;

    public int getDurationOfVideo(){  // behaviour
        return duration;
    }

    public static void main(String[] args) {
        Video video = new Video(); // analogous to real world entity

    }
}
