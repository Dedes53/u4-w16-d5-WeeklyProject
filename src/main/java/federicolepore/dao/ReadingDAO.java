package federicolepore.dao;

import federicolepore.entities.Book;
import federicolepore.entities.Reading;
import federicolepore.exeptions.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.UUID;

public class ReadingDAO {
    private final EntityManager em;

    public ReadingDAO(EntityManager em) {
        this.em = em;
    }


    //  salvataggio
    public void save(Reading reading) {
        try {
            EntityTransaction t = this.em.getTransaction();
            t.begin();
            em.persist(reading);
            t.commit();
            System.out.println("La lettura " + reading.getTitle() + " è stata salvata con successo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //   ricerca con id
    public Reading getByID(UUID id) {
        Reading r = em.find(Reading.class, id);
        if (r == null) throw new NotFoundException(id);
        return r;
    }

    //  rimozione con id
    public void remove(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Reading r = this.getByID(id); //controllo che non sia nulla già nel metodo getByID
            em.remove(r);
            t.commit();
            System.out.println("La lettura con id: " + id + " è stata rimosso con successo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //  ricerca
    public Reading findByISBN(long isbn) {
        Reading res = em.createNamedQuery("find_reading_by_ISBN", Reading.class)
                .setParameter("isbn", isbn).getSingleResult();
        if (res == null) throw new NotFoundExceptionByISBN(isbn);
        return res;
    }

    public List<Reading> findReadingByYear(int y) {
        List<Reading> res = em.createNamedQuery("find_reading_by_year", Reading.class)
                .setParameter("year", y).getResultList();
        if (res.isEmpty()) throw new NotFoundExceptionByYear(y);
        return res;
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> res = em.createNamedQuery("find_book_by_author", Book.class)
                .setParameter("author", "%" + author + "%").getResultList();
        if (res.isEmpty()) throw new NotFoundExceptionByAuthor(author);
        return res;
    }

    public List<Reading> findReadingByTitle(String t) {
        List<Reading> res = em.createNamedQuery("find_reading_by_title", Reading.class)
                .setParameter("title", "%" + t + "%").getResultList();
        if (res.isEmpty()) throw new NofFoundExceptionByTitle(t);
        return res;
    }

    //  rimozione
    public void removeByISBN(long isbn) {
        try {
            EntityTransaction t = this.em.getTransaction();
            t.begin();
            Reading r = this.findByISBN(isbn);

            if (r != null) {
                em.remove(r);
                t.commit();
                System.out.println("La lettura " + r.getTitle() + " è stata rimossa");
            } else System.out.println("Lettura non trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
