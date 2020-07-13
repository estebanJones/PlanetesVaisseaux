package udemy.planete;

import udemy.vaisseaux.Vaisseau;
import udemy.vaisseaux.VaisseauDeGuerre;

/**
 * 
 * @author Jordan
 *
 */
public class PlaneteTellurique extends Planete implements IHabitable{
    
    int vaisseauxAccostes;
    boolean restePlaceDisponible;
    int totalVisiteurs;
    Vaisseau[] baieAccostage;
    private int placeDisponible = 0;
    
    public PlaneteTellurique(String nom, int tailleDeLaBaie) {
        super(nom);
        this.baieAccostage = new Vaisseau[tailleDeLaBaie];
    }
    
    @Override
    public int accueillirVaisseau(Vaisseau... nouveauVaisseau){
    	if(this.restePlaceDisponible() == true) {
	    	this.ajoutVaisseauDansBaie(nouveauVaisseau);
	    }
    	else {
    		System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie");
    		this.placeDisponible = 0;
    	}
        
         return this.vaisseauxAccostes;
    }
    
    @Override
	public boolean restePlaceDisponible() {
    	boolean placeDisponible = false;
        for(int i=0; i < this.baieAccostage.length; i++) {
        	if (this.baieAccostage[i] == null) {
        		placeDisponible = true;
        	} 
        }

        return placeDisponible; 	        	    
    }
    
    private void ajoutVaisseauDansBaie(Vaisseau... nouveauVaisseau) {
    	for(int i=0; i < nouveauVaisseau.length; i++) {
    		this.controleDesactivationArmes(nouveauVaisseau[i]);
    		this.ajoutTotalVisiteur(nouveauVaisseau[i]);
    		
    		if(this.baieAccostage[0] == null) {
    			this.baieAccostage[0] = nouveauVaisseau[i];
    			this.placeDisponible = this.baieAccostage.length - 1;
    		}
    		else {
    			for(int j=0; j < this.baieAccostage.length; j++) {
    				// DETERMINE LA PLACE DISPONIBLE ENTRE LA PREMIERE EXCLUS ET LA DERNIERE EXCLUS
    				// SI LA PLACE EST LIBRE MAIS LA PLACE D AVANT OCCUPEE
    				if (this.baieAccostage[j] == null && this.baieAccostage[j - 1] != null) {
    					this.baieAccostage[j] = nouveauVaisseau[j];
    					this.placeDisponible = this.baieAccostage.length - j;
    				} 
    				// SI LA DERNIERE PLACE EST LIBRE MAIS L AVANT DERNIERE PRISE ALORS
    				else if(this.baieAccostage[this.baieAccostage.length - 1] == null &&  this.baieAccostage[this.baieAccostage.length - 2] != null){
    					this.baieAccostage[this.baieAccostage.length] = nouveauVaisseau[j];
    				} 
    			}
    			
    		}
    	}
    }
    
    private void controleDesactivationArmes(Vaisseau vaisseau) {
    	if (vaisseau instanceof VaisseauDeGuerre)
			((VaisseauDeGuerre)vaisseau).desactiverArmes();
    }
    
    private void ajoutTotalVisiteur(Vaisseau vaisseau) {
    	vaisseau.setNbPassagers(this.totalVisiteurs += vaisseau.getNbPassagers());;
    }
    
}
