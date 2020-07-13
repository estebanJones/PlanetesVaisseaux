package udemy;

import java.util.Scanner;

import udemy.planete.PlaneteGazeuse;
import udemy.planete.PlaneteTellurique;
import udemy.vaisseaux.TypeVaisseauEnum;
import udemy.vaisseaux.Vaisseau;
import udemy.vaisseaux.VaisseauCivil;
import udemy.vaisseaux.VaisseauDeGuerre;

public class HelloUniverse {

	public static void main(String[] args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 3);
        mercure.setDiametre(4880);
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 0);
        venus.setDiametre(12100);
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 2);
        terre.setDiametre(12756);
        PlaneteTellurique mars = new PlaneteTellurique("Mars", 1);
        mars.setDiametre(6792);
        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.setDiametre(142984);
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.setDiametre(120536); 
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.setDiametre(51118);
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.setDiametre(49532);

        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseauEnum.CHASSEUR);
        chasseur.setNbPassagers(3);
        chasseur.setBlindage(156);
        chasseur.setResistanceDuBouclier(2);

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseauEnum.CROISEUR);
        croiseur.setNbPassagers(35);
        croiseur.setBlindage(851);
        croiseur.setResistanceDuBouclier(25);

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseauEnum.FREGATE);
        fregate.setNbPassagers(100);
        fregate.setBlindage(542);
        fregate.setResistanceDuBouclier(50);

        Vaisseau cargo = new VaisseauCivil(TypeVaisseauEnum.CARGO);
        cargo.setNbPassagers(10000);
        cargo.setBlindage(1520);
        cargo.setResistanceDuBouclier(20);

        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseauEnum.VAISSEAUMONDE);
        vaisseauMonde.setNbPassagers(10000);
        vaisseauMonde.setBlindage(4784);
        vaisseauMonde.setResistanceDuBouclier(30);
        Integer reload = 0;
        
        do {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Quel vaisseau souhaitez vous manipuler​ : "+TypeVaisseauEnum.CHASSEUR.name()+", "+TypeVaisseauEnum.FREGATE.name()+", "+TypeVaisseauEnum.CROISEUR.name()+", "+TypeVaisseauEnum.CARGO.name()+" ou "+TypeVaisseauEnum.VAISSEAUMONDE.name()+" ?");
	        String typeVaisseauString = sc.nextLine();
	        TypeVaisseauEnum typeVaisseau=TypeVaisseauEnum.valueOf(typeVaisseauString);
	        Vaisseau vaisseauSelectionne = null;
	        switch (typeVaisseau) {
	            case CHASSEUR:
	                vaisseauSelectionne = chasseur;
	                break;
	            case FREGATE:
	                vaisseauSelectionne = fregate;
	                break;
	            case CROISEUR:
	                vaisseauSelectionne = croiseur;
	                break;
	            case CARGO:
	                vaisseauSelectionne = cargo;
	                break;
	            case VAISSEAUMONDE:
	                vaisseauSelectionne = vaisseauMonde;
	                break;
	        }
	
	        System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser : Mercure, Venus, Terre ou Mars ?");
	        String nomPlanete = sc.nextLine();
	        PlaneteTellurique planeteSelectionnee = null;
	        switch (nomPlanete) {
	            case "Mercure":
	                planeteSelectionnee = mercure;
	                break;
	            case "Venus":
	                planeteSelectionnee = venus;
	                break;
	            case "Terre":
	                planeteSelectionnee = terre;
	                break;
	            case "Mars":
	                planeteSelectionnee = mars;
	                break;
	
	        }
	
	        System.out.println("Quel tonnage souhaitez-vous emporter ?");
	        int tonnageSouhaite = sc.nextInt();
	        
	        Vaisseau[] vaisseauSelectionnes = { vaisseauMonde, cargo, croiseur};
	        planeteSelectionnee.accueillirVaisseau(vaisseauSelectionnes);
	        System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
	        
	        System.out.println("Voulez-vous recommencer 1-Oui 2-Non");
	        sc.nextLine();
	        reload = sc.nextInt();
	        
        }while(reload.equals(1));
        
    }

}
