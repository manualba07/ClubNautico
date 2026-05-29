package com.clubnautico.dto;

public class BarcoDTO {
    private String numMatricula;
    private String nombreBarco;
    private Integer numAmarre;
    private double cuota;
    private int idSocio; // Guardamos solo el número ID del socio

    public BarcoDTO() {}

    public BarcoDTO(String numMatricula, String nombreBarco, Integer numAmarre, double cuota, int idSocio) {
        this.numMatricula = numMatricula;
        this.nombreBarco = nombreBarco;
        this.numAmarre = numAmarre;
        this.cuota = cuota;
        this.idSocio = idSocio;
    }

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

    public Integer getNumAmarre() {
        return numAmarre;
    }

    public void setNumAmarre(Integer numAmarre) {
        this.numAmarre = numAmarre;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

   
}