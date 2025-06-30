package cl.duoc.MicroservicioSucursales.Controller;

import cl.duoc.MicroservicioSucursales.Assembler.SucursalAssembler;
import cl.duoc.MicroservicioSucursales.DTO.SucursalDTO;
import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import cl.duoc.MicroservicioSucursales.Service.SucursalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.media.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalAssembler sucursalAssembler;

    @Operation(summary = "Obtener todas las sucursales")
    @ApiResponse(responseCode = "200", description = "Listado de sucursales")
    @GetMapping
    public CollectionModel<EntityModel<SucursalDTO>> obtenerTodas() {
        List<EntityModel<SucursalDTO>> sucursales = sucursalService.obtenerTodas().stream()
                .map(sucursalAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(sucursales);
    }

    @Operation(summary = "Buscar sucursal por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sucursal encontrada",
            content = @Content(schema = @Schema(implementation = SucursalDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<SucursalDTO>> buscarPorId(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalService.buscarPorId(id);
        return sucursal.map(s -> ResponseEntity.ok(sucursalAssembler.toModel(s)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar sucursal por nombre")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sucursal encontrada",
            content = @Content(schema = @Schema(implementation = SucursalDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<EntityModel<SucursalDTO>> buscarPorNombre(@PathVariable String nombre) {
        Optional<Sucursal> sucursal = sucursalService.buscarPorNombre(nombre);
        return sucursal.map(s -> ResponseEntity.ok(sucursalAssembler.toModel(s)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nueva sucursal")
    @ApiResponse(responseCode = "201", description = "Sucursal creada correctamente",
        content = @Content(schema = @Schema(implementation = SucursalDTO.class)))
    @PostMapping
    public ResponseEntity<EntityModel<SucursalDTO>> crear(@RequestBody Sucursal sucursal) {
        Sucursal creada = sucursalService.guardar(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalAssembler.toModel(creada));
    }

    @Operation(summary = "Actualizar sucursal existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sucursal actualizada",
            content = @Content(schema = @Schema(implementation = SucursalDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<SucursalDTO>> actualizar(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        Optional<Sucursal> actualizada = sucursalService.actualizar(id, sucursal);
        return actualizada.map(s -> ResponseEntity.ok(sucursalAssembler.toModel(s)))
                .orElse(ResponseEntity.notFound().build());
    }

}
