package federicolepore.dao;

import federicolepore.entities.Loan;
import federicolepore.entities.Reading;
import federicolepore.exeptions.NotFoundException;
import federicolepore.exeptions.NotFoundExceptionByCardNumber;
import federicolepore.exeptions.NotFoundExceptionByExpDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class LoanDAO {

    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }


    //  salvataggio
    public void save(Loan l) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(l);
            t.commit();
            System.out.println("Il prestito della lettura " + l.getReading().getTitle() + " all'utente " + l.getUser().getName() + " " + l.getUser().getSurname() + " è stato salvato nel sistema");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ricerca con id
    public Loan getByID(UUID id) {
        Loan l = em.find(Loan.class, id);
        if (l == null) throw new NotFoundException(id);
        return l;
    }

    //  rimozione con id
    public void remove(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Loan l = this.getByID(id); //controllo che non sia nulla già nel metodo getByID
            em.remove(l);
            t.commit();
            System.out.println("Il prestito con id: " + id + " è stato rimosso con successo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //  ricerche
    public List<Reading> findLoansByCarNumber(long cn) {
        List<Reading> res = em.createNamedQuery("find_readings_loaned_by_card", Reading.class)
                .setParameter("card", cn).getResultList();
        if (res.isEmpty()) throw new NotFoundExceptionByCardNumber(cn);
        return res;
    }

    public List<Loan> findUnretunedLoans(LocalDate day) {
        List<Loan> res = em.createNamedQuery("find_unreturned_loans", Loan.class)
                .setParameter("today", day).getResultList();
        if (res.isEmpty()) throw new NotFoundExceptionByExpDate(day);
        return res;
    }
}
