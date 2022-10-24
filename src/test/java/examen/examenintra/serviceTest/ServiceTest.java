package examen.examenintra.serviceTest;


import examen.examenintra.DTOs.NombreDTO;
import examen.examenintra.services.ServiceTraiterChiffre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    ServiceTraiterChiffre serviceTraiterChiffre;

    @Mock
    NombreRepository nombreRepository;

    NombreDTO nombreDTOADD;
    NombreDTO nombreDTO;

    NombreDTO resultatAdd;
    NombreDTO resultat;
    @BeforeEach
    void setup() {
        nombreDTOADD = new NombreDTO(2,2);
        nombreDTO = new NombreDTO(5,4);
        resultatAdd = new NombreDTO(2,2,4);
        resultat = new NombreDTO(5,4,1);
    }

    @Test
    void addNombreHappyDayTest() throws Exception {
        // Arrange

        // Act
        NombreDTO nombreDTO1 = serviceTraiterChiffre.getResultAdd(nombreDTOADD);

        // Assert
        assertThat(nombreDTO1).isEqualTo(resultatAdd);
    }


    @Test
    void soustraitNombreHappyDayTest() throws Exception {
        // Arrange

        // Act
        NombreDTO nombreDTO1 = serviceTraiterChiffre.getResultSoustrait(nombreDTO);

        // Assert
        assertThat(nombreDTO1).isEqualTo(resultat);
    }
}
