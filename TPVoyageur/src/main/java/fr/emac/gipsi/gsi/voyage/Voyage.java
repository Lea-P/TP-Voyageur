/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

import java.util.ArrayList;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub
        afficheEcran();
        Planete actuelle = this.listPlanete.get(0);
        ArrayList<Planete> alreadyVisit = new ArrayList<Planete>();
        alreadyVisit.add(actuelle);
        while (alreadyVisit != this.listPlanete) {
            Planete prochaine = actuelle.getListAccessibilite().get(0);
            int distance = (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX())^2-(prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY());
            for(Planete at : actuelle.getListAccessibilite() ) {
            	int distat = (at.getPos().getX()-getSimulatedvoyageur().getPosTete().getX())^2-(at.getPos().getY()-getSimulatedvoyageur().getPosTete().getY())^2;
            	if (distat<0) {
            		distat=-distat;
            	}
            	if (distance<0) {
            		distance=-distance;
            	}
            	if (distat >= distance || alreadyVisit.contains(at)) {
            	} else {
            		prochaine = at;
            		distance = distat;
            	}
            }
            wait(10);
            if (getSimulatedvoyageur().getDirection()=="E" && getSimulatedvoyageur().getPosBody().getY()!=prochaine.getPos().getY()) {
            	if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>=0) {
                	for (int i = getSimulatedvoyageur().getPosTete().getY(); i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else {
                	for (int i = prochaine.getPos().getY(); i<getSimulatedvoyageur().getPosTete().getY()+1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	for (int i = getSimulatedvoyageur().getPosTete().getX(); i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                    for (int i = prochaine.getPos().getX(); i<getSimulatedvoyageur().getPosTete().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            }
            if (getSimulatedvoyageur().getDirection()=="W" && getSimulatedvoyageur().getPosBody().getY()!=prochaine.getPos().getY()) {
            	if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>=0) {
                	for (int i = getSimulatedvoyageur().getPosTete().getY(); i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else {
                	for (int i = prochaine.getPos().getY(); i<getSimulatedvoyageur().getPosTete().getY()+1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	for (int i = getSimulatedvoyageur().getPosTete().getX(); i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                    for (int i = prochaine.getPos().getX(); i<getSimulatedvoyageur().getPosTete().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            }
            if (getSimulatedvoyageur().getDirection()=="N" && getSimulatedvoyageur().getPosBody().getX()!=prochaine.getPos().getX()) {
            	if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>=0) {
                	for (int i = getSimulatedvoyageur().getPosTete().getX(); i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else {
                	for (int i = prochaine.getPos().getX(); i<getSimulatedvoyageur().getPosTete().getX()+1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	for (int i = getSimulatedvoyageur().getPosTete().getY(); i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                    for (int i = prochaine.getPos().getY(); i<getSimulatedvoyageur().getPosTete().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            }
            if (getSimulatedvoyageur().getDirection()=="S" && getSimulatedvoyageur().getPosBody().getX()!=prochaine.getPos().getX()) {
            	if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>=0) {
                	for (int i = getSimulatedvoyageur().getPosTete().getX(); i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else {
                	for (int i = prochaine.getPos().getX(); i<getSimulatedvoyageur().getPosTete().getX()+1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()<0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	for (int i = getSimulatedvoyageur().getPosTete().getY(); i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                    for (int i = getSimulatedvoyageur().getPosTete().getY(); i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            }
            wait(2000);
            if (getSimulatedvoyageur().getPosBody().getX()==prochaine.getPos().getX() && getSimulatedvoyageur().getPosBody().getY()==prochaine.getPos().getY()) {
            	alreadyVisit.add(prochaine);
                actuelle = prochaine;
            }
            wait(10);
        }
    }
}
