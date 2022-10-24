package examen.examenintra.controleurs;

import examen.examenintra.DTOs.NombreDTO;
import examen.examenintra.services.ServiceTraiterChiffre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class MonPageController {
    Logger logger = LoggerFactory.getLogger(MonPageController.class);
    private ServiceTraiterChiffre serviceTraiterChiffre;

    public MonPageController(ServiceTraiterChiffre serviceTraiterChiffre) {
        this.serviceTraiterChiffre = serviceTraiterChiffre;
    }

    @PutMapping("/add")
    public ResponseEntity<NombreDTO> getAddResultat(@RequestBody NombreDTO nombreDTO){
        try{
            NombreDTO result = serviceTraiterChiffre.getResultAdd(nombreDTO);
            return ResponseEntity.ok(result);
        }catch (Exception message){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/soustrait")
    public ResponseEntity<NombreDTO> getSoustraitResultat(@RequestBody NombreDTO nombreDTO){
        try{
            NombreDTO result = serviceTraiterChiffre.getResultSoustrait(nombreDTO);
            return ResponseEntity.ok(result);
        }catch (Exception message){
            return ResponseEntity.notFound().build();
        }
    }

}

