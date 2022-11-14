package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFactures();


	Facture addFacture(Facture f);

	void cancelFacture(Long id);

	Facture retrieveFacture(Long id);
	


}
