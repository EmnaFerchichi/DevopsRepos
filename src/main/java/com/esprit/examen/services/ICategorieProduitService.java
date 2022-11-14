package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.CategorieProduit;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();


	void deleteCategorieProduit(Long id);

	CategorieProduit updateCategorieProduit(CategorieProduit cp);

	CategorieProduit retrieveCategorieProduit(Long id);

}
