package com.backspringboot.repogitory;


import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String psrPhnNbr;

    @Column(length = 50, nullable = true)
    private String memo;



}
