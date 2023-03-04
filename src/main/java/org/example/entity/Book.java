package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private double price;

    @Column(name="amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Author author;

    public Book(String title, double price, int amount, Author author) {
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.author = author;
    }
}
