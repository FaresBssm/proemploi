package fr.fc.proemploi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Blob;

@Entity
@Data

public class Candidat extends Utilisateur {
    @Id
    long idCandidate;
    private Blob cv;
    private Blob lettreMotivation;
    private String profilLinkein;

}
