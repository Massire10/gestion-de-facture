package com.massire.gestion.de.facture.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "details_facture")

/*Cette annotation permet simplement d'ignorer la sérialisation
des propriétés spécifiques à Hibernatelors de la conversion de
votre entité en JSON*/
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetailsFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "facture_id", nullable = false)
    private Facture facture;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "materiel_id", nullable = false)
    private Materiel materiel;


}
