package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Candidat;
import fr.fc.proemploi.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate")
public class CandidatResource {
    @Autowired
    private CandidatRepository candidatRepository;

    @GetMapping
    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }
}
