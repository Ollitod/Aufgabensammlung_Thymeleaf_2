package at.htlstp.tod.aufgabensammlung.mvc.bsp2.repository;

import at.htlstp.tod.aufgabensammlung.mvc.bsp2.model.Schueler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchuelerRepository extends JpaRepository<Schueler, Integer> {

    @Query("select distinct s.klasse from Schueler s order by s.klasse asc")
    List<String> getAllKlassen();

    List<Schueler> findByKlasse(String klasse);

    @Query("select max(s.kn) from Schueler s where s.klasse = ?1")
    Integer getLastKatNrInKlasse(String klasse);
}
