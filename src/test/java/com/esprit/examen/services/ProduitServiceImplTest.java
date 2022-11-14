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
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
//@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProduitServiceImplTest {
	

	@InjectMocks
	ProduitServiceImpl produitService;
	
	@InjectMocks
	StockServiceImpl stockService;
	
	
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
    @Mock
    private ProduitRepository produitRepository;
    private StockRepository stockRepository;
    
    private Produit produit1 = new Produit(null,"777434","libbPorduit", 10, new Date(), new Date(),null,null,null);
    private Produit produit2 = new Produit(null,"777434","libbPorduit", 10, new Date(), new Date(),null,null,null);
	
    private Stock stock = new Stock(Long.valueOf(1), "f1", 10, 5, null);
    
    @Test 
	 void testRetrieveAllProduits() {
	    	when(produitRepository.findAll()).thenReturn(Stream
	    			.of(produit1,produit2)
	    			.collect(Collectors.toList()));
	    	
	    	assertEquals(2,produitService.retrieveAllProduits().size());
	    	System.out.println("Retrieve all Produit works !");
	    }
    
	@Test 
	void testAddProduit() {
    	when(produitRepository.save(produit1)).thenReturn(produit1);
    	assertNotNull(produit1);
    	
    	Produit p = produitService.addProduit(produit1);
		assertEquals(produit1, p); 
    	
		System.out.println("add product works !");
	} 
	
	  @Test 
	   void testDeleteProduit() {
		  produitService.deleteProduit(produit1.getIdProduit());
		  Mockito.verify(produitRepository).deleteById(produit1.getIdProduit());
		  System.out.println("deleted");
	    }
	
	
	
	   @Test 
	   void testUpdateProduit() {
	    	when(produitRepository.save(produit1)).thenReturn(produit1);
	    	assertNotNull(produit1);
	    	assertEquals(produit1, produitService.updateProduit(produit1));
	    	System.out.println("Update produit works!");
	    }
	    
	    @Test
	    void testRetrieveProduit() {
	    	when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));
	    	assertEquals(produit1, produitService.retrieveProduit(produit1.getIdProduit()));
	    	System.out.println("Retrieve product by id works !");
	    }
	    
//	    @Test 
//		   void testAssignProduitToStock() {
//	    	when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));
//	    	assertEquals(produit1, produitService.retrieveProduit(produit1.getIdProduit()));
//	    	when(stockRepository.findById(stock.getIdStock())).thenReturn(stock);
//			  assertNotNull(produit1);
//			  ((ProduitServiceImpl) Mockito.verify(produitRepository)).assignProduitToStock(produit1.getIdProduit(),stock.getIdStock());
//			  System.out.println("deleted");
//		    }
	  

    
	
}