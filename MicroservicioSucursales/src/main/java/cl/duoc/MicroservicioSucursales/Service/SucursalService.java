package cl.duoc.MicroservicioSucursales.Service;

import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import cl.duoc.MicroservicioSucursales.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired SucursalRepository sucursalRepository;

    public List<Sucursal> obtenerTodas() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> buscarPorId(Long id) {
        return sucursalRepository.findById(id);
    }

    public Optional<Sucursal> buscarPorNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre);
    }

    public Sucursal guardar(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Optional<Sucursal> actualizar(Long id, Sucursal nueva) {
        return sucursalRepository.findById(id).map(actual -> {
            actual.setNombre(nueva.getNombre());
            actual.setDireccion(nueva.getDireccion());
            actual.setComuna(nueva.getComuna());
            actual.setTelefono(nueva.getTelefono());
            return sucursalRepository.save(actual);
        });
    }

    public boolean eliminar(Long id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
