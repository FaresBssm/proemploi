package fr.fc.proemploi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExperienceDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private List<String> skills;
}
