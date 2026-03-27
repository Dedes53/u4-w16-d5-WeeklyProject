package federicolepore.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
@NamedQuery(
        name = "find_readings_loaned_by_card",
        query = "select l.reading from Loan l where l.user.cardNumber = :card and l.retDate is null"
)
@NamedQuery(
        name = "find_unreturned_loans",
        query = "select l from Loan l where l.retDate is null and l.expDate < :today"
)
public class Loan {

    //  attributi
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "reagind_id", nullable = false)
    private Reading reading;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expDate;

    @Column(name = "return_date")
    private LocalDate retDate;

    @Column(name = "expired")
    private boolean isExpired;

    //  costruttori
    protected Loan() {
    }

    public Loan(UUID id, User user, Reading reading, LocalDate startDate, LocalDate retDate) {
        this.id = id;
        this.user = user;
        this.reading = reading;
        this.startDate = startDate;
        this.expDate = startDate.plusDays(30);
        this.retDate = retDate;
        this.isExpired = expDate.isBefore(LocalDate.now()) ? false : true;
    }


    //  getters/setters
    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public LocalDate getRetDate() {
        return retDate;
    }

    public void setRetDate(LocalDate retDate) {
        this.retDate = retDate;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", reading=" + reading +
                ", startDate=" + startDate +
                ", expDate=" + expDate +
                ", retDate=" + retDate +
                '}';
    }
}
