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
public class PatronTest {
    
    private final PatronServicio patronServicio;

    @Autowired
    public PatronTest(PatronServicio patronServicio) {
        this.patronServicio = patronServicio;
    }

    @Test
    public void testGuardarPatron() {
        Patron nuevo = new Patron();
        nuevo.setNombrePatron("Carlos");
        nuevo.setApellidoPatron("Sainz");
        nuevo.setLicencia("PER-2026");

        Patron guardado = patronServicio.guardarPatron(nuevo);

        assertNotNull(guardado);
        assertEquals("Carlos", guardado.getNombrePatron());
    }

    @Test
    public void testObtenerListaPatrones() {
        List<Patron> lista = patronServicio.obetenerListaPatron();
        assertNotNull(lista);
    }

    @Test
    public void testEliminarPatronError() {
        assertThrows(ResourceNotFoundException.class, () -> {
            patronServicio.eliminarPatron(99999);
        });
    }
}
