package com.clubnautico.dto;

import com.clubnautico.clases.Barco;
import java.util.List;

public class SocioDTO {

    private int idSocio;
    private String nombreSocio;
    private String apellidoSocio;
    private String email;
    private List<String> barcos;

    public SocioDTO() {
    }

    public SocioDTO(int idSocio, String nombreSocio, String apellidoSocio, String email, List<String> barcos) {
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
        this.apellidoSocio = apellidoSocio;
        this.email = email;
        this.barcos = barcos;
    }

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

    public List<String> getBarcos() {
        return barcos;
    }

    public void setBarcos(List<String> barcos) {
        this.barcos = barcos;
    }

}
