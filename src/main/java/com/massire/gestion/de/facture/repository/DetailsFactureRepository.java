package com.massire.gestion.de.facture.repository;

import com.massire.gestion.de.facture.entities.DetailsFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsFactureRepository extends JpaRepository<DetailsFacture,Long> {
}
