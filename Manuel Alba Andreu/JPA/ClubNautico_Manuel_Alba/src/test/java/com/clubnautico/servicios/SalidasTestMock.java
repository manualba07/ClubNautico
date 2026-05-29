package com.clubnautico.servicios;

import com.clubnautico.clases.*;
import com.clubnautico.excepciones.*;
import com.clubnautico.repositorios.*;
import com.clubnautico.servicios.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SalidasTestMock {

    @Mock
    private SalidasRepositorio salidasRepositorio;

    @InjectMocks
    private SalidasServicio salidasServicio;

    private Salidas salidaPrueba;

    @BeforeEach
    public void iniciarMocks() {
        // Inicializa los mocks antes de cada test
        MockitoAnnotations.openMocks(this);

        // Creación de objeto de prueba 
        salidaPrueba = new Salidas();
        salidaPrueba.setIdSalida(10);
        salidaPrueba.setDestino("Ibiza");
    }

    @Test
    public void testObtenerListaSalidasExito() {
        when(salidasRepositorio.findAll()).thenReturn(Arrays.asList(salidaPrueba));

        List<Salidas> resultado = salidasServicio.obetenerListaSalidas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Ibiza", resultado.get(0).getDestino());

        verify(salidasRepositorio, times(1)).findAll();
    }

    @Test
    public void testObtenerSalidaPorIdExito() {
        when(salidasRepositorio.findById(10)).thenReturn(Optional.of(salidaPrueba));
        
        Salidas resultado = salidasServicio.obtenerSalidaId(10);
        
        assertNotNull(resultado);
        assertEquals(10, resultado.getIdSalida());
        assertEquals("Ibiza", resultado.getDestino());
        
        verify(salidasRepositorio, times(1)).findById(10);
    }

    @Test
    public void testObtenerSalidaPorIdNoEncontradaLanzaExcepcion() {
        when(salidasRepositorio.findById(99)).thenReturn(Optional.empty());
        
        assertThrows(ResourceNotFoundException.class, () -> {
            salidasServicio.obtenerSalidaId(99);
        });
        
        verify(salidasRepositorio, times(1)).findById(99);
    }

    @Test
    public void testGuardarSalidaExito() {
        when(salidasRepositorio.save(salidaPrueba)).thenReturn(salidaPrueba);
        
        Salidas guardada = salidasServicio.guardarSalida(salidaPrueba);
        
        assertNotNull(guardada);
        assertEquals("Ibiza", guardada.getDestino());
        
        verify(salidasRepositorio, times(1)).save(salidaPrueba);
    }

    @Test
    public void testEliminarSalidaExito() {
        when(salidasRepositorio.existsById(10)).thenReturn(true);
        
        doNothing().when(salidasRepositorio).deleteById(10);
        salidasServicio.eliminarSalida(10);
        
        verify(salidasRepositorio, times(1)).existsById(10);
        verify(salidasRepositorio, times(1)).deleteById(10);
    }

    @Test
    public void testEliminarSalidaNoExisteLanzaExcepcion() {
        when(salidasRepositorio.existsById(99)).thenReturn(false);
        
        assertThrows(ResourceNotFoundException.class, () -> {
            salidasServicio.eliminarSalida(99);
        });
        
        verify(salidasRepositorio, times(1)).existsById(99);
        verify(salidasRepositorio, never()).deleteById(99);
    }
}
