package fr.fc.proemploi;

import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.entity.Experience;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class CandidatTest {

    Candidat candidat;


    @BeforeEach
    void init() {

        candidat = new Candidat();

    }

    @Test
    void itShouldTestTheExperienceOfCandidate() {

        // GIVEN
        Experience experience1 = new Experience();
        experience1.setId(1L);
        experience1.setClient("BNP Paribas");
        experience1.setStartDate(LocalDate.of(2020, 1, 1));
        experience1.setEndDate(LocalDate.of(2020, 12, 31));

        candidat.setExperiences(List.of(experience1));

        // WHEN
        long nbDaysExperience = candidat.calculateExperience();

        // THEN
        Assertions.assertEquals(365, nbDaysExperience);

    }


    @Test
    void itShouldTestTheExperiencCalculateWithManyExperiences() {

        // GIVEN
        Experience experience1 = new Experience();
        experience1.setId(1L);
        experience1.setClient("BNP Paribas");
        experience1.setStartDate(LocalDate.of(2020, 1, 1));
        experience1.setEndDate(LocalDate.of(2020, 12, 31));


        Experience experience2 = new Experience();
        experience2.setId(2L);
        experience2.setClient("Société Générale");
        experience2.setStartDate(LocalDate.of(2022, 2, 1));
        experience2.setEndDate(LocalDate.of(2023, 3, 31));

        candidat.setExperiences(List.of(experience1, experience2));

        // WHEN
        long nbDaysExperience = candidat.calculateExperience();

        // THEN
        Assertions.assertEquals(788, nbDaysExperience);

    }
}
