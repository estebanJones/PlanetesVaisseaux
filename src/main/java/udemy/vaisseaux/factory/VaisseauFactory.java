package udemy.vaisseaux.factory;

import udemy.CreationVaisseauException;
import udemy.vaisseaux.TypeVaisseauEnum;
import udemy.vaisseaux.Vaisseau;
import udemy.vaisseaux.VaisseauCivil;
import udemy.vaisseaux.VaisseauDeGuerre;

/**
 * Factory de vaisseau selon son TypeVaisseauEnum
 * @author Jordan
 *
 */
public class VaisseauFactory {
	/**
	 * 
	 * @param TypeVaisseauEnum type
	 * @return Vaisseau
	 * @throws Exception
	 */
	public Vaisseau create(TypeVaisseauEnum type) throws Exception {
		switch (type) {
	        case CHASSEUR:
	            return new VaisseauDeGuerre(type);
			case FREGATE:
	        	return new VaisseauDeGuerre(type);
	        case CROISEUR:
	        	return new VaisseauDeGuerre(type);
	        case CARGO:
	        	return new VaisseauCivil(type);
	        case VAISSEAUMONDE:
	        	return new VaisseauCivil(type);
	        default:
	        	throw new CreationVaisseauException("fais belek");
		}
	}
}
