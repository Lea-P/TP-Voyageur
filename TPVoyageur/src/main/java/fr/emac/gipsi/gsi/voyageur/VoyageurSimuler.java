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
    		positionTete.setY(positionTete.getY()-1);
        	positionBody.setY(positionBody.getY()-1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    	if (Direction=="S") {
    		positionTete.setX(positionTete.getX()+1);
        	positionBody.setX(positionBody.getX()+1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    	if (Direction=="E") {
    		positionTete.setY(positionTete.getY()+1);
        	positionBody.setY(positionBody.getY()+1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {
    	Position positionTete=getPosTete();
    	Position positionBody=getPosBody() ;
    	String Direction=getDirection();
    	if (Direction=="N") {
    		positionTete.setX(positionTete.getX()+1);
        	positionBody.setX(positionBody.getX()+1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    	if (Direction=="W") {
    		positionTete.setY(positionTete.getY()+1);
        	positionBody.setY(positionBody.getY()+1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    	if (Direction=="S") {
    		positionTete.setX(positionTete.getX()-1);
        	positionBody.setX(positionBody.getX()-1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    	if (Direction=="E") {
    		positionTete.setY(positionTete.getY()-1);
        	positionBody.setY(positionBody.getY()-1);
        	setPosTete(positionTete);
        	setPosBody(positionBody);
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
    	Position positionTete=getPosTete();
    	String Direction=getDirection();
    	if (Direction=="N") {
    		positionTete.setX(positionTete.getX()+1);
    		positionTete.setY(positionTete.getY()-1);
        	setPosTete(positionTete);
    		setDirection("W");
    	}
    	if (Direction=="W") {
    		positionTete.setX(positionTete.getX()+1);
    		positionTete.setY(positionTete.getY()+1);
	        setPosTete(positionTete);
    		setDirection("S");
    	}
    	if (Direction=="S") {
    		positionTete.setX(positionTete.getX()-1);
    		positionTete.setY(positionTete.getY()+1);
	        setPosTete(positionTete);
    		setDirection("E");
    	}
    	if (Direction=="E") {
    		positionTete.setX(positionTete.getX()-1);
    		positionTete.setY(positionTete.getY()-1);
	        setPosTete(positionTete);
    		setDirection("N");
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    protected void right() {
    	Position positionTete=getPosTete();
    	String Direction=getDirection();
    	if (Direction=="N") {
    		positionTete.setX(positionTete.getX()+1);
    		positionTete.setY(positionTete.getY()+1);
        	setPosTete(positionTete);
    		setDirection("E");
    	}
    	if (Direction=="W") {
    		positionTete.setX(positionTete.getX()-1);
    		positionTete.setY(positionTete.getY()+1);
        	setPosTete(positionTete);
    		setDirection("N");
    	}
    	if (Direction=="S") {
    		positionTete.setX(positionTete.getX()-1);
    		positionTete.setY(positionTete.getY()-1);
        	setPosTete(positionTete);
    		setDirection("W");
    	}
    	if (Direction=="E") {
    		positionTete.setX(positionTete.getX()+1);
    		positionTete.setY(positionTete.getY()-1);
        	setPosTete(positionTete);
    		setDirection("S");
    	}
    }
}