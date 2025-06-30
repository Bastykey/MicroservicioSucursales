package cl.duoc.MicroservicioSucursales.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SucursalDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String comuna;
    private String telefono;
}
