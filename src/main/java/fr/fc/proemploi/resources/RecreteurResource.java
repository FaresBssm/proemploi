package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Recreteur;
import fr.fc.proemploi.repository.RecreteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recreteur")


public class RecreteurResource {
    @Autowired
    private RecreteurRepository recreteurRepository;
    @GetMapping
    List<Recreteur> listaRecreteur() {
        return recreteurRepository.findAll();
    }
}

