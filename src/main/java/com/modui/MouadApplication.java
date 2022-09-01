package com.modui;

import com.modui.dao.ProduitRepository;
import com.modui.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MouadApplication implements CommandLineRunner {


    @Autowired
    private ProduitRepository produitRepository;

    public static void main(String[] args) {

        SpringApplication.run(MouadApplication.class, args);
    }


    @Override
    public void run(String... args) {

        produitRepository.save( new Produit(null,"PC850",6000,12 ));
        produitRepository.save( new Produit(null,"IMPRIMANTE",6000,12 ));
        produitRepository.save( new Produit(null,"LIIIL",6000,12 ));
        produitRepository.findAll().forEach(p ->{

            System.out.println(p.getDesignation());
            System.out.println(p.getPrix());
            System.out.println(p.getId());
        } );

    }
}
