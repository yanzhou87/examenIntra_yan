package examen.examenintra.services;

import examen.examenintra.DTOs.NombreDTO;
import org.springframework.stereotype.Service;

@Service
public class ServiceTraiterChiffre {


    public ServiceTraiterChiffre() {
    }
    public NombreDTO getResultAdd(NombreDTO nombreDTO) {
        long result = nombreDTO.getNombre1() + nombreDTO.getNombre2();
        NombreDTO nombreDTO1 = new NombreDTO(nombreDTO.getNombre1(), nombreDTO.getNombre2(), result);

        return nombreDTO1;
    }

    public NombreDTO getResultSoustrait(NombreDTO nombreDTO) {
        long result = nombreDTO.getNombre1() - nombreDTO.getNombre2();
        NombreDTO nombreDTO1 = new NombreDTO(nombreDTO.getNombre1(), nombreDTO.getNombre2(), result);

        return nombreDTO1;
    }
}
