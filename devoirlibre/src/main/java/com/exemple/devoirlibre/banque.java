package com.exemple.devoirlibre;

import java.util.List;

public class banque {
	
    private int id;
    private String pays;
    private List<compte> comptes;
    
	public banque(int id, String pays, List<compte> comptes) {
		super();
		this.id = id;
		this.pays = pays;
		this.comptes = comptes;
	}
	
	   // Ajouter un compte à la banque
    public void ajouterCompte(compte compte) {
        comptes.add(compte);
        compte.setBanque(this); // Associe la banque au compte
    }

    // Supprimer un compte de la banque
    public void supprimerCompte(compte compte) {
        comptes.remove(compte);
        compte.setBanque(null); // Dissocie la banque du compte
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public List<compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<compte> comptes) {
		this.comptes = comptes;
	}
    
    
	

}
