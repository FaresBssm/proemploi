package fr.fc.proemploi.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Data

public class Technology {

    @Id

    private Long id;
    private String name;

    @OneToMany(mappedBy = "technology")
    private List<Candidat> candidats;


}
