package org.example.dao;

import lombok.AllArgsConstructor;
import org.example.HibernateFactory;
import org.example.model.Autor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public class AutorDao {

    private HibernateFactory hibernateFactory;

    public void add (Autor autor){

        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(autor);
        transaction.commit();
        session.close();
    }

    public Autor getById(Integer id){
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Autor autor = session.find(Autor.class, id);
        session.close();
        return autor;
    }

}
