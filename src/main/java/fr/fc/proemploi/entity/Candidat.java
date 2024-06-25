package fr.fc.proemploi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Data
public class Candidat {

    @Id

    private Long id;
    private Blob cv;
    private Blob motivationLetter;
    private String linkedinProfile;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime inscriptionDate;
}
