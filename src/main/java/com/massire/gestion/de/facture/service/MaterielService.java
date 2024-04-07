package com.massire.gestion.de.facture.service;

import com.massire.gestion.de.facture.entities.Materiel;
import com.massire.gestion.de.facture.repository.MaterielRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterielService {

    private final MaterielRepository materielRepository;

    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    public List<Materiel> getAllMateriels(){
        return materielRepository.findAll();
    }

    public void addMateriel(Materiel materiel){
        Optional<Materiel> optionalMateriel = materielRepository.findMaterielByCode(materiel.getCode());
        if (optionalMateriel.isPresent()){
            throw new IllegalArgumentException("Le code est déjà présent!");
        }

        materielRepository.save(materiel);
    }

    public Materiel updateMateriel(Materiel materiel){
        return materielRepository.save(materiel);
    }

    public void delete(Long id){
        materielRepository.deleteById(id);
    }
}
