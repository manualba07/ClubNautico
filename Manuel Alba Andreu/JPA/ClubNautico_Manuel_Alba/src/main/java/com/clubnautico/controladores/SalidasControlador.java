package com.clubnautico.controladores;

import com.clubnautico.clases.*;
import com.clubnautico.dto.SalidasDTO;
import com.clubnautico.mappers.ClubNauticoMapper;
import com.clubnautico.servicios.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//URL base para todos los endpoints de este controlador
@RequestMapping("/api/v1/salidas")
public class SalidasControlador {

    private final SalidasServicio salidasServicio;
    private final BarcoServicio barcoServicio;
    private final PatronServicio patronServicio;
    private final ClubNauticoMapper mapper;

    // Inyección de dependencias por constructor 
    public SalidasControlador(SalidasServicio salidasServicio, BarcoServicio barcoServicio, PatronServicio patronServicio, ClubNauticoMapper mapper) {
        this.salidasServicio = salidasServicio;
        this.barcoServicio = barcoServicio;
        this.patronServicio = patronServicio;
        this.mapper = mapper;
    }

    // Endpoint GET para listar todos las salidas
    @GetMapping
    public ResponseEntity<List<SalidasDTO>> listaSalidas() {
        List<Salidas> listaEntidades = salidasServicio.obetenerListaSalidas();
        List<SalidasDTO> listaDtos = new ArrayList<>();
        for (Salidas salidas : listaEntidades) {
            SalidasDTO dto = mapper.toSalidasDTO(salidas);
            listaDtos.add(dto);
        }
        return ResponseEntity.ok(listaDtos);
    }

    // Endpoint GET para obtener una única salida mediante su id pasada por la URL
    @GetMapping("/{id}")
    public ResponseEntity<SalidasDTO> obtenerSalidaId(@PathVariable int id) {
        Salidas salida = salidasServicio.obtenerSalidaId(id);
        return ResponseEntity.ok(mapper.toSalidasDTO(salida));
    }

    // Endpoint POST para registrar una nueva salida
    @PostMapping
    public ResponseEntity<SalidasDTO> crearSalida(@RequestBody SalidasDTO salidasDTO) {
        Barco barco = barcoServicio.obtenerBarcoMatricula(salidasDTO.getNumMatriculaBarco());
        Patron patron = patronServicio.obtenerPatronId(salidasDTO.getIdPatron());

        Salidas salida = mapper.toSalidasEntity(salidasDTO, barco, patron);
        Salidas salidaGuardada = salidasServicio.guardarSalida(salida);
        return ResponseEntity.ok(mapper.toSalidasDTO(salidaGuardada));
    }

    // Endpoint PUT para actualizar una salida buscando su id por la URL
    @PutMapping("/{id}")
    public ResponseEntity<SalidasDTO> actualizarSalida(@PathVariable int id, @RequestBody SalidasDTO salidasDTO) {
        Salidas salidaExistente = salidasServicio.obtenerSalidaId(id);
        Barco barco = barcoServicio.obtenerBarcoMatricula(salidasDTO.getNumMatriculaBarco());
        Patron patron = patronServicio.obtenerPatronId(salidasDTO.getIdPatron());

        salidaExistente.setFehcaSalida(salidasDTO.getFehcaSalida());
        salidaExistente.setHoraSalida(salidaExistente.getHoraSalida());
        salidaExistente.setDestino(salidasDTO.getDestino());
        salidaExistente.setBarco(barco);
        salidaExistente.setPatron(patron);

        Salidas salidaActualizada = salidasServicio.guardarSalida(salidaExistente);
        return ResponseEntity.ok(mapper.toSalidasDTO(salidaActualizada));
    }

    // Endpoint DELETE para eliminar una salida por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSalida(@PathVariable int id) {
        salidasServicio.eliminarSalida(id);
        return ResponseEntity.ok().build();
    }
}
