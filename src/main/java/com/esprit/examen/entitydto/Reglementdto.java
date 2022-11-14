package com.esprit.examen.entitydto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Reglementdto {
    Long idReglement;
    float montantPaye;
     float montantRestant;
    Boolean payee;
    @Temporal(TemporalType.DATE)
     Date dateReglement;
}
