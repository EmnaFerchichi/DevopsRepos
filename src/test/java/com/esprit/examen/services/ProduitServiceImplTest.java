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
//@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProduitServiceImplTest {
	
	public ProduitServiceImplTest() {
		// TODO Auto-generated constructor stub
	} 
	@InjectMocks
	ProduitServiceImpl produitService;
	
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	
	
    @Mock
    private ProduitRepository produitRepository;
    
    private Produit produit1 = new Produit(null,"777434","libbPorduit", 10, new Date(), new Date(),null,null,null);
    private Produit produit2 = new Produit(null,"777434","libbPorduit", 10, new Date(), new Date(),null,null,null);
	
	
	@Test 
	public void addProductTest() {
    	when(produitRepository.save(produit1)).thenReturn(produit1);
    	assertNotNull(produit1);
    	
    	Produit persisted = produitService.addProduit(produit1);
		assertEquals(produit1, persisted); 
    	
		System.out.println("add product works !");
	} 
	
	 @Test 
	    public void retrieveaallProductTest() {
	    	when(produitRepository.findAll()).thenReturn(Stream
	    			.of(produit1,produit2)
	    			.collect(Collectors.toList()));
	    	
	    	assertEquals(2,produitService.retrieveAllProduits().size());
	    	System.out.println("Retrieve all Produit works !");
	    }
	
	   @Test 
	    public void UpdateProductTest() {
	    	when(produitRepository.save(produit1)).thenReturn(produit1);
	    	assertNotNull(produit1);
	    	assertEquals(produit1, produitService.updateProduit(produit1));
	    	System.out.println("Update produit works!");
	    }
	    
	    @Test
	    public void retrieveProductTest() {
	    	when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));
	    	assertEquals(produit1, produitService.retrieveProduit(produit1.getIdProduit()));
	    	System.out.println("Retrieve product by id works !");
	    }

    
	
}
