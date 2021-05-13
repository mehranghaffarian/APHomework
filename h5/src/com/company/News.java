package com.company;

public class News {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void display(){System.out.println(title + "\n" + content);}

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
