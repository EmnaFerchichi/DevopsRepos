package com.esprit.examen.entitydto;

import com.esprit.examen.entities.CategorieFournisseur;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class Fournisseurdto {
     Long idFournisseur;
     String code;
     String libelle;
    @Enumerated(EnumType.STRING)
     CategorieFournisseur categorieFournisseur;

}
