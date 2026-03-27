package federicolepore.entities;

import federicolepore.enumerators.Genres;
import jakarta.persistence.*;

@Entity
@Table(name = "books")

@NamedQuery(
        name = "find_book_by_author",
        query = "select b from Book b where lower(b.author) like lower(:author)"
)
public class Book extends Reading {

    //  attributi
    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genres genre;


    //  costruttori
    public Book() {
    }

    public Book(long ISBNcode, String title, int publicationYear, int numberOfPages, String author, Genres genre) {
        super(ISBNcode, title, publicationYear, numberOfPages);
        this.author = author;
        this.genre = genre;
    }


    //  getters/setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Book, " +
                "author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }


}
