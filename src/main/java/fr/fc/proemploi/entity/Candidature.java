package fr.fc.proemploi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Candidature {

    @Id
    private Long id;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private CandidatureStatus status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidat_id", referencedColumnName = "id")
    private Candidat candidate;

    @ManyToOne
    @JoinColumn(name = "proposal_id", nullable = false)
    private Proposal proposal;

}
