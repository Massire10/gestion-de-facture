package com.massire.gestion.de.facture.repository;

import com.massire.gestion.de.facture.entities.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterielRepository extends JpaRepository<Materiel,Long> {
    Optional<Materiel> findMaterielByCode(String code);
}
