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
		
<<<<<<< HEAD
		AbstractAnimation aa = new AnimationRideau();
		aa.setEcranDeb(ListScreen.typeDark());
=======
		AbstractAnimation aa = new AnimationFlash();
		aa.setEcranDeb(ListScreen.typePsychic());
>>>>>>> 3799284affcf814e598304683e1bfe2d2c9c4b6f
		aa.setEcranFin(ListScreen.Black());
		
		aa.wait(1000);
		
		aa.runAnimation();

		aa.wait(1000);
		
<<<<<<< HEAD
		AbstractAnimation ab = new AnimationRideau();
=======
		AbstractAnimation ab = new AnimationFlash();
>>>>>>> 3799284affcf814e598304683e1bfe2d2c9c4b6f
		ab.setEcranDeb(ListScreen.Black());
		ab.setEcranFin(ListScreen.Noctali());
		
		ab.runAnimation();

	}

}
