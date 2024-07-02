package fr.fc.proemploi.repository;


import fr.fc.proemploi.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Ejb3TransactionAnnotationParser;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    List<Candidat> findByTechnologyName(String technologyName);
    List<Candidat> findByExperience(Long experience);

}
