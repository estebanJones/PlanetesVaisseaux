package udemy.vaisseaux;

/**
 * 
 * @author Jordan
 *
 */
public abstract class Vaisseau {
    TypeVaisseauEnum type;
    protected int nbPassagers;
    private int resistanceDuBouclier;
    private int blindage;
    protected static int tonnageMax;
    protected int tonnageActuel;
    
    
    private TypeVaisseauEnum getType() {
		return type;
	}

	public void setType(TypeVaisseauEnum type) {
		this.type = type;
	}

	public int getNbPassagers() {
		return nbPassagers;
	}

	public void setNbPassagers(int nbPassagers) {
		this.nbPassagers = nbPassagers;
	}

	public int getResistanceDuBouclier() {
		return resistanceDuBouclier;
	}

	public void setResistanceDuBouclier(int resistanceDuBouclier) {
		this.resistanceDuBouclier = resistanceDuBouclier;
	}

	public int getBlindage() {
		return blindage;
	}

	public void setBlindage(int blindage) {
		this.blindage = blindage;
	}

	public int getTonnageMax() {
		return tonnageMax;
	}

	public void setTonnageMax(int tonnageMax) {
		this.tonnageMax = tonnageMax;
	}

	public int getTonnageActuel() {
		return tonnageActuel;
	}

	public void setTonnageActuel(int tonnageActuel) {
		this.tonnageActuel = tonnageActuel;
	}

	/**
     * Active le bouclier du vaisseau
     */
    public void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type.nom+".");
    }
    
    /**
     * Desactive le bouclier du vaisseau
     */
    public void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+type.nom+".");
    }
    
    /**
     * Transporte une cargaison
     * @param int tonnage
     * @return int
     */
    public abstract int emporterCargaison(int tonnage);
    
}
