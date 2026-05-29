package com.clubnautico.dto;

public class PatronDTO {
    private int idPatron;
    private String nombrePatron;
    private String apellidoPatron;
    private String licencia;

    public PatronDTO() {}

    public PatronDTO(int idPatron, String nombrePatron, String apellidoPatron, String licencia) {
        this.idPatron = idPatron;
        this.nombrePatron = nombrePatron;
        this.apellidoPatron = apellidoPatron;
        this.licencia = licencia;
    }

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

   
}