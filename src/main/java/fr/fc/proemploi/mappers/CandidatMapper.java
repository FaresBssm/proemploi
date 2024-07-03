package fr.fc.proemploi.mappers;

import fr.fc.proemploi.dto.CandidatDto;
import fr.fc.proemploi.entity.Candidat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class CandidatMapper {


    public CandidatDto mapToCandidatDto(Candidat candidat) {

        return CandidatDto.builder()
                .firstName(candidat.getFirstName())
                .lastName(candidat.getLastName())
                .email(candidat.getEmail())
                .build();


    }
}
