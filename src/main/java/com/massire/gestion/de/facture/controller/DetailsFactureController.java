package com.massire.gestion.de.facture.controller;

import com.massire.gestion.de.facture.entities.DetailsFacture;
import com.massire.gestion.de.facture.service.DetailsFactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/details")
public class DetailsFactureController {

    private final DetailsFactureService detailsFactureService;

    public DetailsFactureController(DetailsFactureService detailsFactureService) {
        this.detailsFactureService = detailsFactureService;

    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<DetailsFacture>> getAll(){
        List<DetailsFacture> list = this.detailsFactureService.getAllDetails();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public void add(@RequestBody DetailsFacture detailsFacture){

        detailsFactureService.addDetails(detailsFacture);
    }
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<DetailsFacture> update( @RequestBody DetailsFacture detailsFacture,
                                                  @PathVariable Long id){
        DetailsFacture detailsFacture1 = this.detailsFactureService.update(detailsFacture,id);

        return new ResponseEntity<>(detailsFacture1,HttpStatus.OK);
    }
    @DeleteMapping(value = "/all/{id}")
    public void delete(@PathVariable Long id){
        detailsFactureService.delete(id);
    }
}
