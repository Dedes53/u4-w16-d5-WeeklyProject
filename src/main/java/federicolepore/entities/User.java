package federicolepore.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    //  attributi
    @Id
    @GeneratedValue
    private UUID user_id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "card_number", nullable = false, unique = true)
    private Long cardNumber;


    //  costruttori
    public User() {
    }

    public User(String name, String surname, LocalDate dateOfBirth, Long cardNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
    }


    //  getters/setters
    public UUID getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
