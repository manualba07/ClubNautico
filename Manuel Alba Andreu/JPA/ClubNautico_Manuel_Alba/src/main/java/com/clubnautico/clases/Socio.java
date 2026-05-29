package com.clubnautico.clases;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

//Definimos la clase como una tabla y hacemos que cree constructor con todos los argumentos y otro sin argumentos
@Entity
@Table(name = "socios")
@NoArgsConstructor
@AllArgsConstructor
public class Socio {

    //Le decimos a hibernate que este es el id y que se genera el valor automatico y trabaje el motor de base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSocio;

    private String nombreSocio;
    private String apellidoSocio;
    private String email;

    //Relacion de socio con propiedad de barcos, un objeto de este clase pertenece a muchos de barco
    //Además del efecto cascada, cualquier modificacion en este socio hace el efecto domino en sus barcos
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Barco> barcos;

    
    //Setters y getters
    
    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getApellidoSocio() {
        return apellidoSocio;
    }

    public void setApellidoSocio(String apellidoSocio) {
        this.apellidoSocio = apellidoSocio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(List<Barco> barcos) {
        this.barcos = barcos;
    }

}
