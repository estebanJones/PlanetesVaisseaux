package udemy.planete;

import udemy.vaisseaux.Vaisseau;

/**
 * 
 * @author Jordan
 *
 */
public interface IHabitable {
	/**
	 * Accueille un tableau de vaiseaux sur une planète tellurique
	 * @param nouveauVaisseau
	 * @return int
	 */
	public int accueillirVaisseau(Vaisseau... nouveauVaisseau);
	/**
	 * Verifie si des places sur la baie de la planètes sont disponibles
	 * @return boolean
	 */
	public boolean restePlaceDisponible();
}
