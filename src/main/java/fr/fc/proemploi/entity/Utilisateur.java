package fr.fc.proemploi.entity;


import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utilisateur {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime inscriptionDate;

}
