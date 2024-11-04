package edu.miu.cs498.citylibrarydemo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="book_id")
    private Integer bokkId;

    @ManyToOne(fetch = FetchType.EAGER)
    private  Publisher publisher; //Book>------|| Publisher


}
