package com.example.himanshu.sps.ADMIN;

public class NewsFeed {
    int imagesrc;
    String heading;

    public NewsFeed(int imagesrc, String heading) {
        this.imagesrc = imagesrc;
        this.heading = heading;
    }

    public int getImageSrc() {
        return imagesrc;
    }

    public String getHeading() {
        return heading;
    }
}
