package com.clubnautico.controladores;

import com.clubnautico.clases.*;
import com.clubnautico.dto.*;
import com.clubnautico.mappers.ClubNauticoMapper;
import com.clubnautico.servicios.*;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//URL base para todos los endpoints de este controlador
@RequestMapping("/api/v1/socios")
public class SocioControlador {

    private final SocioServicio socioServicio;
    private final ClubNauticoMapper mapper;

    // Inyección de dependencias por constructor
    public SocioControlador(SocioServicio socioServicio, ClubNauticoMapper mapper) {
        this.socioServicio = socioServicio;
        this.mapper = mapper;
    }

    // Endpoint GET para listar todos los socios
    @GetMapping
    public ResponseEntity<List<SocioDTO>> listaSocios() {
        List<Socio> listaEntidades = socioServicio.obetenerListaSocios();
        List<SocioDTO> listaDtos = new ArrayList<>();
        for (Socio socio : listaEntidades) {
            SocioDTO dto = mapper.toSocioDTO(socio);
            listaDtos.add(dto);
        }
        return ResponseEntity.ok(listaDtos);
    }

    // Endpoint GET para obtener un único socio mediante su id pasada por la URL
    @GetMapping("/{id}")
    public ResponseEntity<SocioDTO> obtenerSocioId(@PathVariable int id) {
        Socio socio = socioServicio.obtenerSocioId(id);
        return ResponseEntity.ok(mapper.toSocioDTO(socio));
    }

    // Endpoint POST para registrar un nuevo socio
    @PostMapping
    public ResponseEntity<SocioDTO> crearSocio(@RequestBody SocioDTO socioDTO) {
        Socio socio = mapper.toSocioEntity(socioDTO);
        Socio socioGuardado = socioServicio.guardarSocio(socio);
        return ResponseEntity.ok(mapper.toSocioDTO(socioGuardado));
    }

    // Endpoint PUT para actualizar un socio buscando su id por la URL
    @PutMapping("/{id}")
    public ResponseEntity<SocioDTO> actualizarSocio(@PathVariable int id, @RequestBody SocioDTO socioDTO) {
        Socio socioExistente = socioServicio.obtenerSocioId(id);

        socioExistente.setNombreSocio(socioDTO.getNombreSocio());
        socioExistente.setApellidoSocio(socioDTO.getApellidoSocio());
        socioExistente.setEmail(socioDTO.getEmail());

        Socio socioActualizado = socioServicio.guardarSocio(socioExistente);
        return ResponseEntity.ok(mapper.toSocioDTO(socioActualizado));
    }

    // Endpoint DELETE para eliminar un patron por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSocio(@PathVariable int id) {
        socioServicio.eliminarSocio(id);
        return ResponseEntity.ok().build();
    }

}
