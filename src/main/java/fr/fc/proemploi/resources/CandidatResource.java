package fr.fc.proemploi.resources;

import fr.fc.proemploi.dto.CandidatDto;
import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.entity.Experience;
import fr.fc.proemploi.service.CandidatService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/candidat")
@Slf4j
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
        if (candidat.isPresent()) {
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


    @GetMapping("/search-by-experience")
    public List<CandidatDto> searchByExperience(@RequestParam(name = "minExperience", defaultValue = "0") @Nullable Long minExperience,
                                                @RequestParam(name = "maxExperience", defaultValue = "9999999") @Nullable Long maxExperience) {
        return candidatService.searchByExperience(minExperience, maxExperience);

    }

    @PostMapping("add")
    public String addCandidate(@RequestBody CandidatDto candidatDto) {
        try {
            candidatService.validateCandidateAndPersist(candidatDto);
            return "Canidat crée avec succès";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
