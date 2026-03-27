package federicolepore;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Random;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w16d5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();
        Random random = new Random();


        System.out.println("Hello World!");
    }
}
