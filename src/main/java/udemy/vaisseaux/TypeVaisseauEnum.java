package udemy.vaisseaux;

/**
 * 
 * @author Jordan
 *
 */
public enum TypeVaisseauEnum {
	  CHASSEUR("Chasseur"), 
	  FREGATE("Frégate"), 
	  CROISEUR("Croiseur"), 
	  CARGO("Cargo"), 
	  VAISSEAUMONDE("Vaisseau-Monde");
	
    protected String nom;

    TypeVaisseauEnum(String nom) {
        this.nom = nom;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
    
}
