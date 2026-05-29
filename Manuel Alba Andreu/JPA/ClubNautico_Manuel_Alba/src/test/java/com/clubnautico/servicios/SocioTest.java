package com.clubnautico.servicios;


import com.clubnautico.clases.*;
import com.clubnautico.excepciones.*;
import com.clubnautico.servicios.*;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SocioTest {

    private final SocioServicio socioServicio;

    @Autowired
    public SocioTest(SocioServicio socioServicio) {
        this.socioServicio = socioServicio;
    }

    @Test
    public void testGuardarSocio() {
        Socio nuevo = new Socio();
        nuevo.setNombreSocio("Andrés");
        nuevo.setApellidoSocio("Iniesta");
        nuevo.setEmail("andres@clubnautico.com");

        Socio guardado = socioServicio.guardarSocio(nuevo);

        assertNotNull(guardado);
        assertTrue(guardado.getIdSocio() > 0);
        assertEquals("Andrés", guardado.getNombreSocio());
    }

    @Test
    public void testObtenerListaSocios() {
        List<Socio> lista = socioServicio.obetenerListaSocios();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testObtenerSocioPorIdError() {       
        assertThrows(ResourceNotFoundException.class, () -> {
            socioServicio.obtenerSocioId(99999);
        });
    }
}