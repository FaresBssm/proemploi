package fr.fc.proemploi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class Utilisateur {
    @Id
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Date dateInsecrption;

}
