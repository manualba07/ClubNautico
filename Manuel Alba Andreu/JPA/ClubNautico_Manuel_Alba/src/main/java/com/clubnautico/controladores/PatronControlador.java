package com.clubnautico.controladores;

import com.clubnautico.clases.*;
import com.clubnautico.dto.PatronDTO;
import com.clubnautico.mappers.ClubNauticoMapper;
import com.clubnautico.servicios.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//URL base para todos los endpoints de este controlador
@RequestMapping("/api/v1/patrones")
public class PatronControlador {

    private final PatronServicio patronServicio;
    private final ClubNauticoMapper mapper;

    // Inyección de dependencias por constructor 
    public PatronControlador(PatronServicio patronServicio, ClubNauticoMapper mapper) {
        this.patronServicio = patronServicio;
        this.mapper = mapper;
    }

    // Endpoint GET para listar todos los patrones 
    @GetMapping
    public ResponseEntity<List<PatronDTO>> listaPatrones() {
        List<Patron> listaEntidades = patronServicio.obetenerListaPatron();
        List<PatronDTO> listaDtos = new ArrayList<>();
        for (Patron patron : listaEntidades) {
            PatronDTO dto = mapper.toPatronDTO(patron);
            listaDtos.add(dto);
        }
        return ResponseEntity.ok(listaDtos);
    }

    // Endpoint GET para obtener un único patron mediante su id pasada por la URL
    @GetMapping("/{id}")
    public ResponseEntity<PatronDTO> obtenerPatronId(@PathVariable int id) {
        Patron patron = patronServicio.obtenerPatronId(id);
        return ResponseEntity.ok(mapper.toPatronDTO(patron));
    }

    // Endpoint POST para registrar un nuevo patron
    @PostMapping
    public ResponseEntity<PatronDTO> crearPatron(@RequestBody PatronDTO patronDTO) {
        Patron patron = mapper.toPatronEntity(patronDTO);
        Patron patronGuardado = patronServicio.guardarPatron(patron);
        return ResponseEntity.ok(mapper.toPatronDTO(patronGuardado));
    }

    // Endpoint PUT para actualizar un patron buscando su id por la URL
    @PutMapping("/{id}")
    public ResponseEntity<PatronDTO> actualizarPatron(@PathVariable int id, @RequestBody PatronDTO patronDTO) {
        Patron patronExistente = patronServicio.obtenerPatronId(id);

        patronExistente.setNombrePatron(patronDTO.getNombrePatron());
        patronExistente.setApellidoPatron(patronDTO.getApellidoPatron());
        patronExistente.setLicencia(patronDTO.getLicencia());

        Patron patronActualizado = patronServicio.guardarPatron(patronExistente);
        return ResponseEntity.ok(mapper.toPatronDTO(patronActualizado));
    }

    // Endpoint DELETE para eliminar un patron por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPatron(@PathVariable int id) {
        patronServicio.eliminarPatron(id);
        return ResponseEntity.ok().build();
    }
}
