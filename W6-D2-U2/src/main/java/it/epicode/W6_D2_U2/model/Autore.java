package it.epicode.W6_D2_U2.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
}
