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
    	getSimulatedvoyageur().takePicture(actuelle);
    	getSimulatedvoyageur().takeEchantillonSol(actuelle);
    	getSimulatedvoyageur().takeEchantillonRoche(actuelle);
        while (alreadyVisit.size() != this.listPlanete.size()) {
        	ArrayList<Planete> visitPossible = actuelle.getListAccessibilite();
        	ArrayList<Planete> vuePossible = actuelle.getListAccessibilite();
        	for ( Planete in : alreadyVisit ) {
        		visitPossible.remove(in);
        		vuePossible.remove(in);
        	}
        	for (Planete in : visitPossible ) {
        		vuePossible.remove(in);
        		if (in.getEchantillonSol()==null) {
        			getSimulatedvoyageur().takePicture(in);
                    alreadyVisit.add(in);
        		}
        	}
        	for (Planete vu : vuePossible ) {
        		if (vu.getEchantillonSol()==null) {
            		getSimulatedvoyageur().takePicture(vu);
                    alreadyVisit.add(vu);
        		}
        	}
            Planete prochaine = visitPossible.get(0);
            int distance = (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX())*(prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX())+(prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY())*(prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY());
            for(Planete at : visitPossible ) {
            	int distat = (at.getPos().getX()-getSimulatedvoyageur().getPosTete().getX())*(at.getPos().getX()-getSimulatedvoyageur().getPosTete().getX())+(at.getPos().getY()-getSimulatedvoyageur().getPosTete().getY())*(at.getPos().getY()-getSimulatedvoyageur().getPosTete().getY());
            	if (distat < distance) {
            		prochaine = at;
            		distance = distat;
            	}
            }
            wait(10);
            if (getSimulatedvoyageur().getDirection()=="E") {
            	if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>0) {
            		int Y = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = Y; i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
            	} else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                	int Y = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = prochaine.getPos().getY(); i<Y-1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	int X = getSimulatedvoyageur().getPosTete().getX();
                	for (int i = X; i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                	int X = getSimulatedvoyageur().getPosTete().getX();
                    for (int i = prochaine.getPos().getX(); i<X+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            } else if (getSimulatedvoyageur().getDirection()=="W") {
            	if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()<0) {
            		int Y = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = prochaine.getPos().getY(); i<Y+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                	int Y = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = Y; i<prochaine.getPos().getY()-1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()<0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	int X = getSimulatedvoyageur().getPosTete().getX();
                	for (int i = prochaine.getPos().getX(); i<X+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                	int X = getSimulatedvoyageur().getPosTete().getX();
                    for (int i = X; i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            } else if (getSimulatedvoyageur().getDirection()=="N") {
            	if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()<0) {
            		int X = getSimulatedvoyageur().getPosTete().getX();
                	for (int i = prochaine.getPos().getX(); i<X+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                	int X = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = X; i<prochaine.getPos().getX()-1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            	if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	int Y = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = Y; i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                	int Y = getSimulatedvoyageur().getPosTete().getY();
                    for (int i = prochaine.getPos().getY(); i<Y+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            } else if (getSimulatedvoyageur().getDirection()=="S") {
            	if (prochaine.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>0) {
            		int X = getSimulatedvoyageur().getPosTete().getX();
                	for (int i = X; i<prochaine.getPos().getX()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                	int X = getSimulatedvoyageur().getPosTete().getX();
                	for (int i = prochaine.getPos().getX(); i<X-1; i++){
                    	getSimulatedvoyageur().goBackward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
                if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()<0) {
                    getSimulatedvoyageur().turnRight();
                    wait(200);
                	afficheEcran();
                	int Y = getSimulatedvoyageur().getPosTete().getY();
                	for (int i = prochaine.getPos().getY(); i<Y+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                	}
                } else if (prochaine.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                } else {
                    getSimulatedvoyageur().turnLeft();
                    wait(200);
                	afficheEcran();
                	int Y = getSimulatedvoyageur().getPosTete().getY();
                    for (int i = Y; i<prochaine.getPos().getY()+1; i++){
                    	getSimulatedvoyageur().goForward();
                    	wait(200);
                    	afficheEcran();
                    }
                }
            }
            wait(1000);
            if (getSimulatedvoyageur().getPosBody().getX()==prochaine.getPos().getX() && getSimulatedvoyageur().getPosBody().getY()==prochaine.getPos().getY()) {
            	if (alreadyVisit.contains(prochaine)) {
            	} else {
                	getSimulatedvoyageur().takePicture(prochaine);
                	getSimulatedvoyageur().takeEchantillonSol(prochaine);
                	getSimulatedvoyageur().takeEchantillonRoche(prochaine);
                	wait(500);
                	alreadyVisit.add(prochaine);
            	}
                actuelle = prochaine;
            }
            wait(10);
        }
    }
}