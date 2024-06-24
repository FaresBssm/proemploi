package fr.fc.proemploi.entity;

import jakarta.persistence.Entity;

@Entity

public class Recreteur extends Utilisateur {
    private long id ;
    private long id_entreprise ;

}
