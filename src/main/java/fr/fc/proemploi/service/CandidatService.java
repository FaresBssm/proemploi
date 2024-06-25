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
}
