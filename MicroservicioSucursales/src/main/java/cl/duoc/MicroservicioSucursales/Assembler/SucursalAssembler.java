package cl.duoc.MicroservicioSucursales.Assembler;

import cl.duoc.MicroservicioSucursales.Controller.SucursalController;
import cl.duoc.MicroservicioSucursales.DTO.SucursalDTO;
import cl.duoc.MicroservicioSucursales.Model.Sucursal;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class SucursalAssembler implements RepresentationModelAssembler<Sucursal, EntityModel<SucursalDTO>> {

    @Override
    public EntityModel<SucursalDTO> toModel(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO(
                sucursal.getId(),
                sucursal.getNombre(),
                sucursal.getDireccion(),
                sucursal.getComuna(),
                sucursal.getTelefono()
        );

        return EntityModel.of(dto,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SucursalController.class)
                        .buscarPorId(sucursal.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SucursalController.class)
                        .obtenerTodas()).withRel("sucursales"));
    }
}
