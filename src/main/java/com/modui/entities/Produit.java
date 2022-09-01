package com.modui.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Produit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String designation;
    private double prix;
    private int quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit() {
    }

    public Produit(Long id, String designation, double prix, int quantite) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }
}
