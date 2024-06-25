package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/candidat")

public class CandidatResource {
    @Autowired
    private CandidatRepository candidatRepository;

    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat savedCandidat = candidatRepository.save(candidat);
        return ResponseEntity.ok(savedCandidat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidat(@PathVariable Long id) {
        Optional<Candidat> candidat = candidatRepository.findById(id);
        return candidat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Candidat> deleteCandidat(@PathVariable Long id) {
        Optional<Candidat> candidat = candidatRepository.findById(id);
        return candidat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    }
