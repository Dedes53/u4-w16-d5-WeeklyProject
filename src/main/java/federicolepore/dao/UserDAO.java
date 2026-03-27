package federicolepore.dao;

import federicolepore.entities.User;
import federicolepore.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    //   salvataggio
    public void save(User u) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(u);
            t.commit();
            System.out.println("L'utente " + u.getName() + " " + u.getSurname() + " è stato aggiunto con successo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //   riceca con id
    public User getByID(UUID id) {
        User u = em.find(User.class, id);
        if (u == null) throw new NotFoundException(id);
        return u;
    }

    //  rimozione con id
    public void remove(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            User u = this.getByID(id); //controllo che non sia nulla già nel metodo getByID
            em.remove(u);
            t.commit();
            System.out.println("L'utente con id: " + id + " è stato rimosso con successo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
