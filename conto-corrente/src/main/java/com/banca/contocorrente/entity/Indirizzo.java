package com.banca.contocorrente.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "indirizzi")
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIndirizzo;

    @Column(nullable = false)
    private String via, cap, citta, provincia;

    public Indirizzo(){}

    public Indirizzo(int idIndirizzo, String via, String cap, String citta, String provincia){
        this.idIndirizzo = idIndirizzo;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
    }

    public int getIdIndirizzo() {
        return idIndirizzo;
    }

    public void setIdIndirizzo(int idIndirizzo) {
        this.idIndirizzo = idIndirizzo;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
