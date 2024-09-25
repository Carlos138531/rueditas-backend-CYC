package pe.edu.cibertec.Rueditas_backend_CYC.service;

import pe.edu.cibertec.Rueditas_backend_CYC.dto.BusquedaRequestDTO;

import java.io.IOException;

public interface AutosService {
    String[] validaAuto(BusquedaRequestDTO busquedaRequestDTO)throws IOException;
}
