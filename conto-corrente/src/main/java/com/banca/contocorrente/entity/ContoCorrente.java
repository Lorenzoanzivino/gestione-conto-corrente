package com.banca.contocorrente.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "conti_correnti")
public class ContoCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroConto;

    @Column(nullable = false)
    private double saldo;

    // Configurazione della tabella intermedia per i cointestatari
    @ManyToMany
    @JoinTable(
            name = "conti_utenti", // Nome della tabella nel DB
            joinColumns = @JoinColumn(name = "FK_Conto"), // Colonna per l'ID di ContoCorrente
            inverseJoinColumns = @JoinColumn(name = "FK_Utente") // Colonna per l'ID di Utente
    )
    private List<Utente> proprietari;

    // Aggiungiamo anche il segnaposto per i movimenti che faremo nello Step 4
    @OneToMany(mappedBy = "conto")
    private List<Movimento> movimenti;

    public ContoCorrente(){}

    public ContoCorrente(int numeroConto, double saldo, List<Utente> proprietari, List<Movimento> movimenti) {

        this.numeroConto = numeroConto;
        this.saldo = saldo;
        this.proprietari = proprietari;
        this.movimenti = movimenti;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(int numeroConto) {
        this.numeroConto = numeroConto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Utente> getProprietari() {
        return proprietari;
    }

    public void setProprietari(List<Utente> proprietari) {
        this.proprietari = proprietari;
    }

    public List<Movimento> getMovimenti() {
        return movimenti;
    }

    public void setMovimenti(List<Movimento> movimenti) {
        this.movimenti = movimenti;
    }
}
