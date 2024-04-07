package com.massire.gestion.de.facture.repository;

import com.massire.gestion.de.facture.entities.DetailsFacture;
import com.massire.gestion.de.facture.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface FactureRepository extends JpaRepository<Facture,Long> {

   Optional<Facture> findFactureByCode(String code);


}
