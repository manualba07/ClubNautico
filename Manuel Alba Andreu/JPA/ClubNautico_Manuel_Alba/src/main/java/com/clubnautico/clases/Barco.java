package com.clubnautico.clases;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

//Definimos la clase como una tabla y hacemos que cree constructor con todos los argumentos y otro sin argumentos
@Entity
@Table(name = "barcos")
@NoArgsConstructor
@AllArgsConstructor
public class Barco {

    //Le decimos a hibernate que este es el id 
    @Id
    private String numMatricula;

    private String nombreBarco;
    private int numAmarre;
    private double cuota;

    //Relacion de varios barcos que pueden pertenecer a un solo socio
    @ManyToOne
    @JoinColumn(name = "fk_socio")
    private Socio socio;

    //Un barco puede tener registrado muchas salidas,
    //con efecto domino gracias al cascade aplicando los cambios a las salidas asociadas
    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL)
    private List<Salidas> salidas;

    
    //Setters y getters
    
    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    public int getNumAmarre() {
        return numAmarre;
    }

    public void setNumAmarre(int numAmarre) {
        this.numAmarre = numAmarre;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public List<Salidas> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Salidas> salidas) {
        this.salidas = salidas;
    }

}
