package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

//Задание: посмотреть все требования к Entity в JPA.
@Entity
@Data
@NoArgsConstructor
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }
}
