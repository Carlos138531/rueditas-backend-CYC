package pe.edu.cibertec.Rueditas_backend_CYC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Rueditas_backend_CYC.dto.BusquedaRequestDTO;
import pe.edu.cibertec.Rueditas_backend_CYC.dto.BusquedaResponseDTO;
import pe.edu.cibertec.Rueditas_backend_CYC.service.AutosService;

@RestController()
@RequestMapping("/informacionauto")
public class AutosController {

    @Autowired
    AutosService autosService;

    @PostMapping("/busqueda")
    public BusquedaResponseDTO buscar(@RequestBody BusquedaRequestDTO busquedaRequestDTO){

        try {
            String[] datosAuto = autosService.validaAuto(busquedaRequestDTO);

            if(datosAuto == null){
                return new BusquedaResponseDTO("01","No se encontró un vehículo para la placa ingresada","","","","","");

            }
            return new BusquedaResponseDTO("00", "", datosAuto[0], datosAuto[1], datosAuto[2], datosAuto[3],datosAuto[4]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BusquedaResponseDTO("99","Error: Ocurrió un problema","","","","","");
        }

    }
}
