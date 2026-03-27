package federicolepore;

import com.github.javafaker.Faker;
import federicolepore.dao.LoanDAO;
import federicolepore.dao.ReadingDAO;
import federicolepore.dao.UserDAO;
import federicolepore.entities.*;
import federicolepore.enumerators.Frequency;
import federicolepore.enumerators.Genres;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w16d5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();
        Random random = new Random();

        //  DAO
        ReadingDAO rd = new ReadingDAO(em);
        UserDAO ud = new UserDAO(em);
        LoanDAO ld = new LoanDAO(em);

        //  istanze
        Reading b1 = new Book(1001, "Lord Of The Rings", 1954, 1300, "J.R.R. Tolkien", Genres.FANTASY);
        Reading b2 = new Book(1002, "Guida Galattica per Autostoppisti", 1979, 200, "Douglas Adams", Genres.SCIENCE_FICTION);
        Reading b3 = new Book(1003, "IT", 1986, 1200, "Stephen King", Genres.HORROR);
        Reading b4 = new Book(1004, "Nuovo ibro scritto da me", 2007, 2, "Federico Lepore", Genres.ADVENTURE);

        Reading m1 = new Magazine(1011, "Focus", 1992, 80, Frequency.MENSILE);
        Reading m2 = new Magazine(1012, "Donna Moderna", 2007, 60, Frequency.SEMESTRALE);
        Reading m3 = new Magazine(1013, "Topolino", 2003, 20, Frequency.SETTIMANALE);

        User u1 = new User("Federico", "Lepore", LocalDate.of(1997, 9, 25), 20001L);
        User u2 = new User("Mario", "Rossi", LocalDate.of(1977, 9, 12), 20002L);
        User u3 = new User("Simone", "Rossi", LocalDate.of(1994, 6, 2), 20003L);

        Loan l1 = new Loan(u1, b2, LocalDate.of(2026, 3, 5), null);
        Loan l2 = new Loan(u2, m1, LocalDate.of(2026, 2, 1), null);
        Loan l3 = new Loan(u2, m3, LocalDate.of(2026, 1, 4), LocalDate.of(2026, 1, 27));

//        rd.save(b1);
//        rd.save(b2);
//        rd.save(b3);
//        rd.save(b4);
//        rd.save(m1);
//        rd.save(m2);
//        rd.save(m3);
//        ud.save(u1);
//        ud.save(u2);
//        ud.save(u3);
//        ld.save(l1);
//        ld.save(l2);
//        ld.save(l3);

        System.out.println("aggiunta di un elemento nel catalogo");
        rd.save(b1);
        System.out.println();

        System.out.println("rimozione con codice ISBN");
        rd.removeByISBN(1001);
        System.out.println();

        System.out.println("Ricerca per ISBN");
        System.out.println(rd.findByISBN(1002));
        System.out.println();

        System.out.println("ricerca per anno pubblicazione");
        System.out.println(rd.findReadingByYear(2007));
        System.out.println();

        System.out.println("ricerca per autore");
        System.out.println(rd.findBookByAuthor("do"));
        System.out.println();

        System.out.println("ricerca per titolo o parte del titolo");
        System.out.println(rd.findReadingByTitle("do"));
        System.out.println();

        System.out.println("ricerca prestiti numero tessera");
        System.out.println(ld.findLoansByCarNumber(20001L));
        System.out.println();

        System.out.println("ricerca prestiti scaduti non restituiti");
        System.out.println(ld.findUnretunedLoans(LocalDate.now()));
        System.out.println();
    }
}
