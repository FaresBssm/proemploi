package fr.fc.proemploi.repository;


import fr.fc.proemploi.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Ejb3TransactionAnnotationParser;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
