package br.com.vieiradev.apiCadastroAtletas.controller;

import br.com.vieiradev.apiCadastroAtletas.model.Athlete;
import br.com.vieiradev.apiCadastroAtletas.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/athlete")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping
    public List<Athlete> getAll() {
        return athleteService.getAll();
    }

    @GetMapping("/{id}")
    public Athlete getById(@PathVariable Long id) {
        return athleteService.getById(id);
    }

    @PostMapping
    public Athlete save(@RequestBody Athlete athlete) {
        return athleteService.save(athlete);
    }

    @PutMapping("/{id}")
    public Athlete update(@PathVariable Long id, @RequestBody Athlete athlete) {
        return athleteService.update(id, athlete);
    }

    @PatchMapping("/{id}")
    public Athlete patch(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return athleteService.patch(id, fields);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Athlete athlete = athleteService.getById(id);
        athleteService.deleteAthlete(id);
        return ResponseEntity.ok("Usuário " + athlete.getName() + " excluído com sucesso!");
    }

}
