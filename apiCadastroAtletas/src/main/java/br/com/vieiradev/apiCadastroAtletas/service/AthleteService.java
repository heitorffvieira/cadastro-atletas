package br.com.vieiradev.apiCadastroAtletas.service;

import br.com.vieiradev.apiCadastroAtletas.exception.AthleteException;
import br.com.vieiradev.apiCadastroAtletas.model.Athlete;
import br.com.vieiradev.apiCadastroAtletas.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public List<Athlete> getAll() {
        return athleteRepository.findAll();
    }

    public Athlete getById(Long id) {
        return findAthleteOrThrow(id);
    }

    public Athlete save(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public Athlete update(Long id, Athlete athlete) {
        findAthleteOrThrow(id);
        athlete.setId(id);
        return athleteRepository.save(athlete);
    }

    public Athlete patch(Long id, Map<String, Object> fields) {
        Athlete athlete = findAthleteOrThrow(id);

        fields.forEach((key, value) -> {
            switch (key) {
                case "name" -> athlete.setName((String) value);
                case "age" -> athlete.setAge((Integer) value);
                case "size" -> athlete.setSizeShirt((String) value);
            }
        });

        return athleteRepository.save(athlete);
    }

    public void deleteAthlete(Long id) {
        findAthleteOrThrow(id);
        athleteRepository.deleteById(id);
    }

    private Athlete findAthleteOrThrow(Long id) {
        return athleteRepository.findById(id).orElseThrow(AthleteException::new);
    }

}
