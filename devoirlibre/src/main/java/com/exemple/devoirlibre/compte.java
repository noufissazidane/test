package com.exemple.devoirlibre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class compte {
	
    private int numCompte;
    private LocalDate dateCreation;
    private LocalDate dateUpdate;
    private String devise;
    private client client;
    private banque banque;
    private List<transaction> transactions;
    private double solde;
    
    
    
	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public compte(int numCompte, LocalDate dateCreation, LocalDate dateUpdate, String devise,
			com.exemple.devoirlibre.client client, com.exemple.devoirlibre.banque banque,
			List<transaction> transactions, double solde) {
		super();
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.devise = devise;
		this.client = client;
		this.banque = banque;
		this.transactions = new ArrayList<>();
		this.solde =solde;
	}
	
	
	// Méthode pour effectuer un dépôt
    public void depot(double montant) {
        if (montant > 0) {
            solde += montant;
            dateUpdate = LocalDate.now();
            System.out.println("Dépôt de " + montant + " " + devise + " effectué. Nouveau solde: " + solde + " " + devise);
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    // Méthode pour effectuer un retrait
    public void retrait(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            dateUpdate = LocalDate.now();
            System.out.println("Retrait de " + montant + " " + devise + " effectué. Nouveau solde: " + solde + " " + devise);
        } else {
            System.out.println("Montant de retrait invalide ou solde insuffisant.");
        }
    }
	
	   // Ajouter une transaction
    public void ajouterTransaction(transaction transaction) {
        transactions.add(transaction);
    }
    

    

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDate getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDate dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public client getClient() {
		return client;
	}

	public void setClient(client client) {
		this.client = client;
	}

	public banque getBanque() {
		return banque;
	}

	public void setBanque(banque banque) {
		this.banque = banque;
	}

	public List<transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<transaction> transactions) {
		this.transactions = transactions;
	}


}
