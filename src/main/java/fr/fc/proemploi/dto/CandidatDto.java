package fr.fc.proemploi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidatDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<ExperienceDto> experienceDtoList;
}
