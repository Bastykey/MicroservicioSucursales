package cl.duoc.MicroservicioSucursales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.MicroservicioSucursales.Model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}