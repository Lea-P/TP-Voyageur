package fr.emac.gipsi.gsi.launch;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.ecran.ListScreen;
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
        p1.setImage(ListScreen.typeDark());
        p1.setEchantillonRoche(ListScreen.evoli());
        p1.setEchantillonSol(ListScreen.Noctali());
        p1.setRayon(1);
        p1.getPos().setX(5);
        p1.getPos().setY(5);
        listPlanete.add(p1);

        Planete p2 = new Planete();
        p2.setColorName("DeepPink");
        p2.setImage(ListScreen.typeFairy());
        p2.setEchantillonRoche(ListScreen.evoli());
        p2.setEchantillonSol(ListScreen.nymphali());
        p2.setRayon(1);
        p2.getPos().setX(15);
        p2.getPos().setY(20);
        listPlanete.add(p2);

        Planete p3 = new Planete();
        p3.setColorName("DeepPink");
        p3.setImage(ListScreen.typeWater());
        p3.setEchantillonRoche(ListScreen.aquali());
        p3.setRayon(1);
        p3.getPos().setX(30);
        p3.getPos().setY(35);
        listPlanete.add(p3);
        
        Planete p4 = new Planete();
        p4.setColorName("DeepPink");
        p4.setImage(ListScreen.typeFire());
        p4.setEchantillonRoche(ListScreen.Pyroli());
        p4.setRayon(1);
        p4.getPos().setX(15);
        p4.getPos().setY(5);
        listPlanete.add(p4);
        
        Planete p5 = new Planete();
        p5.setColorName("DeepPink");
        p5.setImage(ListScreen.typeGrass());
        p5.setEchantillonRoche(ListScreen.phyllali());
        p5.setRayon(1);
        p5.getPos().setX(40);
        p5.getPos().setY(35);
        listPlanete.add(p5);
        
        Planete p6 = new Planete();
        p6.setColorName("DeepPink");
        p6.setImage(ListScreen.typePsychic());
        p6.setEchantillonRoche(ListScreen.mentali());
        p6.setRayon(1);
        p6.getPos().setX(30);
        p6.getPos().setY(40);
        listPlanete.add(p6);
        
        p1.getListAccessibilite().add(p2);
        p2.getListAccessibilite().add(p1);
        p2.getListAccessibilite().add(p3);
        p3.getListAccessibilite().add(p2);
        p2.getListAccessibilite().add(p4);
        p4.getListAccessibilite().add(p2);
        p3.getListAccessibilite().add(p5);
        p5.getListAccessibilite().add(p3);
        p5.getListAccessibilite().add(p6);
        p6.getListAccessibilite().add(p5);

        
        p1.getListVisibilite().add(p2);
        p2.getListVisibilite().add(p1);
        p2.getListVisibilite().add(p3);
        p3.getListVisibilite().add(p2);
        p2.getListVisibilite().add(p4);
        p4.getListVisibilite().add(p2);
        
        AbstractVoyageur simulatedVoyageur = new VoyageurSimuler(); // voyageur qui va faire le parcours
        
        simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
        simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY()+1);
        simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX());
        simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY());
        simulatedVoyageur.setDirection("E");
        
        Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);

        voyage.lancementSimuler();
    }
}