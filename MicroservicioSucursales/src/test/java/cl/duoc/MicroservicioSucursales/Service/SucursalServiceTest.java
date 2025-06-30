package cl.duoc.MicroservicioSucursales.Service;

import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import cl.duoc.MicroservicioSucursales.Repository.SucursalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SucursalServiceTest {

    private SucursalRepository sucursalRepository;
    private SucursalService sucursalService;

    @BeforeEach
    void setUp() {
        sucursalRepository = Mockito.mock(SucursalRepository.class);
        sucursalService = new SucursalService();
        sucursalService = spy(sucursalService);
        sucursalService.sucursalRepository = sucursalRepository;
    }

    @Test
    void testObtenerTodas() {
        Sucursal s1 = new Sucursal(1L, "Sucursal A", "Calle A", "Comuna A", "123456");
        Sucursal s2 = new Sucursal(2L, "Sucursal x", "Calle x", "Comuna x", "987654");

        when(sucursalRepository.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<Sucursal> resultado = sucursalService.obtenerTodas();

        assertEquals(2, resultado.size());
        verify(sucursalRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorId() {
        Sucursal sucursal = new Sucursal(1L, "Sucursal A", "Calle A", "Comuna A", "123456");
        when(sucursalRepository.findById(1L)).thenReturn(Optional.of(sucursal));

        Optional<Sucursal> resultado = sucursalService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Sucursal A", resultado.get().getNombre());
    }

    @Test
    void testGuardar() {
        Sucursal sucursal = new Sucursal(null, "Sucursal Nueva", "Nueva Direccion", "Comuna Nueva", "111111");
        when(sucursalRepository.save(sucursal)).thenReturn(sucursal);

        Sucursal guardada = sucursalService.guardar(sucursal);

        assertEquals("Sucursal Nueva", guardada.getNombre());
        verify(sucursalRepository).save(sucursal);
    }



}
