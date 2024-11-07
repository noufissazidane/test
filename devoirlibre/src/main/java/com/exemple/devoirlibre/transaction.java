package com.exemple.devoirlibre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class transaction {
	
    private TypeTrans transaction;
    private LocalDateTime time;
    private String reference;
    private double solde;
    private double montant;
    private List<compte> compte;
    private banque banque;


	
    
    public transaction(TypeTrans transaction, LocalDateTime time, String reference, double solde, double montant,
			List<com.exemple.devoirlibre.compte> compte, com.exemple.devoirlibre.banque banque) {
		super();
		this.transaction = transaction;
		this.time = time;
		this.reference = reference;
		this.solde = solde;
		this.montant = montant;
		this.compte = compte;
		this.banque = banque;
	}
    
    
    public transaction(LocalDateTime time, double solde,
			List<com.exemple.devoirlibre.compte> compte, com.exemple.devoirlibre.banque banque) {
		super();
		this.transaction = verifierTypeTransaction(compte);
		this.time = time;
		this.reference = genererReference();
		this.solde = solde;
		this.montant = calculerMontant();
		this.compte = compte;
		this.banque = banque;
	}

	// Méthode pour générer une référence aléatoire
    public String genererReference() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder ref = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            ref.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return ref.toString();
    }

    // Méthode pour déterminer automatiquement le type de transaction
    public TypeTrans verifierTypeTransaction(List<compte> comptes) {
        if (comptes.size() == 2) {
            compte compte1 = comptes.get(0);
            compte compte2 = comptes.get(1);
            
            if (compte1.getBanque().equals(compte2.getBanque()) &&
                compte1.getBanque().getPays().equals(compte2.getBanque().getPays())) {
                this.transaction= TypeTrans.VIRIN;
            } else if (!compte1.getBanque().equals(compte2.getBanque()) && compte1.getBanque().getPays().equals(compte2.getBanque().getPays())) {
                this.transaction=TypeTrans.VIREST;
            } else if (!compte1.getBanque().equals(compte2.getBanque()) &&
                       !compte1.getBanque().getPays().equals(compte2.getBanque().getPays())) {
                this.transaction= TypeTrans.VIRCHAR;
            }
        } else if (comptes.size() > 2) {
            boolean memeBanqueEtPays = comptes.stream()
                    .allMatch(c -> c.getBanque().equals(comptes.get(0).getBanque()) &&
                                   c.getBanque().getPays().equals(comptes.get(0).getBanque().getPays()));
            
            if (memeBanqueEtPays) {
                this.transaction= TypeTrans.VIRMULTA;
            }
        }
        
        
        return this.transaction;
    }
    
    
    // Méthode pour vérifier si le solde du compte est suffisant
    /*public boolean verifierSolde(compte compteSource) {
        double frais = calculerFrais();
        return compteSource.getSolde() >= (montant + frais);
    }*/
    
    
 // Méthode pour calculer le montant de la transaction
    public double calculerFrais() {
        double frais = 0.0;
        
        switch (this.transaction) {
            case VIRIN:
                frais = 0.0; // Pas de frais
                break;
            case VIREST:
                frais = 10.0; // Frais de 10 DH
                break;
            case VIRCHAR:
                // Frais selon le pays ; ici, un exemple de frais par défaut (modifiez selon vos besoins)
                frais = calculerFraisSelonPays();
                break;
            case VIRMULTA:
                frais = 0.0; // Pas de frais car même banque et même pays
                break;
        }
        
        return frais;
    }
    
    // Méthode pour calculer le montant total de la transaction
    public double calculerMontant() {
        return montant + calculerFrais();
    }

    // Méthode pour calculer les frais de VIRCHAR selon le pays
    public double calculerFraisSelonPays() {
        // Exemple basique de frais selon le pays de la banque
        String pays = compte.get(0).getBanque().getPays();  // On suppose que tous les comptes sont dans le même pays
        
        switch (pays) {
            case "Maroc":
                return 20.0;
            case "France":
                return 15.0;
            case "USA":
                return 25.0;
            default:
                return 30.0; // Frais par défaut pour d'autres pays
        }
    }
    
 // Méthode pour vérifier le solde et effectuer la transaction
    public boolean verifierSoldeEtEffectuerTransaction() {
        compte compteSource = compte.get(0);
        compte compteDestination = compte.get(1);

        double frais = calculerFrais();
        double montantTotal = montant + frais;

        if (compteSource.getSolde() >= montantTotal) {
            transfererMontant(compteSource, compteDestination, montantTotal);
            return true;
        } else {
            System.out.println("Solde insuffisant pour effectuer la transaction.");
            return false;
        }
    }

    // Méthode pour effectuer le transfert d'un compte source à un compte destination
    public void transfererMontant(compte compteSource, compte compteDestination, double montantTotal) {
        compteSource.setSolde(compteSource.getSolde() - montantTotal);
        compteDestination.setSolde(compteDestination.getSolde() + montant);
        System.out.println("Transaction effectuée : " + montant + " transféré de " +
                           compteSource.getNumCompte() + " à " + compteDestination.getNumCompte());
    }

	public TypeTrans getTransaction() {
		return transaction;
	}

	public void setTransaction(TypeTrans transaction) {
		this.transaction = transaction;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<compte> getCompte() {
		return compte;
	}

	public void setCompte(List<compte> compte) {
		this.compte = compte;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	public banque getBanque() {
		return banque;
	}
	public void setBanque(banque banque) {
		this.banque = banque;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
    
    
    
    


}
