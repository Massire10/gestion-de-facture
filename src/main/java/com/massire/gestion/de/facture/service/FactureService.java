package com.massire.gestion.de.facture.service;

import com.massire.gestion.de.facture.entities.DetailsFacture;
import com.massire.gestion.de.facture.entities.Facture;
import com.massire.gestion.de.facture.repository.DetailsFactureRepository;
import com.massire.gestion.de.facture.repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class FactureService {
    private final FactureRepository factureRepository;
    private final DetailsFactureRepository detailsFactureRepository;
    private List<DetailsFacture> detailsFacture;

    public FactureService(FactureRepository factureRepository,
                          DetailsFactureRepository detailsFactureRepository) {
        this.factureRepository = factureRepository;
        this.detailsFactureRepository = detailsFactureRepository;
        this.detailsFacture = new ArrayList<>();
    }

    public List<Facture> getAllFacture(){
        return factureRepository.findAll();
    }

    public void saveFacture( Facture facture){
        Optional<Facture> factureOptional = this.factureRepository.findFactureByCode(facture.getCode());
        if(factureOptional.isPresent()){
            throw new IllegalArgumentException("Le code est déjà présent!");
        }
        factureRepository.save(facture);
    }

    public void delete(Long id){
        factureRepository.deleteById(id);
    }

    public Facture update(Facture facture){
        Facture facture1 =  this.factureRepository.save(facture);
        return facture1;
    }

    public double calculMontantTotal(){

        double montantTotal = 0.0;

        // Nous récupérons les détails de facture depuis la base de données
        List<DetailsFacture> detailsFacture = detailsFactureRepository.findAll();

        for(DetailsFacture df : detailsFacture){
            montantTotal += df.getQuantite() * df.getMateriel().getPrix();
        }

        return montantTotal;

    }
}
