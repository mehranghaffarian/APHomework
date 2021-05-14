package com.company;
/**
 *simulates the news with its content
 * @author mehranghaffarian
 * */
public class News {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }
    /**
     *displays the news component
     * */
    public void display(){System.out.println(title + ":\n" + content);}
}
