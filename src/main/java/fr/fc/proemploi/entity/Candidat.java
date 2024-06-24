package fr.fc.proemploi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Blob;

@Entity
@Data
public class Candidat extends Utilisateur {

    @Id
    private Long id;
    private Blob cv;
    private Blob motivationLetter;
    private String linkedinProfile;

}
