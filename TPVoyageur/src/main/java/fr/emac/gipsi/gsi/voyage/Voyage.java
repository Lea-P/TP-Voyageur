/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationHorizontale;
import fr.emac.gipsi.gsi.animation.AnimationRideau;
import fr.emac.gipsi.gsi.animation.AnimationShrink;
import fr.emac.gipsi.gsi.animation.AnimationSpirale;
import fr.emac.gipsi.gsi.animation.AnimationSpirale2;
import fr.emac.gipsi.gsi.animation.AnimationSplit;
import fr.emac.gipsi.gsi.animation.AnimationVerticale;
import fr.emac.gipsi.gsi.ecran.ListScreen;
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
        afficheEcran();
        Planete actuelle = new Planete();
        for (Planete all : listPlanete) {
        	if (getSimulatedvoyageur().getPosBody().getX()==all.getPos().getX() && getSimulatedvoyageur().getPosBody().getY()==all.getPos().getY()) {
                actuelle = all;
        	}
        }
        ArrayList<Planete> alreadyVisit = new ArrayList<Planete>();
        alreadyVisit.add(actuelle);
        if (actuelle.getEchantillonSol()==null) {
			getSimulatedvoyageur().takePicture(actuelle);
        	afficheEcran();
    		AbstractAnimation a = new AnimationRideau();
    		a.setEcranDeb(ListScreen.Black());
    		a.setEcranFin(actuelle.getImage());
    		a.wait(1000);
    		a.runAnimation();
    		AbstractAnimation aa = new AnimationRideau();
    		aa.setEcranDeb(actuelle.getImage());
    		aa.setEcranFin(ListScreen.Black());
    		aa.wait(1000);
    		aa.runAnimation();
		} else {
			getSimulatedvoyageur().takePicture(actuelle);
        	getSimulatedvoyageur().takeEchantillonSol(actuelle);
        	getSimulatedvoyageur().takeEchantillonRoche(actuelle);
        	afficheEcran();
    		AbstractAnimation a = new AnimationShrink();
    		a.setEcranDeb(ListScreen.Black());
    		a.setEcranFin(actuelle.getImage());
    		a.wait(1000);
    		a.runAnimation();
    		AbstractAnimation aa = new AnimationShrink();
    		aa.setEcranDeb(actuelle.getImage());
    		aa.setEcranFin(ListScreen.Black());
    		aa.wait(1000);
    		aa.runAnimation();
    		AbstractAnimation ab = new AnimationVerticale();
    		ab.setEcranDeb(ListScreen.Black());
    		ab.setEcranFin(actuelle.getEchantillonSol());
    		ab.wait(1000);
    		ab.runAnimation();
    		AbstractAnimation ac = new AnimationVerticale();
    		ac.setEcranDeb(actuelle.getEchantillonSol());
    		ac.setEcranFin(ListScreen.Black());
    		ac.wait(1000);
    		ac.runAnimation();
    		if (actuelle.getEchantillonRoche()!=null) {
        		AbstractAnimation ad = new AnimationHorizontale();
        		ad.setEcranDeb(ListScreen.Black());
        		ad.setEcranFin(actuelle.getEchantillonRoche());
        		ad.wait(1000);
        		ad.runAnimation();
        		AbstractAnimation ae = new AnimationHorizontale();
        		ae.setEcranDeb(actuelle.getEchantillonRoche());
        		ae.setEcranFin(ListScreen.Black());
        		ae.wait(1000);
        		ae.runAnimation();
    		}
		}
  
    	
        while (alreadyVisit.size() != this.listPlanete.size()) {
        	
        	
        	ArrayList<Planete> listprochaine = new ArrayList<Planete>();
        	ArrayList<ArrayList<Planete>> listchemin = new ArrayList<ArrayList<Planete>>();
        	ArrayList<Integer> listdistance = new ArrayList<Integer>();
        	listprochaine.add(actuelle);
        	listchemin.add(new ArrayList<Planete>());
        	listchemin.get(0).add(actuelle);
        	listdistance.add(999);
        	for (Planete access1 : actuelle.getListAccessibilite()) {
        		if (listprochaine.contains(access1)) {
        		} else {
                	listprochaine.add(access1);
                	listchemin.add(new ArrayList<Planete>());
                	int taille1 = listchemin.size()-1;
                	listchemin.get(taille1).add(access1);
                	int dist1 = (access1.getPos().getX()-actuelle.getPos().getX())*(access1.getPos().getX()-actuelle.getPos().getX())+(access1.getPos().getY()-actuelle.getPos().getY())*(access1.getPos().getY()-actuelle.getPos().getY());
                	listdistance.add(dist1);
                	if (access1.getListAccessibilite().size() != 0) {
            			for (Planete access2 : access1.getListAccessibilite()) {
                    		if (listprochaine.contains(access2)) {
                    		} else {
                            	listprochaine.add(access2);
                            	listchemin.add(new ArrayList<Planete>());
                            	int taille2 = listchemin.size()-1;
                            	listchemin.get(taille2).add(access1);
                            	listchemin.get(taille2).add(access2);
                            	int dist2 = (access2.getPos().getX()-access1.getPos().getX())*(access2.getPos().getX()-access1.getPos().getX())+(access2.getPos().getY()-access1.getPos().getY())*(access2.getPos().getY()-access1.getPos().getY());
                            	listdistance.add(dist1+dist2);
                            	if (access2.getListAccessibilite().size() != 0) {
                        			for (Planete access3 : access2.getListAccessibilite()) {
                                		if (listprochaine.contains(access3)) {
                                		} else {
                                        	listprochaine.add(access3);
                                        	listchemin.add(new ArrayList<Planete>());
                                        	int taille3 = listchemin.size()-1;
                                        	listchemin.get(taille3).add(access1);
                                        	listchemin.get(taille3).add(access2);
                                        	listchemin.get(taille3).add(access3);
                                        	int dist3 = (access3.getPos().getX()-access2.getPos().getX())*(access3.getPos().getX()-access2.getPos().getX())+(access3.getPos().getY()-access2.getPos().getY())*(access3.getPos().getY()-access2.getPos().getY());
                                        	listdistance.add(dist1+dist2+dist3);
                                        	if (access3.getListAccessibilite().size() != 0) {
                                    			for (Planete access4 : access3.getListAccessibilite()) {
                                            		if (listprochaine.contains(access4)) {
                                            		} else {
                                                    	listprochaine.add(access4);
                                                    	listchemin.add(new ArrayList<Planete>());
                                                    	int taille4 = listchemin.size()-1;
                                                    	listchemin.get(taille4).add(access1);
                                                    	listchemin.get(taille4).add(access2);
                                                    	listchemin.get(taille4).add(access3);
                                                    	listchemin.get(taille4).add(access4);
                                                    	int dist4 = (access4.getPos().getX()-access3.getPos().getX())*(access4.getPos().getX()-access3.getPos().getX())+(access4.getPos().getY()-access3.getPos().getY())*(access4.getPos().getY()-access3.getPos().getY());
                                                    	listdistance.add(dist1+dist2+dist3+dist4);
                                                    	if (access4.getListAccessibilite().size() != 0) {
                                                			for (Planete access5 : access4.getListAccessibilite()) {
                                                        		if (listprochaine.contains(access5)) {
                                                        		} else {
                                                                	listprochaine.add(access5);
                                                                	listchemin.add(new ArrayList<Planete>());
                                                                	int taille5 = listchemin.size()-1;
                                                                	listchemin.get(taille5).add(access1);
                                                                	listchemin.get(taille5).add(access2);
                                                                	listchemin.get(taille5).add(access3);
                                                                	listchemin.get(taille5).add(access4);
                                                                	listchemin.get(taille5).add(access5);
                                                                	int dist5 = (access5.getPos().getX()-access4.getPos().getX())*(access5.getPos().getX()-access4.getPos().getX())+(access5.getPos().getY()-access4.getPos().getY())*(access5.getPos().getY()-access4.getPos().getY());
                                                                	listdistance.add(dist1+dist2+dist3+dist4+dist5);
                                                        		}
                                                        	}
                                                		}
                                            		}
                                            	}
                                    		}
                                		}
                                	}
                        		}
                    		}
                    	}
            		}
        		}
        	}
        	
        	
           	
        	ArrayList<Planete> chemin = listchemin.get(0);
            Planete prochaine = listprochaine.get(0);
            int mindistance = listdistance.get(0);
            for (int i = 1; i<listdistance.size(); i++){
            	if (listdistance.get(i)<mindistance && listdistance.get(i)>0) {
            		if (alreadyVisit.contains(listprochaine.get(i)) || listprochaine.get(i).getEchantillonSol()==null) {
            		} else {
                		chemin = listchemin.get(i);
                		prochaine = listprochaine.get(i);
                		mindistance = listdistance.get(i);
            		}
            	}
            }
            
            
        	for (Planete P : chemin) {
        		wait(10);
                if (getSimulatedvoyageur().getDirection()=="E") {
                	if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>0) {
                		int Y = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = Y; i<P.getPos().getY()+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                	} else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                    	int Y = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = P.getPos().getY(); i<Y-1; i++){
                        	getSimulatedvoyageur().goBackward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                    if (P.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>0) {
                        getSimulatedvoyageur().turnRight();
                        wait(200);
                    	afficheEcran();
                    	int X = getSimulatedvoyageur().getPosTete().getX();
                    	for (int i = X; i<P.getPos().getX()+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                    	}
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                        getSimulatedvoyageur().turnLeft();
                        wait(200);
                    	afficheEcran();
                    	int X = getSimulatedvoyageur().getPosTete().getX();
                        for (int i = P.getPos().getX(); i<X+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                } else if (getSimulatedvoyageur().getDirection()=="W") {
                	if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()<0) {
                		int Y = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = P.getPos().getY(); i<Y+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                    	int Y = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = Y; i<P.getPos().getY()-1; i++){
                        	getSimulatedvoyageur().goBackward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                    if (P.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()<0) {
                        getSimulatedvoyageur().turnRight();
                        wait(200);
                    	afficheEcran();
                    	int X = getSimulatedvoyageur().getPosTete().getX();
                    	for (int i = P.getPos().getX(); i<X+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                    	}
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                        getSimulatedvoyageur().turnLeft();
                        wait(200);
                    	afficheEcran();
                    	int X = getSimulatedvoyageur().getPosTete().getX();
                        for (int i = X; i<P.getPos().getX()+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                } else if (getSimulatedvoyageur().getDirection()=="N") {
                	if (P.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()<0) {
                		int X = getSimulatedvoyageur().getPosTete().getX();
                    	for (int i = P.getPos().getX(); i<X+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                    	int X = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = X; i<P.getPos().getX()-1; i++){
                        	getSimulatedvoyageur().goBackward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                	if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()>0) {
                        getSimulatedvoyageur().turnRight();
                        wait(200);
                    	afficheEcran();
                    	int Y = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = Y; i<P.getPos().getY()+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                    	}
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                        getSimulatedvoyageur().turnLeft();
                        wait(200);
                    	afficheEcran();
                    	int Y = getSimulatedvoyageur().getPosTete().getY();
                        for (int i = P.getPos().getY(); i<Y+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                } else if (getSimulatedvoyageur().getDirection()=="S") {
                	if (P.getPos().getX()-getSimulatedvoyageur().getPosTete().getX()>0) {
                		int X = getSimulatedvoyageur().getPosTete().getX();
                    	for (int i = X; i<P.getPos().getX()+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                    	int X = getSimulatedvoyageur().getPosTete().getX();
                    	for (int i = P.getPos().getX(); i<X-1; i++){
                        	getSimulatedvoyageur().goBackward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                    if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()<0) {
                        getSimulatedvoyageur().turnRight();
                        wait(200);
                    	afficheEcran();
                    	int Y = getSimulatedvoyageur().getPosTete().getY();
                    	for (int i = P.getPos().getY(); i<Y+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                    	}
                    } else if (P.getPos().getY()-getSimulatedvoyageur().getPosTete().getY()==0) {
                    } else {
                        getSimulatedvoyageur().turnLeft();
                        wait(200);
                    	afficheEcran();
                    	int Y = getSimulatedvoyageur().getPosTete().getY();
                        for (int i = Y; i<P.getPos().getY()+1; i++){
                        	getSimulatedvoyageur().goForward();
                        	wait(200);
                        	afficheEcran();
                        }
                    }
                }
                
                
                actuelle = P;
                ArrayList<Planete> vuePossible = actuelle.getListAccessibilite();
            	for ( Planete in : alreadyVisit ) {
            		vuePossible.remove(in);
            	}
            	for (Planete vu : vuePossible ) {
            		if (vu.getEchantillonSol()==null) {
            			if (getSimulatedvoyageur().getPosTete().getY()==vu.getPos().getY()) {
            				if (Math.abs(getSimulatedvoyageur().getPosTete().getX()-vu.getPos().getX())<Math.abs(P.getPos().getX()-vu.getPos().getX())) {
            					getSimulatedvoyageur().takePicture(vu);
            		        	afficheEcran();
            		    		AbstractAnimation a = new AnimationRideau();
            		    		a.setEcranDeb(ListScreen.Black());
            		    		a.setEcranFin(vu.getImage());
            		    		a.wait(1000);
            		    		a.runAnimation();
            		    		AbstractAnimation aa = new AnimationRideau();
            		    		aa.setEcranDeb(vu.getImage());
            		    		aa.setEcranFin(ListScreen.Black());
            		    		aa.wait(1000);
            		    		aa.runAnimation();
            					alreadyVisit.add(vu);
            					afficheEcran();
            					wait(500);
            				} else {
            					getSimulatedvoyageur().turnLeft();
            					getSimulatedvoyageur().turnLeft();
            					getSimulatedvoyageur().takePicture(vu);
            		        	afficheEcran();
            		    		AbstractAnimation a = new AnimationRideau();
            		    		a.setEcranDeb(ListScreen.Black());
            		    		a.setEcranFin(vu.getImage());
            		    		a.wait(1000);
            		    		a.runAnimation();
            		    		AbstractAnimation aa = new AnimationRideau();
            		    		aa.setEcranDeb(vu.getImage());
            		    		aa.setEcranFin(ListScreen.Black());
            		    		aa.wait(1000);
            		    		aa.runAnimation();            					
            					alreadyVisit.add(vu);
            					afficheEcran();
            					wait(500);
            				}
            			} else if (getSimulatedvoyageur().getPosTete().getX()==vu.getPos().getX()) {
            				if (Math.abs(getSimulatedvoyageur().getPosTete().getY()-vu.getPos().getY())<Math.abs(P.getPos().getY()-vu.getPos().getY())) {
            					getSimulatedvoyageur().takePicture(vu);
            		        	afficheEcran();
            		    		AbstractAnimation a = new AnimationRideau();
            		    		a.setEcranDeb(ListScreen.Black());
            		    		a.setEcranFin(vu.getImage());
            		    		a.wait(1000);
            		    		a.runAnimation();
            		    		AbstractAnimation aa = new AnimationRideau();
            		    		aa.setEcranDeb(vu.getImage());
            		    		aa.setEcranFin(ListScreen.Black());
            		    		aa.wait(1000);
            		    		aa.runAnimation();            					
            					alreadyVisit.add(vu);
            					afficheEcran();
            					wait(500);
            				} else {
            					getSimulatedvoyageur().turnLeft();
            					getSimulatedvoyageur().turnLeft();
            					getSimulatedvoyageur().takePicture(vu);
            		        	afficheEcran();
            		    		AbstractAnimation a = new AnimationRideau();
            		    		a.setEcranDeb(ListScreen.Black());
            		    		a.setEcranFin(vu.getImage());
            		    		a.wait(1000);
            		    		a.runAnimation();
            		    		AbstractAnimation aa = new AnimationRideau();
            		    		aa.setEcranDeb(vu.getImage());
            		    		aa.setEcranFin(ListScreen.Black());
            		    		aa.wait(1000);
            		    		aa.runAnimation();            					
            					alreadyVisit.add(vu);
            					afficheEcran();
            					wait(500);
            				}
            			} else if (getSimulatedvoyageur().getPosTete().getX()!=vu.getPos().getX() && getSimulatedvoyageur().getPosTete().getY()!=vu.getPos().getY()) {
            				if (getSimulatedvoyageur().getDirection()=="E" || getSimulatedvoyageur().getDirection()=="W") {
            					if (getSimulatedvoyageur().getPosTete().getX()>vu.getPos().getX()) {
            						if (getSimulatedvoyageur().getDirection()=="E") {
            							getSimulatedvoyageur().turnLeft();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						} else {
            							getSimulatedvoyageur().turnRight();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						}
            					} else if (getSimulatedvoyageur().getPosTete().getX()<vu.getPos().getX()) {
            						if (getSimulatedvoyageur().getDirection()=="E") {
            							getSimulatedvoyageur().turnRight();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						} else {
            							getSimulatedvoyageur().turnLeft();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						}
            					}
            				} else if (getSimulatedvoyageur().getDirection()=="N" || getSimulatedvoyageur().getDirection()=="S") {
            					if (getSimulatedvoyageur().getPosTete().getY()>vu.getPos().getY()) {
            						if (getSimulatedvoyageur().getDirection()=="N") {
            							getSimulatedvoyageur().turnLeft();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						} else {
            							getSimulatedvoyageur().turnRight();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						}
            					} else if (getSimulatedvoyageur().getPosTete().getY()<vu.getPos().getY()) {
            						if (getSimulatedvoyageur().getDirection()=="N") {
            							getSimulatedvoyageur().turnRight();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						} else {
            							getSimulatedvoyageur().turnLeft();
                    					getSimulatedvoyageur().takePicture(vu);
                    		        	afficheEcran();
                    		    		AbstractAnimation a = new AnimationRideau();
                    		    		a.setEcranDeb(ListScreen.Black());
                    		    		a.setEcranFin(vu.getImage());
                    		    		a.wait(1000);
                    		    		a.runAnimation();
                    		    		AbstractAnimation aa = new AnimationRideau();
                    		    		aa.setEcranDeb(vu.getImage());
                    		    		aa.setEcranFin(ListScreen.Black());
                    		    		aa.wait(1000);
                    		    		aa.runAnimation();            							
            							alreadyVisit.add(vu);
            							afficheEcran();
            							wait(500);
            						}
            					}
            				}
            			}
            		}
            	}
            	
            	
                if (getSimulatedvoyageur().getPosBody().getX()==P.getPos().getX() && getSimulatedvoyageur().getPosBody().getY()==P.getPos().getY()) {
                	if (alreadyVisit.contains(P)) {
                	} else {
                		if (P.getEchantillonSol()==null) {
                			getSimulatedvoyageur().takePicture(P);
                        	afficheEcran();
                    		AbstractAnimation a = new AnimationRideau();
                    		a.setEcranDeb(ListScreen.Black());
                    		a.setEcranFin(P.getImage());
                    		a.wait(1000);
                    		a.runAnimation();
                    		AbstractAnimation aa = new AnimationRideau();
                    		aa.setEcranDeb(P.getImage());
                    		aa.setEcranFin(ListScreen.Black());
                    		aa.wait(1000);
                    		aa.runAnimation();
                		} else {
                			getSimulatedvoyageur().takePicture(P);
                        	getSimulatedvoyageur().takeEchantillonSol(P);
                        	getSimulatedvoyageur().takeEchantillonRoche(P);
                        	afficheEcran();
                    		AbstractAnimation a = new AnimationRideau();
                    		a.setEcranDeb(ListScreen.Black());
                    		a.setEcranFin(P.getImage());
                    		a.wait(1000);
                    		a.runAnimation();
                    		AbstractAnimation aa = new AnimationRideau();
                    		aa.setEcranDeb(P.getImage());
                    		aa.setEcranFin(ListScreen.Black());
                    		aa.wait(1000);
                    		aa.runAnimation();
                    		AbstractAnimation ab = new AnimationRideau();
                    		ab.setEcranDeb(ListScreen.Black());
                    		ab.setEcranFin(P.getEchantillonSol());
                    		ab.wait(1000);
                    		ab.runAnimation();
                    		AbstractAnimation ac = new AnimationRideau();
                    		ac.setEcranDeb(P.getEchantillonSol());
                    		ac.setEcranFin(ListScreen.Black());
                    		ac.wait(1000);
                    		ac.runAnimation();
                    		if (P.getEchantillonRoche()!=null) {
                        		AbstractAnimation ad = new AnimationRideau();
                        		ad.setEcranDeb(ListScreen.Black());
                        		ad.setEcranFin(P.getEchantillonRoche());
                        		ad.wait(1000);
                        		ad.runAnimation();
                        		AbstractAnimation ae = new AnimationRideau();
                        		ae.setEcranDeb(P.getEchantillonRoche());
                        		ae.setEcranFin(ListScreen.Black());
                        		ae.wait(1000);
                        		ae.runAnimation();
                    		}
                		}
                		        		
                    	wait(500);
                    	alreadyVisit.add(P);
                	}
                }
                wait(10);
        	}
        }
    }
}