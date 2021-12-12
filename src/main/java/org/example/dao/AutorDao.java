package org.example.dao;

import lombok.AllArgsConstructor;
import org.example.HibernateFactory;
import org.example.model.Autor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

@AllArgsConstructor

public class AutorDao {

    private HibernateFactory hibernateFactory;

    public void add(Autor autor) {

        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(autor);
        transaction.commit();
        session.close();
    }

    public Autor getById(Integer id) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Autor autor = session.find(Autor.class, id);
        session.close();
        return autor;
    }

    public List<Autor> getAll() {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Autor> fromAutor = session.createQuery("From Autor", Autor.class).list();
        session.close();
        return fromAutor;
    }
    public List<Autor> getByAge(Integer age){
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Autor> query = session.createQuery("From Autor a WHERE a.age = : age", Autor.class);
        query.setParameter("age",age);
        List<Autor> list = query.list();

        session.close();
        return list;

    }
}
