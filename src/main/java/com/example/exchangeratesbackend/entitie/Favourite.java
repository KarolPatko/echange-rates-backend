package com.example.exchangeratesbackend.entitie;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String userId;
    private String currencyId;
}
