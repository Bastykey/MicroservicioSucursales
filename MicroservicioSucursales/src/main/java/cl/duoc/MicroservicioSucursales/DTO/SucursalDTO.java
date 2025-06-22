package cl.duoc.MicroservicioSucursales.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "representa una sucursal de Perfulandia SPA")
public class SucursalDTO {

    @Schema(description = "Nombre de la sucursal", example = "Sucursal  Perfulandia Santiago")
    private String nombre;

    @Schema(description = "Dirección física de la sucursal", example = "Av. Américo Vespucio 13920, La FLorida")
    private String direccion;

    @Schema(description = "Ciudad donde se ubica la sucursal", example = "Santiago")
    private String ciudad;

    @Schema(description = "Hora de apertura", example = "09:00")
    private String horarioApertura;

    @Schema(description = "Hora de cierre", example = "20:00")
    private String horarioCierre;

    @Schema(description = "Estado actual de la sucursal", example = "ACTIVA")
    private String estado;

    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getHorarioApertura() { return horarioApertura; }
    public void setHorarioApertura(String horarioApertura) { this.horarioApertura = horarioApertura; }

    public String getHorarioCierre() { return horarioCierre; }
    public void setHorarioCierre(String horarioCierre) { this.horarioCierre = horarioCierre; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}