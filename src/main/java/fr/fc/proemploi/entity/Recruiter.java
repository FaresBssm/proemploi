package fr.fc.proemploi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Recruiter {


    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime inscriptionDate;
    @ManyToMany(mappedBy = "recruiterList")
    private List<Entreprise> entrepriseList;


}
