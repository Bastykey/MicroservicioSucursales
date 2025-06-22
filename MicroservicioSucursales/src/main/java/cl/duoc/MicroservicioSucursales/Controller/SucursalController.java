package cl.duoc.MicroservicioSucursales.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.MicroservicioSucursales.DTO.SucursalDTO;
import cl.duoc.MicroservicioSucursales.Model.Sucursal;
import cl.duoc.MicroservicioSucursales.Service.SucursalService;
import cl.duoc.MicroservicioSucursales.Assembler.SucursalAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.media.*;

@RestController
@RequestMapping("api/v1/sucursales")
@Tag(name = "Sucursal", description = "Gestión de sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

@GetMapping
@Operation(summary = "Listar todas las sucursales registradas")
@ApiResponse(responseCode = "200", description = "Listado exitoso de sucursales",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = SucursalDTO.class),
        examples = @ExampleObject(
            name = "Ejemplo de listado",
            value = "[\n" +
                    "  {\n" +
                    "    \"nombre\": \"Sucursal Plaza Oeste\",\n" +
                    "    \"direccion\": \"Av. Américo Vespucio 1501\",\n" +
                    "    \"ciudad\": \"Cerrillos\",\n" +
                    "    \"horarioApertura\": \"09:00\",\n" +
                    "    \"horarioCierre\": \"18:00\",\n" +
                    "    \"estado\": \"ACTIVA\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"nombre\": \"Sucursal La Reina\",\n" +
                    "    \"direccion\": \"Av. Príncipe de Gales 5555\",\n" +
                    "    \"ciudad\": \"La Reina\",\n" +
                    "    \"horarioApertura\": \"10:00\",\n" +
                    "    \"horarioCierre\": \"19:00\",\n" +
                    "    \"estado\": \"ACTIVA\"\n" +
                    "  }\n" +
                    "]"
        )
    )
)
public ResponseEntity<List<SucursalDTO>> listar() {
    List<SucursalDTO> lista = sucursalService.listarSucursales()
        .stream()
        .map(SucursalAssembler::toDto)
        .toList();

    return ResponseEntity.ok(lista);
}


@GetMapping("/{id}")
@Operation(summary = "Obtener sucursal por ID")
@ApiResponse(responseCode = "200", description = "Sucursal encontrada",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = SucursalDTO.class),
        examples = @ExampleObject(
            name = "Ejemplo personalizado",
            value = "{\n  \"nombre\": \"Sucursal Ñuñoa\",\n  \"direccion\": \"Av. Grecia 123\",\n  \"ciudad\": \"Ñuñoa\",\n  \"horarioApertura\": \"10:00\",\n  \"horarioCierre\": \"20:00\",\n  \"estado\": \"ACTIVA\"\n}"
        )
    )
)
public ResponseEntity<SucursalDTO> obtener(@PathVariable Long id) {
    Sucursal sucursal = sucursalService.obtenerSucursal(id);
    SucursalDTO dto = SucursalAssembler.toDto(sucursal);
    return ResponseEntity.ok(dto);
}

@PostMapping
@Operation(summary = "Crear una nueva sucursal")
@ApiResponse(responseCode = "200", description = "Sucursal creada exitosamente",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = SucursalDTO.class),
        examples = @ExampleObject(
            name = "Ejemplo: Sucursal creada EXITOSAMENTE",
            value = "{\n" +
                    "  \"nombre\": \"Sucursal Maipú\",\n" +
                    "  \"direccion\": \"Av. Pajaritos 1234\",\n" +
                    "  \"ciudad\": \"Maipú\",\n" +
                    "  \"horarioApertura\": \"09:00\",\n" +
                    "  \"horarioCierre\": \"18:30\",\n" +
                    "  \"estado\": \"ACTIVA\"\n" +
                    "}"
        )
    )
)
@io.swagger.v3.oas.annotations.parameters.RequestBody(
    description = "Datos para crear una sucursal",
    required = true,
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = SucursalDTO.class),
        examples = @ExampleObject(
            name = "Ejemplo de solicitud Exitoso",
            value = "{\n" +
                    "  \"nombre\": \"Sucursal Maipú\",\n" +
                    "  \"direccion\": \"Av. Pajaritos 1234\",\n" +
                    "  \"ciudad\": \"Maipú\",\n" +
                    "  \"horarioApertura\": \"09:00\",\n" +
                    "  \"horarioCierre\": \"18:30\",\n" +
                    "  \"estado\": \"En proceso...\"\n" +
                    "}"
        )
    )
)
public ResponseEntity<SucursalDTO> crear(@RequestBody SucursalDTO sucursalDTO) {
    Sucursal entidad = SucursalAssembler.toEntity(sucursalDTO);
    Sucursal creada = sucursalService.crearSucursal(entidad);
    SucursalDTO respuesta = SucursalAssembler.toDto(creada);
    return ResponseEntity.ok(respuesta);
}
@PutMapping("/{id}")
@Operation(summary = "Actualizar una sucursal existente")
@ApiResponse(responseCode = "200", description = "Sucursal actualizada correctamente",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = SucursalDTO.class),
        examples = @ExampleObject(
            name = "Ejemplo de respuesta",
            value = "{\n" +
                    "  \"nombre\": \"Sucursal Maipú (Actualizada)\",\n" +
                    "  \"direccion\": \"Av. Pajaritos 1234\",\n" +
                    "  \"ciudad\": \"Maipú\",\n" +
                    "  \"horarioApertura\": \"09:00\",\n" +
                    "  \"horarioCierre\": \"19:00\",\n" +
                    "  \"estado\": \"ACTIVA\"\n" +
                    "}"
        )
    )
)
@io.swagger.v3.oas.annotations.parameters.RequestBody(
    description = "Datos actualizados de la sucursal",
    required = true,
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = SucursalDTO.class),
        examples = @ExampleObject(
            name = "Ejemplo de solicitud",
            value = "{\n" +
                    "  \"nombre\": \"Sucursal Maipú \",\n" +
                    "  \"direccion\": \"Av. Pajaritos 1234\",\n" +
                    "  \"ciudad\": \"Maipú\",\n" +
                    "  \"horarioApertura\": \"10:00\",\n" +
                    "  \"horarioCierre\": \"20:00\",\n" +
                    "  \"estado\": \"INACTIVA\"\n" +
                    "}"
        )
    )
)
public ResponseEntity<SucursalDTO> actualizar(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
    Sucursal entidad = SucursalAssembler.toEntity(sucursalDTO);
    Sucursal actualizada = sucursalService.actualizarSucursal(id, entidad);
    SucursalDTO respuesta = SucursalAssembler.toDto(actualizada);
    return ResponseEntity.ok(respuesta);
}
}