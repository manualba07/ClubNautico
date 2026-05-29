package com.clubnautico.excepciones;

import java.time.LocalDateTime;

public class ErrorDetalles {
    private LocalDateTime marcaTiempo;
    private String mensaje;
    private String detalles;

    public ErrorDetalles(LocalDateTime marcaTiempo, String mensaje, String detalles) {
        this.marcaTiempo = marcaTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    // Getters y Setters
    public LocalDateTime getMarcaTiempo() { return marcaTiempo; }
    public void setMarcaTiempo(LocalDateTime marcaTiempo) { this.marcaTiempo = marcaTiempo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getDetalles() { return detalles; }
    public void setDetalles(String detalles) { this.detalles = detalles; }
}