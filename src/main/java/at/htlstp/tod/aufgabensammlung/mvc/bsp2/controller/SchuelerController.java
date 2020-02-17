package at.htlstp.tod.aufgabensammlung.mvc.bsp2.controller;

import at.htlstp.tod.aufgabensammlung.mvc.bsp2.model.Klasse;
import at.htlstp.tod.aufgabensammlung.mvc.bsp2.model.Schueler;
import at.htlstp.tod.aufgabensammlung.mvc.bsp2.repository.SchuelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@SessionAttributes({"klassen", "geschlecht"})
public class SchuelerController {

    @Autowired
    private SchuelerRepository schuelerRepo;

    @GetMapping("/welcomepage")
    public String getWelcomepage(Model model) {
        model.addAttribute("klassen", schuelerRepo.getAllKlassen());
        model.addAttribute("klasseObj", new Klasse());
        return "schueler";
    }

    @PostMapping("/load-schueler")
    public String selectKlasse(@Valid @ModelAttribute("klasseObj") Klasse klasse, BindingResult results, Model model) {
        model.addAttribute("schuelerInKlasse", schuelerRepo.findByKlasse(klasse.getKlasse()));
        return "schueler";
    }

    @GetMapping("/add-schueler")
    public String addSchueler(Model model) {
        Schueler s = new Schueler();
        s.setKlasse("4AHIF");
        s.setGeschlecht('M');
        model.addAttribute("schueler", s);
        model.addAttribute("klassen", schuelerRepo.getAllKlassen());
        model.addAttribute("geschlecht", Arrays.asList("Männlich", "Weiblich"));
        return "add-schueler";
    }

    @PostMapping("/add-schueler")
    public String addSchueler(@Valid Schueler schueler, BindingResult results, Model model) {
        if (results.hasErrors()) {
            return "add-schueler";
        }
        schueler.setKn(schuelerRepo.getLastKatNrInKlasse(schueler.getKlasse()) + 1);
        schuelerRepo.save(schueler);
        return "redirect:/welcomepage";
    }
}
