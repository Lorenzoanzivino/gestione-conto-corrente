package com.banca.contocorrente.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movimenti")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovimento;

    public enum TipoMovimento { VERSAMENTO, PRELIEVO }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimento tipo; // Campo aggiunto per mappare l'operazione

    @Column(nullable = false)
    private double importo;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "FK_Conto")
    private ContoCorrente conto; // Corretto: riferimento singolo, non lista

    @ManyToOne
    @JoinColumn(name = "FK_Operatore")
    private Utente utente;

    public Movimento(){}

    public Movimento(int idMovimento, TipoMovimento tipo, double importo, LocalDate data, ContoCorrente conto, Utente utente) {
        this.idMovimento = idMovimento;
        this.tipo = tipo;
        this.importo = importo;
        this.data = data;
        this.conto = conto;
        this.utente = utente;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimento tipo) {
        this.tipo = tipo;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ContoCorrente getConto() {
        return conto;
    }

    public void setConto(ContoCorrente conto) {
        this.conto = conto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}