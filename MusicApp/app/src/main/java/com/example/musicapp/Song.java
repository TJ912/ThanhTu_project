package com.example.musicapp;



public class Song {
    private String  name;
    private String singer;
    private Integer picture;
    private String url;

    public Song(String name, String singer, Integer picture, String url) {
        this.name = name;
        this.singer = singer;
        this.picture = picture;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public Integer getPicture() {
        return picture;
    }

    public String getMusic() {
        return url;
    }
}
