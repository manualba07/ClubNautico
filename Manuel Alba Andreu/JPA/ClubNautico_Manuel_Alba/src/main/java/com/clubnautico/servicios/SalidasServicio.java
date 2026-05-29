package com.clubnautico.servicios;

import com.clubnautico.clases.*;
import com.clubnautico.excepciones.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clubnautico.repositorios.*;

@Service
public class SalidasServicio {

    // Inyección por constructor 
    private final SalidasRepositorio salidasRepositorio;

    public SalidasServicio(SalidasRepositorio salidasRepositorio) {
        this.salidasRepositorio = salidasRepositorio;
    }

    //Método para obtener la Lista de salidas
    public List<Salidas> obetenerListaSalidas() {
        return salidasRepositorio.findAll();
    }

    //Método para guardar salida controlando excepciones
    public Salidas guardarSalida(Salidas salida) {
        //Lanzar excepción si el destino es null o esta vacío
        if (salida.getDestino() == null || salida.getDestino().trim().isEmpty()) {
            throw new BadRequestException("El destino de la salida es obligatorio");
        }
        //Lanzar excepción si la fecha es null 
        if (salida.getFehcaSalida() == null) {
            throw new BadRequestException("La fecha de la salida es obligatoria");
        }
        //Lanzar excepción si la hora es null 
        if (salida.getHoraSalida() == null) {
            throw new BadRequestException("La hora de la salida es obligatoria");
        }
        return salidasRepositorio.save(salida);
    }

    //Método para obtener una salida por su id 
    public Salidas obtenerSalidaId(int id) {
        return salidasRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salida no encontrada con el ID: " + id));
    }

    //Método para borrar una salida
    public void eliminarSalida(int id) {
        salidasRepositorio.deleteById(id);

    }
}
