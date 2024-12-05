package org.proj.styleboard.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "collections") // Collection
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne (optional = false)
    @JoinColumn(name = "user_id", nullable="false")
    private UserInfo user;


    @OneToMany(mappedBy = "collections", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pin> pins;

    // constructor

    public Collection() {}

    public Collection(String name, UserInfo user) {
        this.name = name;
        this.user = user;
    }

    // getter and setters
    public String getName() {
        return name;
    }
    public String setName(String name){
        this.name = name;
    }
}