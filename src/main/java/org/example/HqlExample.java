package org.example;

import org.example.dao.AutorDao;
import org.example.dao.MovieDao;
import org.example.model.Autor;
import org.example.model.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HqlExample {
    public static void main(String[] args) throws InterruptedException {

        HibernateFactory hibernateFactory = new HibernateFactory();
        MovieDao movieDao = new MovieDao(hibernateFactory);
        AutorDao autorDao = new AutorDao(hibernateFactory);

        List<Movie> movies = movieDao.getAll();
        movies.forEach(System.out::println);

        List<Autor> autors = autorDao.getAll();
        autors.forEach(System.out::println);

        System.out.println("Get by TITLE : ");
        movieDao.getByTitle("Psy").forEach(System.out::println);

        System.out.println("Get by Age : ");
        autorDao.getByAge(67).forEach(System.out::println);



        hibernateFactory.getSessionFactory().close();
        Thread.sleep(2000);

    }
}
