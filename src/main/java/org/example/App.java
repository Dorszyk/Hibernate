package org.example;
import org.example.dao.AutorDao;
import org.example.dao.EntityDao;
import org.example.dao.MovieDao;
import org.example.model.Autor;
import org.example.model.Movie;

public class App{

    public static void main(String[] args ) throws InterruptedException {

        HibernateFactory hibernateFactory = new HibernateFactory();
        MovieDao movieDao = new MovieDao(hibernateFactory);
        AutorDao autorDao = new AutorDao(hibernateFactory);

        Movie psy = new Movie();
        psy.setTitle("Psy");
        psy.setProductionYear(1992);
        psy.setTime(123456789);
        psy.setType("Komedia");

        movieDao.add(psy);
        movieDao.getById(1);

        System.out.println("MOVIE FROM DB : " + movieDao.getById(1));

        Autor autor1 = new Autor();
        autor1.setName("Jan");
        autor1.setSurname("Brzechwa");
        autor1.setAge(67);
        autor1.setNationality("Polnad");
        autorDao.add(autor1);

        EntityDao<Movie> genericMovieDao = new EntityDao<>(hibernateFactory,Movie.class);
        Movie psy2 = new Movie();
        psy2.setTitle("PSY II");
        psy2.setProductionYear(1998);
        psy2.setTime(987654321);
        psy2.setType("Dramat");

        genericMovieDao.save(psy2);

        EntityDao<Autor> genericAutorDao = new EntityDao<>(hibernateFactory, Autor.class);
        Autor autor2 = new Autor();
        autor2.setName("Adam");
        autor2.setSurname("Mickiewicz");
        autor2.setAge(87);
        autor2.setNationality("Poland");

        genericAutorDao.save(autor2);

        hibernateFactory.getSessionFactory().close();
        Thread.sleep(2000);
    }
}
