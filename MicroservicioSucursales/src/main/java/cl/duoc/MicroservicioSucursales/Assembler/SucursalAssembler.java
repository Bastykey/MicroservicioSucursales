package cl.duoc.MicroservicioSucursales.Assembler;

import cl.duoc.MicroservicioSucursales.DTO.SucursalDTO;
import cl.duoc.MicroservicioSucursales.Model.Sucursal;

public class SucursalAssembler {

    public static SucursalDTO toDto(Sucursal entidad) {
        SucursalDTO dto = new SucursalDTO();
        dto.setNombre(entidad.getNombre());
        dto.setDireccion(entidad.getDireccion());
        dto.setCiudad(entidad.getCiudad());
        dto.setHorarioApertura(entidad.getHorarioApertura());
        dto.setHorarioCierre(entidad.getHorarioCierre());
        dto.setEstado(entidad.getEstado().name());
        return dto;
    }

    public static Sucursal toEntity(SucursalDTO dto) {
        Sucursal entidad = new Sucursal();
        entidad.setNombre(dto.getNombre());
        entidad.setDireccion(dto.getDireccion());
        entidad.setCiudad(dto.getCiudad());
        entidad.setHorarioApertura(dto.getHorarioApertura());
        entidad.setHorarioCierre(dto.getHorarioCierre());
        entidad.setEstado(Enum.valueOf(cl.duoc.MicroservicioSucursales.Model.EstadoSucursal.class, dto.getEstado()));
        return entidad;
    }
}