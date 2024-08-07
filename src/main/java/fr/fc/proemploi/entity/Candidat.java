package fr.fc.proemploi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Blob cv;
    private Blob motivationLetter;
    private String linkedinProfile;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime inscriptionDate;

    @OneToMany(mappedBy = "candidat",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public long calculateExperience() {
        long nbDaysExperience = 0;

        for (Experience experience : experiences){
            nbDaysExperience = nbDaysExperience + ChronoUnit.DAYS.between(experience.getStartDate(), experience.getEndDate());
        }

        return nbDaysExperience;
    }
}
