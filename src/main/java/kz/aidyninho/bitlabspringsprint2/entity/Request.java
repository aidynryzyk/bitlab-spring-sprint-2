package kz.aidyninho.bitlabspringsprint2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "requests")
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String userName;
    @ManyToOne
    private Course course;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    private String phoneNumber;
    @Column
    private Boolean handled;
}
