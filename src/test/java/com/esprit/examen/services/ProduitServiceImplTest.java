package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
@ExtendWith(SpringExtension.class)
public class ProduitServiceImplTest {
	
	public ProduitServiceImplTest() {
	} 
	@InjectMocks
	ProduitServiceImpl produitService;
	
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	
	
    @Mock
    private ProduitRepository produitRepository;
    
    private Produit prod1 = new Produit(null,"125784","libelleProd1", 12, new Date(), new Date(),null,null,null);
    private Produit prod2 = new Produit(null,"365425","libelleProd2", 12, new Date(), new Date(),null,null,null);
	
	
	@Test 
	public void addProductTest() {
    	when(produitRepository.save(prod1)).thenReturn(prod1);
    	assertNotNull(prod1);
    	
    	Produit persisted = produitService.addProduit(prod1);
		assertEquals(prod1, persisted); 
    	
		System.out.println("add product fonctionne!");
	} 
	
	 @Test 
	    public void retrieveaallProductTest() {
	    	when(produitRepository.findAll()).thenReturn(Stream
	    			.of(prod1,prod2)
	    			.collect(Collectors.toList()));
	    	
	    	assertEquals(2,produitService.retrieveAllProduits().size());
	    	System.out.println("Retrieve all Products fonctionne!");
	    }
	
	   @Test 
	    public void UpdateProductTest() {
	    	when(produitRepository.save(prod1)).thenReturn(prod1);
	    	assertNotNull(prod1);
	    	assertEquals(prod1, produitService.updateProduit(prod1));
	    	System.out.println("Update produit fonctionne!");
	    }
	    
	    @Test
	    public void retrieveProductTest() {
	    	when(produitRepository.findById(prod1.getIdProduit())).thenReturn(Optional.of(prod1));
	    	assertEquals(prod1, produitService.retrieveProduit(prod1.getIdProduit()));
	    	System.out.println("Retrieve product by id fonctionne!");
	    }

    
	
}
