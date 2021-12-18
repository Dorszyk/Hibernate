package org.example;

import org.example.dao.EntityDao;
import org.example.dao.ReviewerDao;
import org.example.model.Autor;
import org.example.model.Movie;
import org.example.model.Reviewer;

public class MainRelationsExample {

    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        ReviewerDao reviewerDao = new ReviewerDao(hibernateFactory, Reviewer.class);
        EntityDao<Movie> movieDao = new EntityDao<>(hibernateFactory, Movie.class);
        EntityDao<Autor> autorDao = new EntityDao<>(hibernateFactory, Autor.class);

        savingOneToOne(reviewerDao, movieDao);
        savingOneToMany(autorDao,movieDao);


        hibernateFactory.getSessionFactory().close();


    }

    private  static void savingOneToMany(EntityDao<Autor> autorDao, EntityDao<Movie> movieDao) {

        Autor autor = new Autor();
        autor.setName("Piotr");
        autor.setSurname("Dorszyk");

        Movie sampleMovieOne = new Movie();
        sampleMovieOne.setTitle("Titanic");
        sampleMovieOne.setProductionYear(2000);
        sampleMovieOne.setType("COMEDY");

        sampleMovieOne.setAutor(autor);

        Movie sampleMovieDwo = new Movie();
        sampleMovieDwo.setTitle("Psi Patol");
        sampleMovieDwo.setProductionYear(2005);
        sampleMovieDwo.setType("Thriller");

        sampleMovieDwo.setAutor(autor);

        autorDao.save(autor);
        movieDao.save(sampleMovieOne);
        movieDao.save(sampleMovieDwo);


    }

    private static void savingOneToOne(ReviewerDao reviewerDao, EntityDao<Movie> movieDao) {
        Movie sampleMovie = new Movie();
        sampleMovie.setTitle("Sample movie");
        sampleMovie.setProductionYear(1997);
        sampleMovie.setType("DRAMA");

        Reviewer reviewer = new Reviewer();
        reviewer.setName("Adam");
        reviewer.setSurname("Adamski");
        reviewer.setMovie(sampleMovie);

        movieDao.save(sampleMovie);
        reviewerDao.save(reviewer);

        Reviewer byId = reviewerDao.getById(reviewer.getId());
        System.out.println(byId);
    }
}
