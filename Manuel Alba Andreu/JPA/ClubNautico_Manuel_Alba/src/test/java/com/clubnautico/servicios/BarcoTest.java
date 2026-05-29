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
public class BarcoTest {
    
    private final BarcoServicio barcoServicio;

    @Autowired
    public BarcoTest(BarcoServicio barcoServicio) {
        this.barcoServicio = barcoServicio;
    }

    @Test
    public void testGuardarBarcoErrorMatriculaVacia() {
        Barco barcoInvalido = new Barco();
        barcoInvalido.setNumMatricula(""); 

        assertThrows(BadRequestException.class, () -> {
            barcoServicio.guardarBarco(barcoInvalido);
        });
    }

    @Test
    public void testObtenerBarcoNoExiste() {
        assertThrows(ResourceNotFoundException.class, () -> {
            barcoServicio.obtenerBarcoMatricula("No existe");
        });
    }

    @Test
    public void testEliminarBarcoNoExiste() {
        assertThrows(ResourceNotFoundException.class, () -> {
            barcoServicio.eliminarBarco("No existe");
        });
    }
}
