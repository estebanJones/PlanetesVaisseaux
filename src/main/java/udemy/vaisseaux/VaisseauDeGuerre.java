package udemy.vaisseaux;

/**
 * 
 * @author Jordan
 *
 */
public class VaisseauDeGuerre extends Vaisseau {
    boolean armesDesactivees;

    public VaisseauDeGuerre(TypeVaisseauEnum type){
        this.type=type;
        if (type==TypeVaisseauEnum.CHASSEUR){
            tonnageMax=0;
        }
        else if (type==TypeVaisseauEnum.FREGATE){
            tonnageMax=50;
        }
        else if (type==TypeVaisseauEnum.CROISEUR){
            tonnageMax=100;
        }
        
    }
    
    /**
     * Attaque avec un VaisseauDeGuerre une cible
     * @param Vaisseau vaisseauCible
     * @param String arme
     * @param int duree
     */
    public void attaque(Vaisseau vaisseauCible, String arme, int duree) {
        if (armesDesactivees) {
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + type.nom + " attaque un vaisseau de type " + vaisseauCible.type.nom + " en utilisant l'arme " + arme + " pendant " + duree + " minutes.");
            vaisseauCible.setResistanceDuBouclier(0);
            vaisseauCible.setBlindage(vaisseauCible.getBlindage() / 2);
        }
    }
    
    /**
     * Désactive les armes du vaisseau de guerre
     */
    public void desactiverArmes() {
        System.out.println("Désactivation des armes d'un vaisseau de type " + type.nom);
        armesDesactivees = true;
    }
    
    /**
     * Active le bouclier du vaiseau de guerre
     */
    @Override
    public void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type.nom+".");
        desactiverArmes();
    }
    
    /**
     * Transporte une cargaison
     * @param int cargaison
     * return int
     */
    @Override
    public int emporterCargaison(int cargaison){
	    if (type==TypeVaisseauEnum.CHASSEUR){
            return cargaison;
        }
        else {
            if (nbPassagers<12){
                return cargaison;
            }
            else {
                int tonnagePassagers=nbPassagers*2;
                int tonnageRestant=tonnageMax-tonnageActuel;
                int tonnageAConsiderer=(tonnagePassagers<tonnageRestant ? tonnagePassagers : tonnageRestant);
                if (cargaison>tonnageAConsiderer){
                    tonnageActuel=tonnageMax;
                    return cargaison-tonnageAConsiderer;
                }
                else {
                    tonnageActuel+=cargaison;
                    return 0;
                }
            }
        }
    }
}
