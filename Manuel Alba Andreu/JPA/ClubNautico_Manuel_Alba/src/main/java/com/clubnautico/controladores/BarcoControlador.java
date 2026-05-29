package com.clubnautico.controladores;

import com.clubnautico.clases.*;
import com.clubnautico.dto.*;
import com.clubnautico.mappers.ClubNauticoMapper;
import com.clubnautico.servicios.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//URL base para todos los endpoints de este controlador
@RequestMapping("/api/v1/barcos")
public class BarcoControlador {

    private final BarcoServicio barcoServicio;
    private final SocioServicio socioServicio;
    private final ClubNauticoMapper mapper;

    // Inyección de dependencias por constructor
    public BarcoControlador(BarcoServicio barcoServicio, SocioServicio socioServicio, ClubNauticoMapper mapper) {
        this.barcoServicio = barcoServicio;
        this.socioServicio = socioServicio;
        this.mapper = mapper;
    }

    // Endpoint GET para listar todos los barcos 
    @GetMapping
    public ResponseEntity<List<BarcoDTO>> listaBarcos() {
        List<Barco> listaEntidades = barcoServicio.obetenerListaBarcos();
        List<BarcoDTO> listaDtos = new ArrayList<>();
        for (Barco barco : listaEntidades) {
            BarcoDTO dto = mapper.toBarcoDTO(barco);
            listaDtos.add(dto);
        }
        return ResponseEntity.ok(listaDtos);
    }

    // Endpoint GET para obtener un único barco mediante su matrícula pasada por la URL
    @GetMapping("/{matricula}")
    public ResponseEntity<BarcoDTO> obtenerBarcoMatricula(@PathVariable String matricula) {
        // Busca el barco real en la base de datos a través del servicio
        Barco barco = barcoServicio.obtenerBarcoMatricula(matricula);
        // Convierte la entidad encontrada a DTO y la devuelve con estado 200 OK
        return ResponseEntity.ok(mapper.toBarcoDTO(barco));
    }

    // Endpoint POST para registrar un nuevo barco
    @PostMapping
    public ResponseEntity<BarcoDTO> crearBarco(@RequestBody BarcoDTO barcoDTO) {
        Socio socio = socioServicio.obtenerSocioId(barcoDTO.getIdSocio());
        Barco barco = mapper.toBarcoEntity(barcoDTO, socio);
        Barco barcoGuardado = barcoServicio.guardarBarco(barco);
        return ResponseEntity.ok(mapper.toBarcoDTO(barcoGuardado));
    }

    // Endpoint PUT para actualizar un barco buscando su matrícula por la URL
    @PutMapping("/{matricula}")
    public ResponseEntity<BarcoDTO> actualizarBarco(@PathVariable String matricula, @RequestBody BarcoDTO barcoDTO) {
        Barco barcoExistente = barcoServicio.obtenerBarcoMatricula(matricula);
        Socio nuevoDueno = socioServicio.obtenerSocioId(barcoDTO.getIdSocio());

        barcoExistente.setNombreBarco(barcoDTO.getNombreBarco());
        barcoExistente.setNumAmarre(barcoDTO.getNumAmarre());
        barcoExistente.setCuota(barcoDTO.getCuota());
        barcoExistente.setSocio(nuevoDueno);

        Barco barcoActualizado = barcoServicio.actualizarBarco(barcoExistente);
        return ResponseEntity.ok(mapper.toBarcoDTO(barcoActualizado));
    }

    // Endpoint DELETE para eliminar un barco por su matrícula
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> eliminarBarco(@PathVariable String matricula) {
        barcoServicio.eliminarBarco(matricula);
        return ResponseEntity.ok().build();
    }
}
