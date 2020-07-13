package udemy.planete;

/**
 * 
 * @author Jordan
 *
 */
public abstract class Planete {
	private String nom;
    private int diametre;
    
    private Atmosphere atmosphere;
    
    private static String forme="Sphérique";
    private static int nbPlanetesDecouvertes;
    
    Planete(String nom){
        this.nom=nom;
        nbPlanetesDecouvertes++;
    }
    
    
    public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getDiametre() {
		return diametre;
	}


	public void setDiametre(int diametre) {
		this.diametre = diametre;
	}


	public Atmosphere getAtmosphere() {
		return atmosphere;
	}


	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}


	public static String getForme() {
		return forme;
	}


	public static void setForme(String forme) {
		Planete.forme = forme;
	}


	public static int getNbPlanetesDecouvertes() {
		return nbPlanetesDecouvertes;
	}


	public static void setNbPlanetesDecouvertes(int nbPlanetesDecouvertes) {
		Planete.nbPlanetesDecouvertes = nbPlanetesDecouvertes;
	}


	int revolution(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile de "+degres+" degrés.");
        return degres/360;
    }
    
    int rotation(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne sur moi-même de "+degres+" degrés.");
        return degres/360;
    }
    
    
    
    static String expansion (double milliardsDAnneesLumiere){
        if (milliardsDAnneesLumiere < 14){
            return "Oh la la mais c'est super rapide !";
        }
        else {
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }
}
