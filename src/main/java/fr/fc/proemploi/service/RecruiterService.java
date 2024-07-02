package fr.fc.proemploi.service;

import fr.fc.proemploi.entity.Recruiter;
import fr.fc.proemploi.repository.RecruiterRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepoitory recruiterRepoitory;

    public Recruiter saveRecruiter(Recruiter recruiter) {
        return recruiterRepoitory.save(recruiter);
    }

    public Optional<Recruiter> getRecruiterById(Long id) {
        return recruiterRepoitory.findById(id);
    }
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepoitory.findAll();
    }
    public void deleteRecruiter(Long id) {
        recruiterRepoitory.deleteById(id);
    }

}
