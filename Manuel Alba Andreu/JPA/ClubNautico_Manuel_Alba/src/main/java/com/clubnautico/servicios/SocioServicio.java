package com.clubnautico.servicios;

import com.clubnautico.clases.*;
import com.clubnautico.excepciones.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clubnautico.repositorios.SocioRepositorio;

@Service
public class SocioServicio {

    // Inyección por constructor 
    private final SocioRepositorio socioRepositorio;

    public SocioServicio(SocioRepositorio socioRepositorio) {
        this.socioRepositorio = socioRepositorio;
    }

    //Método para obtener la Lista de socios
    public List<Socio> obetenerListaSocios() {
        return socioRepositorio.findAll();
    }

    //Método para guardar un socio controlando excepciones
    public Socio guardarSocio(Socio socio) {
        //Lanzar excepción si el nombre es null o esta vacío
        if (socio.getNombreSocio() == null || socio.getNombreSocio().trim().isEmpty()) {
            throw new BadRequestException("El nombre del socio es obligatorio");
        }
        //Lanzar excepción si el email es null o esta vacío
        if (socio.getEmail() == null || socio.getEmail().trim().isEmpty()) {
            throw new BadRequestException("El email del socio es obligatorio");
        }
        return socioRepositorio.save(socio);
    }

    //Método para obtener una salida por su id
    public Socio obtenerSocioId(int id) {
        return socioRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Socio no encontrado con el id: " + id));
    }

    //Método para borrar una salida
    public void eliminarSocio(int id) {
        socioRepositorio.deleteById(id);
    }

}
