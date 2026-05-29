package com.clubnautico.servicios;

import com.clubnautico.clases.*;
import com.clubnautico.excepciones.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clubnautico.repositorios.*;

@Service
public class PatronServicio {

    // Inyección por constructor 
    private final PatronRepositorio patronRepositorio;

    public PatronServicio(PatronRepositorio patronRepositorio) {
        this.patronRepositorio = patronRepositorio;
    }

    //Método para obtener la Lista de patrones
    public List<Patron> obetenerListaPatron() {
        return patronRepositorio.findAll();
    }

    //Método para guardar patron controlando excepciones
    public Patron guardarPatron(Patron patron) {
        //Lanzar excepción si el nombre es null o esta vacío
        if (patron.getNombrePatron() == null || patron.getNombrePatron().trim().isEmpty()) {
            throw new BadRequestException("El nombre del patrón es obligatorio");
        }
        //Lanzar excepción si la licencia es null o esta vacía
        if (patron.getLicencia() == null || patron.getLicencia().trim().isEmpty()) {
            throw new BadRequestException("La licencia del patrón es obligatoria");
        }
        return patronRepositorio.save(patron);
    }

    //Método para obtener un patron por su id 
    public Patron obtenerPatronId(int id) {
        return patronRepositorio.findById(id)
                //Si no lo encuentra lanza la excepción
                .orElseThrow(() -> new ResourceNotFoundException("Patrón no encontrado con el id: " + id));
    }

    //Método para borrar un barco
    public void eliminarPatron(int id) {
        patronRepositorio.deleteById(id);

    }
}
