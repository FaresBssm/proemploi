package fr.fc.proemploi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidatDto {

    private String firstName;
    private String lastName;
    private String email;
}
