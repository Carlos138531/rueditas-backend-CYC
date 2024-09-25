package pe.edu.cibertec.Rueditas_backend_CYC.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Rueditas_backend_CYC.dto.BusquedaRequestDTO;
import pe.edu.cibertec.Rueditas_backend_CYC.service.AutosService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutosServiceImpl implements AutosService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validaAuto(BusquedaRequestDTO busquedaRequestDTO) throws IOException {

        String[] datosAuto = null;

        Resource resource = resourceLoader.getResource("classpath:autos.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if(busquedaRequestDTO.placa().equals(datos[0])){
                    datosAuto = new String[5];
                    datosAuto[0] = datos[1]; // Marca
                    datosAuto[1] = datos[2]; // Modelo
                    datosAuto[2] = datos[3]; // Asientos
                    datosAuto[3] = datos[4]; // Precio
                    datosAuto[4] = datos[5]; // Color

                }
            }
            System.out.println("Request DTO enviado desde el frontend: " + busquedaRequestDTO.placa());
        }catch (IOException e){
            datosAuto= null;
            throw new IOException(e);
        }
        System.out.println("Request DTO enviado desde el frontend6: " + busquedaRequestDTO.placa());
        System.out.println(datosAuto);
        return datosAuto;
    }

}
