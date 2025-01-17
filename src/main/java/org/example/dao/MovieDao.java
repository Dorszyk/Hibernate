package org.example.dao;

import lombok.AllArgsConstructor;
import org.example.HibernateFactory;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

@AllArgsConstructor

public class MovieDao {

    private HibernateFactory hibernateFactory;

    public void add(Movie movie) {

        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movie);
        transaction.commit();
        session.close();
    }

    public Movie getById(Integer id) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Movie movie = session.find(Movie.class, id);
        session.close();

        return movie;

    }

    public List<Movie> getAll() {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Movie> fromMovie = session.createQuery("From Movie", Movie.class).list();
        session.close();
        return fromMovie;
    }

    public List<Movie> getByTitle(String titleFromMethod) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Query<Movie> query = session.createQuery("From Movie m WHERE m.title = : titleToFind", Movie.class);
        query.setParameter("titleToFind", titleFromMethod);
        List<Movie> list = query.list();

        session.close();
        return list;
    }

}
