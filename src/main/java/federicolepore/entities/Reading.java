package federicolepore.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Readings")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="type")
public abstract class Reading {

    //  attributi
    @Id
    @GeneratedValue
    @Column(name = "reading_id")
    private UUID id;

    @Column(name = "isbn_code", unique = true, nullable = false)
    private String ISBNcode;

    @Column(nullable = false)
    private String title;

    @Column(name = "publication_year", nullable = false)
    private int pubblicationYear;

    @Column(name = "number_of_pages", nullable = false)
    private int numberOfPages;


    //  getters/setters
    public UUID getId() {
        return id;
    }

    public String getISBNcode() {
        return ISBNcode;
    }

    public void setISBNcode(String ISBNcode) {
        this.ISBNcode = ISBNcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPubblicationYear() {
        return pubblicationYear;
    }

    public void setPubblicationYear(int pubblicationYear) {
        this.pubblicationYear = pubblicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "id=" + id +
                ", ISBNcode='" + ISBNcode + '\'' +
                ", title='" + title + '\'' +
                ", pubblicationYear=" + pubblicationYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    
}
