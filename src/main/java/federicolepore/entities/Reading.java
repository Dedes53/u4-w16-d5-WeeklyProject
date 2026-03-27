package federicolepore.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "readings")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(
        name = "find_reading_by_year",
        query = "select r from Reading r where r.publicationYear = :year"
)
@NamedQuery(
        name = "find_reading_by_ISBN",
        query = "select r from Reading r where r.isbnCode = :isbn"
)
@NamedQuery(
        name = "find_reading_by_title",
        query = "select r from Reading r where lower(r.title) like lower(:title)"
)
public abstract class Reading {

    //  attributi
    @Id
    @GeneratedValue
    @Column(name = "reading_id")
    private UUID id;

    @Column(name = "isbn_code", unique = true, nullable = false)
    private long isbnCode;

    @Column(nullable = false)
    private String title;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(name = "number_of_pages", nullable = false)
    private int numberOfPages;


    //  costruttori
    protected Reading() {
    }

    public Reading(long ISBNcode, String title, int publicationYear, int numberOfPages) {
        this.isbnCode = ISBNcode;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    //  getters/setters
    public UUID getId() {
        return id;
    }

    public long getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(long isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int pubblicationYear) {
        this.publicationYear = pubblicationYear;
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
                ", ISBNcode='" + isbnCode + '\'' +
                ", title='" + title + '\'' +
                ", pubblicationYear=" + publicationYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }


}
