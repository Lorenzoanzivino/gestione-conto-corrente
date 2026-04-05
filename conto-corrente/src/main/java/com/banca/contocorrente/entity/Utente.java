package com.banca.contocorrente.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtente;
    @Column(unique = true, nullable = false)
    private String mail;

    @Column(nullable = false)
    private String nome, cognome;

    @Column(nullable = true)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "FK_Indirizzo")
    private Indirizzo indirizzo;

    @ManyToMany(mappedBy = "proprietari")
    private List<ContoCorrente> conti;

    public Utente(){}
    public Utente(int idUtente, String nome, String cognome, String telefono, String mail, Indirizzo indirizzo, List<ContoCorrente> conti) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.conti = conti;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<ContoCorrente> getConti(){
        return conti;
    }

    public void setConti(List<ContoCorrente> conti){
        this.conti = conti;
    }
}
