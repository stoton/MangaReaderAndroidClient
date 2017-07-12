package com.github.stoton.mangareader.domain;

import java.util.List;

public class MangaChapter {
    private long id;
    private String url;
    private long length;
    private long number;


    private MangaChapter() {}

    public MangaChapter(long id, String url, long length, long number) {
        this.id = id;
        this.url = url;
        this.length = length;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MangaChapter{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", length=" + length +
                ", number=" + number +
                '}';
    }
}
