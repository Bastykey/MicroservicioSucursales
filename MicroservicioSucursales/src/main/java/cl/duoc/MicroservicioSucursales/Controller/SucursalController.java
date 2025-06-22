package cl.duoc.MicroservicioSucursales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import cl.duoc.MicroservicioSucursales.Service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("api/v1/sucursales")
@Tag(name = "Sucursal", description = "Gestión de sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

@Operation(summary = "Listar todas las sucursales")
@GetMapping
    public List<Sucursal> listar() {
        return sucursalService.listarSucursales();
    }

@Operation(summary = "Obtener una sucursal por ID")
@GetMapping("/{id}")
    public Sucursal obtener(@PathVariable Long id) {
        return sucursalService.obtenerSucursal(id);
    }

@Operation(summary = "Crear una nueva sucursal")
@PostMapping
    public Sucursal crear(@RequestBody Sucursal sucursal) {
        return sucursalService.crearSucursal(sucursal);
    }

@Operation(summary = "Actualizar una sucursal")
@PutMapping("/{id}")
    public Sucursal actualizar(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return sucursalService.actualizarSucursal(id, sucursal);
    }
}

