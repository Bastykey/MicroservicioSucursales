package cl.duoc.MicroservicioSucursales.Service;

import java.util.List;
import cl.duoc.MicroservicioSucursales.Model.Sucursal;

public interface SucursalService {
    List<Sucursal> listarSucursales();
    Sucursal obtenerSucursal(Long id);
    Sucursal crearSucursal(Sucursal sucursal);
    Sucursal actualizarSucursal(Long id, Sucursal sucursal);
}