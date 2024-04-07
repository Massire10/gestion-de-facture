package com.massire.gestion.de.facture.controller;

import com.massire.gestion.de.facture.entities.DetailsFacture;
import com.massire.gestion.de.facture.entities.Facture;
import com.massire.gestion.de.facture.service.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "mass/api")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }
    @GetMapping(value = "/factures")
    public ResponseEntity<List<Facture>> getFactures(){
        List<Facture> factures = factureService.getAllFacture();
        return new ResponseEntity<>(factures,HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public void save(@RequestBody Facture facture){
        factureService.saveFacture(facture);
    }

    @DeleteMapping(value = "/factures/{id}")
    public void delete(@PathVariable Long id){
        factureService.delete(id);
    }
    @PutMapping(value = "/update")
    public ResponseEntity<Facture> update(@RequestBody Facture facture){
        Facture facture1 = this.factureService.update(facture);
        return new ResponseEntity<>(facture1,HttpStatus.OK);

    }
    @GetMapping(value = "/calculFactures")
    public double calculMontantTotal(){
        double result = 0.0;

        result = factureService.calculMontantTotal();

        return result;
    }

    @GetMapping(value = "/calculFacture")
    public List<Double> calculMontantFacture(){

        List<Double> montants = new ArrayList<>();

        montants = factureService.calculMontantFacture();

        return montants;
    }

    @GetMapping(value = "/facture/{id}")
    public Optional<Facture> findById(@PathVariable Long id){
      return  factureService.findById(id);
    }

}
