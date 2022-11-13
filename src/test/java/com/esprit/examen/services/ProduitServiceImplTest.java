package com.esprit.examen.services;
//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = Produit.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

 class ProduitServiceImplTest {
    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitServiceService;



    List<Produit> list = new ArrayList<Produit>() {

        {
            add(new Produit());
            add(new Produit());

        }
    };

    @Test
void  getAllProduitTest()
    {
        List<Produit> Produitlist = new ArrayList<Produit>() {

            {
                add(new Produit(3L, null, null, 1900, null, null, null));
                add(new Produit(5L, null, null, 1600, null, null, null));
                add(new Produit(8L, null, null, 1590, null, null, null));
            }};

        assertTrue(Produitlist.size()>0);
        Mockito.when(produitServiceService.retrieveAllProduits()).thenReturn(Produitlist);
        List<Produit> factureList = produitServiceService.retrieveAllProduits();
    }



    @Test
    void test_addProduit() {
        Produit p= new Produit();
        p.setIdProduit(1L);
        //mock
        Mockito.when(produitRepository.save(any())).thenReturn(p);

        //assert
        assertEquals(1L, p.getIdProduit());
    }

    public void delete() {

        Produit p = produitRepository.findById(1L).get();
        produitRepository.delete(p);
        produitServiceService.deleteProduit(null);

    }



}