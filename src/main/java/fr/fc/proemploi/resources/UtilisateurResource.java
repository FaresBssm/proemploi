package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Utilisateur;
import fr.fc.proemploi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/utilisateur")

public class UtilisateurResource {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getutilisateur() {
        return utilisateurRepository.findAll();
    }
}
