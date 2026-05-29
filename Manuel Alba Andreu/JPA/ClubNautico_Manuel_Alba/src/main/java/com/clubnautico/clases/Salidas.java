package com.clubnautico.clases;

import jakarta.persistence.*;
import java.time.*;
import java.util.*;
import lombok.*;

//Definimos la clase como una tabla y hacemos que cree constructor con todos los argumentos y otro sin argumentos
@Entity
@Table(name = "salidas")
@NoArgsConstructor
@AllArgsConstructor
public class Salidas {

    //Le decimos a hibernate que este es el id y que se genera el valor automatico y trabaje el motor de base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalida;

    private LocalDate fehcaSalida;

    private LocalTime horaSalida;

    private String destino;

    //Relacion de varios salidas que pueden pertenecer a un solo barco
    @ManyToOne
    @JoinColumn(name = "fk_barco")
    private Barco barco;

    //Relacion de varios salidas que peuden pertenecer a un solo patron
    @ManyToOne
    @JoinColumn(name = "fk_patron")
    private Patron patron;

    
    //Setters y getters
    
    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

}
