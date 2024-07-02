package fr.fc.proemploi.service;

import fr.fc.proemploi.entity.Technology;
import fr.fc.proemploi.repository.TechnologyRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TechnologyService {
    @Autowired
    private TechnologyRepoitory technologyRepoitory;

    public List<Technology> findAll() {
        return technologyRepoitory.findAll();
    }

    public Optional<Technology> findById(Long id) {
        return technologyRepoitory.findById(id);
    }

    public Technology save(Technology technology) {
        return technologyRepoitory.save(technology);
    }

    public void deleteById(Long id) {
        technologyRepoitory.deleteById(id);
    }

}
