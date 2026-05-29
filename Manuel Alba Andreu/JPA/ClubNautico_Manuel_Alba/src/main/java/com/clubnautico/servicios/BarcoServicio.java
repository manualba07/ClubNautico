package com.clubnautico.servicios;

import com.clubnautico.clases.*;
import com.clubnautico.excepciones.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clubnautico.repositorios.BarcoRepositorio;

@Service
public class BarcoServicio {

    // Inyección por constructor    
    private final BarcoRepositorio barcoRepositorio;

    public BarcoServicio(BarcoRepositorio barcoRepositorio) {
        this.barcoRepositorio = barcoRepositorio;
    }

    //Método para obtener la Lista de barcos
    public List<Barco> obetenerListaBarcos() {
        return barcoRepositorio.findAll();
    }

    //Método para guardar barco controlando excepciones
    public Barco guardarBarco(Barco barco) {

        //Lanzar excepción si la matricula es null o esta vacía
        if (barco.getNumMatricula() == null || barco.getNumMatricula().trim().isEmpty()) {
            throw new BadRequestException("La matrícula del barco es obligatoria");
        }
        // Si el barco ya existe y estamos creando uno nuevo, lanzamos la excepción        
        if (barcoRepositorio.existsById(barco.getNumMatricula())) {
            throw new ResourceAlreadyExistsException("El barco con matrícula " + barco.getNumMatricula() + " ya está registrado");
        }
        return barcoRepositorio.save(barco);
    }

    // Método para actualizar un barco que se controlará en el service
    //Este no lleva excepciones porque es para actualizar no pasa nada que ya este registrado por ejemplo
    public Barco actualizarBarco(Barco barco) {
        return barcoRepositorio.save(barco);
    }

    //Método para obtener un barco por su matricula
    public Barco obtenerBarcoMatricula(String matricula) {
        return barcoRepositorio.findById(matricula)
                //Si no lo encuentra lanza la excepción
                .orElseThrow(() -> new ResourceNotFoundException("Barco no encontrado con la matrícula: " + matricula));
    }

    //Método para borrar un barco 
    public void eliminarBarco(String matricula) {
        barcoRepositorio.deleteById(matricula);

    }

}
