package com.massire.gestion.de.facture.controller;

import com.massire.gestion.de.facture.entities.Materiel;
import com.massire.gestion.de.facture.service.MaterielService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/materiel")
public class MaterielController {

    private final MaterielService materielService;

    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping(value = "/materiels")
    public ResponseEntity<List<Materiel>> allMateriels(){
        List<Materiel> materiels = materielService.getAllMateriels();
        return new ResponseEntity<>(materiels, HttpStatus.OK);
    }

    @PostMapping(value = "/addM")
    public void addMateriel(@RequestBody Materiel materiel){
        materielService.addMateriel(materiel);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Materiel> update(@RequestBody Materiel materiel){
        Materiel materiel1 = materielService.updateMateriel(materiel);
        return new ResponseEntity<>(materiel1,HttpStatus.OK);
    }

    @DeleteMapping(value = "/materiel/{id}")
    public void delete(@PathVariable Long id){
        materielService.delete(id);
    }
}
