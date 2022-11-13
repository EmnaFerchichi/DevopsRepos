package com.esprit.examen.entitydto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class FactureDto {
     Long idFacture;
  float montantRemise;
     float montantFacture;
    @Temporal(TemporalType.DATE)
     Date dateCreationFacture;
    @Temporal(TemporalType.DATE)
     Date dateDerniereModificationFacture;
     Boolean archivee;
}
