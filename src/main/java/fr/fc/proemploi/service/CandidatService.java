package fr.fc.proemploi.service;


import fr.fc.proemploi.dto.CandidatDto;
import fr.fc.proemploi.dto.ExperienceDto;
import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.mappers.CandidatMapper;
import fr.fc.proemploi.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public Optional<Candidat> getCandidatById(Long id) {
        return candidatRepository.findById(id);
    }

    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    public void deleteCandidatById(Long id) {
        candidatRepository.deleteById(id);
    }

    public List<CandidatDto> searchByExperience(Long minExperience, Long maxExperience) {


        List<Candidat> candidats = candidatRepository.findAll();

        return candidats.stream()
                .filter(candidat -> candidat.calculateExperience() >= minExperience && candidat.calculateExperience() <= maxExperience)
                .map(candidat -> new CandidatMapper().mapToCandidatDto(candidat))
                .toList();
    }

    public void validateCandidateAndPersist(CandidatDto candidatDto) throws Exception {

        for (ExperienceDto experience : candidatDto.getExperienceDtoList()) {
            if (experience.getStartDate().isAfter(experience.getEndDate()))
                throw new Exception("La date de début ne peut pas être supérieure à la date de fin ");
        }

        Candidat candidat = new CandidatMapper().mapToCandidat(candidatDto);
        candidat.setInscriptionDate(LocalDateTime.now());

        candidatRepository.save(candidat);

    }
}
