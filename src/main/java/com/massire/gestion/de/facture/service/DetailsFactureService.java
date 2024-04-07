package com.massire.gestion.de.facture.service;

import com.massire.gestion.de.facture.entities.DetailsFacture;
import com.massire.gestion.de.facture.repository.DetailsFactureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsFactureService {

    private final DetailsFactureRepository detailsFactureRepository;

    public DetailsFactureService(DetailsFactureRepository detailsFactureRepository) {
        this.detailsFactureRepository = detailsFactureRepository;
    }

    public List<DetailsFacture> getAllDetails(){
        return this.detailsFactureRepository.findAll();
    }

    public void addDetails(DetailsFacture detailsFacture){
        detailsFactureRepository.save(detailsFacture);
    }

    /* Ici, on fait une modification partielle en occurence le champ quantité.
    L'annotation transactional assure que les modifications sont effectuées
    dans le cadre d'une transaction.*/
    @Transactional
    public DetailsFacture update(DetailsFacture detailsFacture,Long id){
        DetailsFacture detailsFacture1 = this.detailsFactureRepository.getReferenceById(id);
        detailsFacture1.setQuantite(detailsFacture.getQuantite());
        return detailsFacture1;
    }

    public void delete(Long id){
        detailsFactureRepository.deleteById(id);
    }
}
