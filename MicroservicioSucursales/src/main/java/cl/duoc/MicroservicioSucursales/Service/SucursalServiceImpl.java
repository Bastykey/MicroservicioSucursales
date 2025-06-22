package cl.duoc.MicroservicioSucursales.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import cl.duoc.MicroservicioSucursales.Repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> listarSucursales() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal obtenerSucursal(Long id) {
        return sucursalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    }

    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal actualizarSucursal(Long id, Sucursal nuevaInfo) {
        Sucursal sucursal = obtenerSucursal(id);
        sucursal.setNombre(nuevaInfo.getNombre());
        sucursal.setDireccion(nuevaInfo.getDireccion());
        sucursal.setCiudad(nuevaInfo.getCiudad());
        sucursal.setHorarioApertura(nuevaInfo.getHorarioApertura());
        sucursal.setHorarioCierre(nuevaInfo.getHorarioCierre());
        sucursal.setEstado(nuevaInfo.getEstado());
        return sucursalRepository.save(sucursal);
    }
}