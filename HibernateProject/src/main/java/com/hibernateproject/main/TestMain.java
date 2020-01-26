package com.hibernateproject.main;

import com.hibernateproject.dao.BookManager;
import com.hibernateproject.entity.Book;

public class TestMain {
    public static void main(String[] args) {

        Book book = new Book();
        book.setId(3);
        book.setTitle("A walk to remember");
        book.setAuthor("Nicholas Sparks");
        book.setPrice(450);
        Book book1 = new Book();
        book1.setId(5);
        BookManager manager = new BookManager();
        manager.setup();
        //manager.insertBook(book);
        //book = manager.get(3);
        manager.update(book);
        manager.delete(book1);
        //System.out.println(book.getAuthor()+"'s "+book.getTitle());
        manager.exit();
    }
}
