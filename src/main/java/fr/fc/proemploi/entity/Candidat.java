package fr.fc.proemploi.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime inscriptionDate;

    @OneToMany(mappedBy = "candidat",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Experience> experiences;

}
