package com.clubnautico.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SalidasDTO {
    private int idSalida;
    private LocalDate fehcaSalida; 
    private LocalTime horaSalida;
    private String destino;
    private String numMatriculaBarco; // Solo la matrícula 
    private int idPatron;             // Solo el Id del patron

    public SalidasDTO() {}

    public SalidasDTO(int idSalida, LocalDate fehcaSalida, LocalTime horaSalida, String destino, String numMatriculaBarco, int idPatron) {
        this.idSalida = idSalida;
        this.fehcaSalida = fehcaSalida;
        this.horaSalida = horaSalida;
        this.destino = destino;
        this.numMatriculaBarco = numMatriculaBarco;
        this.idPatron = idPatron;
    }

    public LocalDate getFehcaSalida() {
        return fehcaSalida;
    }

    public void setFehcaSalida(LocalDate fehcaSalida) {
        this.fehcaSalida = fehcaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNumMatriculaBarco() {
        return numMatriculaBarco;
    }

    public void setNumMatriculaBarco(String numMatriculaBarco) {
        this.numMatriculaBarco = numMatriculaBarco;
    }

    public int getIdPatron() {
        return idPatron;
    }

    public void setIdPatron(int idPatron) {
        this.idPatron = idPatron;
    }


    
}