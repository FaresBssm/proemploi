package fr.fc.proemploi.repository;

import fr.fc.proemploi.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepoitory extends JpaRepository<Recruiter, Long> {
}
