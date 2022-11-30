package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.TpAchatProjectApplication;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)
public class FactureServiceImplTest {
	
	 private SecteurActivite activite1 = new SecteurActivite((long) 1, "11111","BUREATIQUE",null);
	private SecteurActivite  activite2 = new SecteurActivite((long) 2, "11111","BUREATIQUE",null); 
	 @Mock
	SecteurActiviteRepository secteurRepository;
	
	@InjectMocks
	SecteurActiviteServiceImpl secteurService;
	
	//SecteurActivite s = new SecteurActivite(Long.valueOf(1), "11111","BUREATIQUE",null);
	  // List<SecteurActivite> listSecteurActivites = new ArrayList<SecteurActivite>(){
	    //    {
	      //      add( new SecteurActivite(Long.valueOf(2), "11111","BUREATIQUE",null));
	        //    add( new SecteurActivite(Long.valueOf(3), "11111","BUREATIQUE",null));
	        //}
	     
	    //};
	   
	@Test
	@Order(1)
	public void testRetrieveSecteurActivite() {	
	when(secteurRepository.findById(activite1.getIdSecteurActivite())).thenReturn(Optional.of(activite1));
	assertEquals(activite1, secteurService.retrieveSecteurActivite(activite1.getIdSecteurActivite()));
	System.out.println("retrieveSecteur works !");
	}
	
	@Test
	@Order(2)
	public void testAddSecteurActivite() throws ParseException
	{
		when(secteurRepository.save(activite1)).thenReturn(activite1);
     assertNotNull(activite1);
     SecteurActivite persisted = secteurService.addSecteurActivite(activite1);
		assertEquals(activite1, persisted);
     
		System.out.println("AddSecteur works !");
	}
	
	@Test
	@Order(3)
	public void testRetrieveAllSecteurActivite()
	{
		when(secteurRepository.findAll()).thenReturn(Stream.of(activite1, activite2).collect(Collectors.toList()));
		assertEquals(2, secteurService.retrieveAllSecteurActivite().size());
		System.out.println("retrieveAllReglements works !");
	}
	
	/*@Test
	@Order(4)
    public void testdeleteSecteurActivite() {
		SecteurActivite s2 = new SecteurActivite(Long.valueOf(4), "11111","BUREATIQUE",null);
		SecteurService.deleteSecteurActivite(s2.getIdSecteurActivite());
       Mockito.verify(SecteurRepository).deleteById(s2.getIdSecteurActivite());
       System.out.println("ok");
   }*/
	
	  @Test
		@Order(4)
	    public void testUpdateSecteurActivite() {
		  when(secteurRepository.save(activite1)).thenReturn(activite1);
	    	assertNotNull(activite1);
	    	assertEquals(activite1, secteurService.updateSecteurActivite(activite1));
	    	System.out.println("Update produit works!");
	    }
}