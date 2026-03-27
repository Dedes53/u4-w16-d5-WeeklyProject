package federicolepore.entities;

import federicolepore.enumerators.Frequency;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "magazines")
public class Magazine extends Reading {

    //  attributi
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Frequency frequency;


    //  costruttori
    public Magazine() {
    }

    public Magazine(UUID id, long ISBNcode, String title, int publicationYear, int numberOfPages, Frequency frequency) {
        super(id, ISBNcode, title, publicationYear, numberOfPages);
        this.frequency = frequency;
    }


    // getters/setters
    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


    @Override
    public String toString() {
        return "Magazine{" +
                "frequency=" + frequency +
                '}';
    }


}
