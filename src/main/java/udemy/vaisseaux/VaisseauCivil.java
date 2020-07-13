package udemy.vaisseaux;

/**
 * 
 * @author Jordan
 *
 */
public class VaisseauCivil extends Vaisseau {

    public VaisseauCivil(TypeVaisseauEnum type) {
        this.type = type;
        if (type == TypeVaisseauEnum.CARGO) {
        	VaisseauCivil.tonnageMax = 500;
        } else if (type == TypeVaisseauEnum.VAISSEAUMONDE) {
            tonnageMax = 2000;
        }

    }

    public int emporterCargaison(int tonnage) {
        int tonnageRestant = tonnageMax - tonnageActuel;
        if (tonnage > tonnageRestant) {
            tonnageActuel = tonnageMax;
            return tonnage-tonnageRestant;
        }
        tonnageActuel+=tonnage;
        return 0;
    }

}

