package com.tomato.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Restaurent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long RestaurentId;

    @Column
    @NotNull
    private String RestaurentName;

    @NotNull
    @Column
    private String ManagerId;

    @Column
    @NotNull
    private String Address;

    @Transient
    private String Description;

}
