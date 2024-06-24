package fr.fc.proemploi.resources;

import fr.fc.proemploi.entity.Utilisateur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/utilisateur")

public class UtilisateurResource {


    @GetMapping
    public List<Utilisateur> getutilisateur() {
        return null;
    }
}
