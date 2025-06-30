package cl.duoc.MicroservicioSucursales.Repository;

import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    Optional<Sucursal> findByNombre(String nombre);
}
