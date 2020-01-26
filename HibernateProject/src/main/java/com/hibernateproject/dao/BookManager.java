package com.hibernateproject.dao;

import com.hibernateproject.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {
    protected SessionFactory sessionFactory;

    public void setup(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
            System.out.println(e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void exit(){
        sessionFactory.close();
    }

    public Book get(int bookid){
        Book book = new Book();
        Session session = sessionFactory.openSession();
        try{
            book = session.get(Book.class,bookid);
        }catch (Exception e){
            System.out.println(e);
        }
        return book;
    }


    public void insertBook(Book book){
        Session session = sessionFactory.openSession();
        try{
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
            System.out.println("Book inserted");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            session.close();
        }
    }
    public void update(Book book){
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            System.out.println("Book updated");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            session.close();
        }
    }

    public void delete(Book book){
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            System.out.println("Record deleted");
        }catch (Exception e){}



    }


}
