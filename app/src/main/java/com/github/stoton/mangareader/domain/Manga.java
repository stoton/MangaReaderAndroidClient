package com.github.stoton.mangareader.domain;


import java.util.List;

public class Manga {
    private long id;
    private String title;
    private String cover;
    private String mangaUrl;

    public Manga() {}

    public Manga(long id, String title, String cover, String mangaUrl) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.mangaUrl = mangaUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getMangaUrl() {
        return mangaUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setMangaUrl(String mangaUrl) {
        this.mangaUrl = mangaUrl;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
