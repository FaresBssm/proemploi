package fr.fc.proemploi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Recruiter extends Utilisateur {


    @Id
    private Long id;
    @ManyToMany(mappedBy = "recruiterList")
    private List<Entreprise> entrepriseList;

}
