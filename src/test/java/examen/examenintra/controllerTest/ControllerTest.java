package examen.examenintra.controllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import examen.examenintra.DTOs.NombreDTO;
import examen.examenintra.controleurs.MonPageController;
import examen.examenintra.services.ServiceTraiterChiffre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
      MockMvc mockMvc;

      @InjectMocks
      MonPageController monPageController;
      @Mock
      ServiceTraiterChiffre serviceTraiterChiffre;

      JacksonTester<NombreDTO> jacksonNombreDTO ;
      NombreDTO nombreDTOAdd;
      NombreDTO nombreDTO;
      NombreDTO resultatAdd;
      NombreDTO resultat;
    @BeforeEach
    void setup() {
        nombreDTOAdd = new NombreDTO(1,2);
        resultatAdd = new NombreDTO(1,2,3);
        nombreDTO = new NombreDTO(4,1);
        resultat = new NombreDTO(4,1,3);
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(monPageController).build();
    }
    @Test
    void testAddHappyDay()throws Exception{
        when(serviceTraiterChiffre.getResultAdd(any())).thenReturn(resultatAdd);
        mockMvc.perform(put("/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonNombreDTO.write(nombreDTOAdd).getJson()))
                .andExpect(status().isOk());
    }

    @Test
    void testSoustraitHappyDay()throws Exception{
        when(serviceTraiterChiffre.getResultSoustrait(any())).thenReturn(resultat);
        mockMvc.perform(put("/soustrait")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonNombreDTO.write(nombreDTO).getJson()))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateEtudiantBadRequest() throws Exception {

        mockMvc.perform(put("/adad"))

                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateEtudiantUrlNotFound() throws Exception {

        mockMvc.perform(put("/soustraitaaaa"))
                .andExpect(status().isNotFound());
    }
}
