package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.entity.Experience;
import fr.fc.proemploi.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/candidat")

public class CandidatResource {
    @Autowired
    private CandidatService candidatService;

    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat savedCandidat = candidatService.saveCandidat(candidat);
        return ResponseEntity.ok(savedCandidat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidat(@PathVariable Long id) {
        Optional<Candidat> candidat = candidatService.getCandidatById(id);
        return candidat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<Candidat> getAllCandidats() {
        return candidatService.getAllCandidats();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Candidat> deleteCandidat(@PathVariable Long id) {
        Optional<Candidat> candidat = candidatService.getCandidatById(id);
        if(candidat.isPresent()) {
            candidatService.deleteCandidatById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/experience")
    public ResponseEntity<List<Experience>> getExperience(@PathVariable Long id) {
        Optional<Candidat> candidat = candidatService.getCandidatById(id);
        return candidat.map(c -> ResponseEntity.ok(c.getExperiences())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/with-skills")
    public ResponseEntity<List<Candidat>> getCandidatWithCompetence() {
        List<Candidat> candidats = candidatService.getAllCandidats();
        return ResponseEntity.ok(candidats);
    }


    }
