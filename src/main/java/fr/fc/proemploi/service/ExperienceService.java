package fr.fc.proemploi.service;

import fr.fc.proemploi.entity.Experience;
import fr.fc.proemploi.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public void deleteExperienceById(Long id) {
        experienceRepository.deleteById(id);
    }
}
