package fr.fc.proemploi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Proposal {

    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDateTime publicationDate;
    @ManyToOne
    @JoinColumn(name="entreprise_id", nullable=false)
    private Entreprise entreprise;
    @OneToMany(mappedBy="proposal")
    private List<Candidature> candidatureList;
}
