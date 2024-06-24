package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Entreprise;
import fr.fc.proemploi.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/entreprise")

public class EntrepriseResource {
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @GetMapping
    public List<Entreprise> getEntreprises() {
        return entrepriseRepository.findAll();

    }

}
