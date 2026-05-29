package com.clubnautico.mappers;

import com.clubnautico.clases.*;
import com.clubnautico.dto.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClubNauticoMapper {

    public SocioDTO toSocioDTO(Socio socio) {
        if (socio == null) {
            return null;
        }
        List<String> matriculas = new ArrayList<>();
        if (socio.getBarcos() != null) {
            for (Barco barco : socio.getBarcos()) {
                matriculas.add(barco.getNumMatricula());
            }
        }

        return new SocioDTO(
                socio.getIdSocio(),
                socio.getNombreSocio(),
                socio.getApellidoSocio(),
                socio.getEmail(),
                matriculas
        );
    }

    public Socio toSocioEntity(SocioDTO dto) {
        if (dto == null) {
            return null;
        }
        Socio socio = new Socio();
        socio.setIdSocio(dto.getIdSocio());
        socio.setNombreSocio(dto.getNombreSocio());
        socio.setApellidoSocio(dto.getApellidoSocio());
        socio.setEmail(dto.getEmail());
        socio.setBarcos(new ArrayList<>());
        return socio;
    }

    public PatronDTO toPatronDTO(Patron patron) {
        if (patron == null) {
            return null;
        }
        return new PatronDTO(patron.getIdPatron(), patron.getNombrePatron(), patron.getApellidoPatron(), patron.getLicencia());
    }

    public Patron toPatronEntity(PatronDTO dto) {
        if (dto == null) {
            return null;
        }
        Patron patron = new Patron();
        patron.setIdPatron(dto.getIdPatron());
        patron.setNombrePatron(dto.getNombrePatron());
        patron.setApellidoPatron(dto.getApellidoPatron());
        patron.setLicencia(dto.getLicencia());
        return patron;
    }

    public BarcoDTO toBarcoDTO(Barco barco) {
        if (barco == null) {
            return null;
        }
        int idSocio = (barco.getSocio() != null) ? barco.getSocio().getIdSocio() : 0;
        return new BarcoDTO(barco.getNumMatricula(), barco.getNombreBarco(), barco.getNumAmarre(), barco.getCuota(), idSocio);
    }

    public Barco toBarcoEntity(BarcoDTO dto, Socio socio) {
        if (dto == null) {
            return null;
        }
        Barco barco = new Barco();
        barco.setNumMatricula(dto.getNumMatricula());
        barco.setNombreBarco(dto.getNombreBarco());
        barco.setNumAmarre(dto.getNumAmarre());
        barco.setCuota(dto.getCuota());
        barco.setSocio(socio);
        return barco;
    }

    public SalidasDTO toSalidasDTO(Salidas salida) {
        if (salida == null) {
            return null;
        }
        String matricula = (salida.getBarco() != null) ? salida.getBarco().getNumMatricula() : null;
        int idPatron = (salida.getPatron() != null) ? salida.getPatron().getIdPatron() : 0;
        return new SalidasDTO(salida.getIdSalida(), salida.getFehcaSalida(), salida.getHoraSalida(), salida.getDestino(), matricula, idPatron);
    }

    public Salidas toSalidasEntity(SalidasDTO dto, Barco barco, Patron patron) {
        if (dto == null) {
            return null;
        }
        Salidas salida = new Salidas();
        salida.setIdSalida(dto.getIdSalida());
        salida.setFehcaSalida(dto.getFehcaSalida());
        salida.setHoraSalida(dto.getHoraSalida());
        salida.setDestino(dto.getDestino());
        salida.setBarco(barco);
        salida.setPatron(patron);
        return salida;
    }
}
