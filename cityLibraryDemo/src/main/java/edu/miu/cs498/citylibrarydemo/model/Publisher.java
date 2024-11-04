package edu.miu.cs498.citylibrarydemo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer publisherId;
    private  String publisherName;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Address primaryAddress;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "publisher")
    @JoinColumn(name = "publisher_id")
    private List<Book> books;




}
