/**
 *
 */
package fr.emac.gipsi.gsi.voyageur;

import fr.emac.gipsi.gsi.voyage.Position;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class VoyageurSimuler extends AbstractVoyageur {

    /**
     *
     */
    public VoyageurSimuler() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#forward()
     */
    @Override
    protected void forward() {
    	Position positionTete=getPosTete();
    	Position positionBody=getPosBody() ;
    	String Direction=getDirection();
    	if (Direction=="N") {
    		positionTete.setX(positionTete.getX()-1);
        	positionBody.setX(positionBody.getX()-1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    	if (Direction=="W") {
    		if (posTete(1)!=0) {
    			posTete(1)=PosTete(1)-1;
        		posBody(1)=PosBody(1)-1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    	if (Direction=="S") {
    		if (posTete(0)!=LigMax) {
    			posTete(0)=PosTete(0)+1;
        		posBody(0)=PosBody(0)+1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    	if (Direction=="E") {
    		if (posTete(1)!=ColMax) {
    			posTete(1)=PosTete(1)+1;
        		posBody(1)=PosBody(1)+1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {
    	posTete=getPosTete();
    	posBody=getPosBody();
    	String Direction=getDirection();
    	if (Direction=="N") {
    		if (posBody(0)!=LigMax) {
    			posTete(0)=PosTete(0)+1;
        		posBody(0)=PosBody(0)+1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    	if (Direction=="W") {
    		if (posBody(1)!=ColMax) {
    			posTete(1)=PosTete(1)+1;
        		posBody(1)=PosBody(1)+1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    	if (Direction=="S") {
    		if (posBody(0)!=0) {
    			posTete(0)=PosTete(0)-1;
        		posBody(0)=PosBody(0)-1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    	if (Direction=="E") {
    		if (posBody(1)!=0) {
    			posTete(1)=PosTete(1)-1;
        		posBody(1)=PosBody(1)-1;
        		setPosTete(posTete);
        		setPosBody(posBody);
    		}
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
    	posTete=getPosTete();
    	String Direction=getDirection();
    	if (Direction=="N") {
			if (posTete(1)!=0) {
				posTete(0)=PosTete(0)+1;
				posTete(1)=PosTete(1)-1;
    			setPosTete(posTete);
    			setDirection("W");
			}
    	}
    	if (Direction=="W") {
    		if (posTete(0)!=LigMax) {
				posTete(0)=PosTete(0)+1;
				posTete(1)=PosTete(1)+1;
    			setPosTete(posTete);
    			setDirection("S");
			}
    	}
    	if (Direction=="S") {
    		if (posTete(1)!=ColMax) {
				posTete(0)=PosTete(0)-1;
				posTete(1)=PosTete(1)+1;
    			setPosTete(posTete);
    			setDirection("E");
			}
    	}
    	if (Direction=="E") {
    		if (posTete(0)!=0) {
				posTete(0)=PosTete(0)-1;
				posTete(1)=PosTete(1)-1;
    			setPosTete(posTete);
    			setDirection("N");
			}
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    protected void right() {
    	posTete=getPosTete();
    	String Direction=getDirection();
    	if (Direction=="N") {
			if (posTete(1)!=ColMax) {
				posTete(0)=PosTete(0)+1;
				posTete(1)=PosTete(1)+1;
    			setPosTete(posTete);
    			setDirection("E");
			}
    	}
    	if (Direction=="W") {
    		if (posTete(0)!=0) {
				posTete(0)=PosTete(0)-1;
				posTete(1)=PosTete(1)+1;
    			setPosTete(posTete);
    			setDirection("N");
			}
    	}
    	if (Direction=="S") {
    		if (posTete(1)!=0) {
				posTete(0)=PosTete(0)-1;
				posTete(1)=PosTete(1)-1;
    			setPosTete(posTete);
    			setDirection("W");
			}
    	}
    	if (Direction=="E") {
    		if (posTete(0)!=LigMax) {
				posTete(0)=PosTete(0)+1;
				posTete(1)=PosTete(1)-1;
    			setPosTete(posTete);
    			setDirection("S");
			}
    	}
    }
