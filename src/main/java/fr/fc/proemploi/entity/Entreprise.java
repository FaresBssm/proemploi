package fr.fc.proemploi.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Entreprise {

    @Id
    private Long id;
    private String name;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "Recrutements",
            joinColumns = @JoinColumn(name = "entreprise_id"),
            inverseJoinColumns = @JoinColumn(name = "recruiter_id")
    )
    private List<Recruiter> recruiterList;
    @OneToMany(mappedBy="entreprise")
    private List<Proposal> proposals;
}
