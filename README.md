# Gestione Conto Corrente - Banca API

Progetto back-end sviluppato con Spring Boot e Spring Data JPA per la gestione di conti correnti bancari. Il sistema è attualmente progettato con un'architettura monolitica, organizzata per layer (Controller, Service, Repository, DTO), con la prospettiva di un futuro refactoring a microservizi.

## Dominio Applicativo
L'applicativo gestisce le seguenti entità principali:
- **Utente**: Proprietario o cointestatario di uno o più conti correnti, associato a un indirizzo di residenza.
- **Indirizzo**: Residenza associata a un utente.
- **Conto Corrente**: Conto con un identificativo univoco e un saldo. Richiede almeno un utente proprietario.
- **Movimento**: Operazione bancaria (versamento o prelievo) effettuata su un conto da un operatore specifico.

## Stack Tecnologico
- Java
- Spring Boot (Web, Data JPA, Validation)
- Database relazionale
- Architettura RESTful

## Regole di Business Principali
- Un conto può essere chiuso solo se il saldo è esattamente 0.
- Il saldo di un conto non può scendere sotto i -5000€.
- Un prelievo può essere effettuato solo dai proprietari del conto.
- Un cointestatario può essere rimosso solo se non ha mai effettuato movimenti sul conto.