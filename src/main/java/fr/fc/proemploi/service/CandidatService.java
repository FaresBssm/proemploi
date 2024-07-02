package fr.fc.proemploi.service;


import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Candidat> findByExperience(Long experience) {
        return candidatRepository.findByExperience(experience);
    }

    public Optional<Candidat> findCandidatWithMinExperience() {
        return candidatRepository.findAll().stream().min((c1,c2)->Integer.compare(c1.getExperince(),c2.getExperince()));
    }

    public Optional<Candidat> findCandidatWithMaxExperience() {
        return  candidatRepository.findAll().stream().max((c1,c2)->Integer.compare(c1.getExperince(),c2.getExperince()));
    }
}
