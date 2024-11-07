package com.exemple.devoirlibre;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Création des banques
        banque banqueMaroc = new banque(1, "Maroc", new ArrayList<>());
        banque banqueMaroc2 = new banque(1, "Maroc", new ArrayList<>());
        banque banqueFrance = new banque(2, "France", new ArrayList<>());
        
        // Création de clients
        client client1 = new client(1, "Ahmed", "El Moutaouakil", "Adresse 1", "0600000001", "ahmed@exemple.com", new ArrayList<>());
        client client2 = new client(2, "Pierre", "Dupont", "Adresse 2", "0600000002", "pierre@exemple.com", new ArrayList<>());

        // Création des comptes
        compte compte1 = new compte(101, LocalDate.now(), LocalDate.now(), "DH", client1, banqueMaroc, new ArrayList<>(), 1000.0);
        compte compte2 = new compte(102, LocalDate.now(), LocalDate.now(), "DH", client2, banqueMaroc, new ArrayList<>(), 500.0);
        compte compte3 = new compte(103, LocalDate.now(), LocalDate.now(), "EUR", client1, banqueFrance, new ArrayList<>(), 1500.0);
        compte compte4 = new compte(104, LocalDate.now(), LocalDate.now(), "DH", client1, banqueMaroc2, new ArrayList<>(), 1000.0);

        // Ajout des comptes aux clients et banques
        client1.ajouterCompte(compte1);
        client2.ajouterCompte(compte2);
        client1.ajouterCompte(compte3);
        
        banqueMaroc.ajouterCompte(compte1);
        banqueMaroc2.ajouterCompte(compte4);
        banqueMaroc.ajouterCompte(compte2);
        banqueFrance.ajouterCompte(compte3);
        

        // Vérification du type VIRIN (même banque, même pays)
        System.out.println("Test de transaction VIRIN (même banque, même pays) :");
        List<compte> comptesVIRIN = List.of(compte1, compte2);
        transaction transactionVIRIN = new transaction(LocalDateTime.now(), compte1.getSolde(), comptesVIRIN, banqueMaroc);
        transactionVIRIN.verifierSoldeEtEffectuerTransaction();
        
        // Vérification du type VIREST (banques différentes, même pays)
        System.out.println("\nTest de transaction VIREST (banques différentes, même pays) :");
        List<compte> comptesVIREST = List.of(compte1, compte3);
        transaction transactionVIREST = new transaction(LocalDateTime.now(), compte1.getSolde(), comptesVIREST, banqueMaroc);
        transactionVIREST.verifierSoldeEtEffectuerTransaction();

        // Vérification du type VIRCHAR (banques et pays différents)
        System.out.println("\nTest de transaction VIRCHAR (banques et pays différents) :");
        List<compte> comptesVIRCHAR = List.of(compte1, compte3);
        compte3.getBanque().setPays("USA"); // Changer le pays de la banque de compte3 pour USA
        transaction transactionVIRCHAR = new transaction(LocalDateTime.now(), compte1.getSolde(), comptesVIRCHAR, banqueMaroc);
        transactionVIRCHAR.verifierSoldeEtEffectuerTransaction();

        // Vérification du type VIRMULTA (plusieurs comptes, même banque et même pays)
        System.out.println("\nTest de transaction VIRMULTA (plusieurs comptes, même banque et même pays) :");
        compte compte5 = new compte(105, LocalDate.now(), LocalDate.now(), "DH", client1, banqueMaroc, new ArrayList<>(), 2000.0);
        banqueMaroc.ajouterCompte(compte4);
        List<compte> comptesVIRMULTA = List.of(compte1, compte2, compte4);
        transaction transactionVIRMULTA = new transaction(LocalDateTime.now(), compte1.getSolde(), comptesVIRMULTA, banqueMaroc);
        transactionVIRMULTA.verifierSoldeEtEffectuerTransaction();
    }
}
