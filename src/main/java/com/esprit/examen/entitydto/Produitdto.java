package com.esprit.examen.entitydto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Produitdto {
  Long idProduit;
     String codeProduit;
    String libelleProduit;
    float prix;
    @Temporal(TemporalType.DATE)
     Date dateCreation;
    @Temporal(TemporalType.DATE)
     Date dateDerniereModification;
}
