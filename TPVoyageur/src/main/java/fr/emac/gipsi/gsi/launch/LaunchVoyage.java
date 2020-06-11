package fr.emac.gipsi.gsi.launch;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.voyage.Planete;
import fr.emac.gipsi.gsi.voyage.Voyage;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.VoyageurSimuler;

public class LaunchVoyage {

    public static void main(String[] args) {
        ArrayList<Planete> listPlanete = new ArrayList<>();

        Planete p1 = new Planete();
        p1.setColorName("DarkSalmon");
        p1.setEchantillonRoche(new Screen());
        p1.setEchantillonSol(new Screen());
        p1.setRayon(0);
        p1.getPos().setX(2);
        p1.getPos().setY(2);
        listPlanete.add(p1);

        Planete p2 = new Planete();
        p2.setColorName("DeepPink");
        p2.setEchantillonRoche(new Screen());
        p2.setRayon(0);
        p2.getPos().setX(3);
        p2.getPos().setY(4);
        listPlanete.add(p2);

        Planete p3 = new Planete();
        p3.setColorName("DeepPink");
        p3.setEchantillonRoche(new Screen());
        p3.setRayon(0);
        p3.getPos().setX(6);
        p3.getPos().setY(7);
        listPlanete.add(p3);
        
        Planete p4 = new Planete();
        p4.setColorName("DeepPink");
        p4.setEchantillonRoche(new Screen());
        p4.setRayon(0);
        p4.getPos().setX(2);
        p4.getPos().setY(8);
        listPlanete.add(p4);
        
        Planete p5 = new Planete();
        listPlanete.add(p5);

        p1.getListAccessibilite().add(p2);
        p2.getListAccessibilite().add(p1);
        p2.getListAccessibilite().add(p3);
        p3.getListAccessibilite().add(p2);
        p3.getListAccessibilite().add(p4);
        p4.getListAccessibilite().add(p3);
        
        AbstractVoyageur simulatedVoyageur = new VoyageurSimuler(); // voyageur qui va faire le parcours
        
        simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
        simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY());
        simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX()-1);
        simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY());
        simulatedVoyageur.setDirection("S");
        
        Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);

        voyage.lancementSimuler();
    }
}