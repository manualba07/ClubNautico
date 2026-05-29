package com.clubnautico.clases;

import jakarta.persistence.*;
import java.time.*;
import java.util.*;
import lombok.*;

//Definimos la clase como una tabla y hacemos que cree constructor con todos los argumentos y otro sin argumentos
@Entity
@Table(name = "patrones")
@NoArgsConstructor
@AllArgsConstructor
public class Patron {

    //Le decimos a hibernate que este es el id y que se genera el valor automatico y trabaje el motor de base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatron;

    private String nombrePatron;
    private String apellidoPatron;
    private String licencia;

    //Un patron puede tener registrado muchas salidas,
    //con efecto domino gracias al cascade aplicando los cambios a las salidas asociadas
    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<Salidas> salidas;

    
    //Setters y getters
    
    public int getIdPatron() {
        return idPatron;
    }

    public void setIdPatron(int idPatron) {
        this.idPatron = idPatron;
    }

    public String getNombrePatron() {
        return nombrePatron;
    }

    public void setNombrePatron(String nombrePatron) {
        this.nombrePatron = nombrePatron;
    }

    public String getApellidoPatron() {
        return apellidoPatron;
    }

    public void setApellidoPatron(String apellidoPatron) {
        this.apellidoPatron = apellidoPatron;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public List<Salidas> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Salidas> salidas) {
        this.salidas = salidas;
    }

}
