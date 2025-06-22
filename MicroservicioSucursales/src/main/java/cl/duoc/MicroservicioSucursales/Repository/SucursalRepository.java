package cl.duoc.MicroservicioSucursales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.MicroservicioSucursales.Service.SucursalService;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalService, Long> {
}