package fr.fc.proemploi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.awt.*;

@Entity
@Data

public class Entreprise {

    @Id

    private long id;
    private String nom;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
    private String discription;
}
