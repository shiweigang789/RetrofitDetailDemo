package com.swg.retrofitdetaildemo.entity;

/**
 * Created by swg on 2017/8/31.
 */

public class Blog {

    /**
     * id : 1
     * date : 2017-08-31 05:14:52
     * author : 怪盗kidou
     * title : Retrofit2 测试1
     * content : 这里是 Retrofit2 Demo 测试服务器1
     */

    private int id;
    private String date;
    private String author;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
