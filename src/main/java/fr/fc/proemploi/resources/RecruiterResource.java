package fr.fc.proemploi.resources;


import fr.fc.proemploi.entity.Recruiter;
import fr.fc.proemploi.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recruiter")

public class RecruiterResource {
    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<Recruiter> CreateRecruiters(@RequestBody Recruiter recruiter) {
        Recruiter savedRecruiter =recruiterService.saveRecruiter(recruiter);
        return ResponseEntity.ok(savedRecruiter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> GetRecruiterById(@PathVariable("id") Long id) {
        Optional<Recruiter> recruiter = recruiterService.getRecruiterById(id);
        return recruiter.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<Recruiter> GetAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteRecruiterById(@PathVariable("id") Long id) {
        Optional<Recruiter> recruiter = recruiterService.getRecruiterById(id);
        if (recruiter.isPresent()) {
            recruiterService.deleteRecruiter(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
