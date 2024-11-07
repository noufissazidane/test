package com.exemple.devoirlibre;

import java.util.ArrayList;
import java.util.List;

public class client {
	
    private int numClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTel;
    private String email;
    private List<compte> comptes;
    
    
    
	public client(int numClient, String nom, String prenom, String adresse, String numeroTel, String email,
			List<compte> comptes) {
		
		super();
		this.numClient = numClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.email = email;
		this.comptes = new ArrayList<>();
		
	}
	
	
	 // Ajouter un compte pour le client
    public void ajouterCompte(compte compte) {
        if (!comptes.contains(compte)) {
            comptes.add(compte);
            compte.setClient(this); // Lie le compte au client
        }
    }
    

    // Supprimer un compte
    public void supprimerCompte(compte compte) {
        comptes.remove(compte);
        compte.setClient(null); // Dissocie le compte du client
        
    }
    
    
    
    
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<compte> comptes) {
		this.comptes = comptes;
	}
    
    

}
