/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.animation.AnimationHorizontale;
import fr.emac.gipsi.gsi.animation.AnimationRideau;
import fr.emac.gipsi.gsi.animation.AnimationShrink;
import fr.emac.gipsi.gsi.animation.AnimationSpirale;
import fr.emac.gipsi.gsi.animation.AnimationSpirale2;
import fr.emac.gipsi.gsi.animation.AnimationSplit;
import fr.emac.gipsi.gsi.animation.AnimationVerticale;
import fr.emac.gipsi.gsi.ecran.ListScreen;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractAnimation aa = new AnimationFlash();
		aa.setEcranDeb(ListScreen.typePsychic());
		aa.setEcranFin(ListScreen.Black());
		
		aa.wait(1000);
		
		aa.runAnimation();

		aa.wait(1000);
		
		AbstractAnimation ab = new AnimationRideau();
		ab.setEcranDeb(ListScreen.Black());
		ab.setEcranFin(ListScreen.Noctali());
		
		ab.runAnimation();

	}

}
