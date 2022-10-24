package examen.examenintra.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NombreDTO {
    private long id;
    private long nombre1;
    private long nombre2;
    private long resultat;

    public NombreDTO(long nombre1, long nombre2) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }

    public NombreDTO(long nombre1, long nombre2, long resultat) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.resultat = resultat;
    }
}
