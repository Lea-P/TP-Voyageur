package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationVerticale extends AbstractAnimation {
	
	public AnimationVerticale() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		for(int i=0;i<ecranInt.getColMax()+1;i++){
			for(int j=0;j<ecranInt.getColMax()/2;j++){
				ecranInt.updateColorByXY(i, 2*j, ecranFin.getColorByXY(i,2*j));
				ecranInt.updateColorByXY(ecranInt.getColMax()-i, 2*j+1, ecranFin.getColorByXY(ecranInt.getColMax()-i,2*j+1));
			}
			ecranInt.updateColorByXY(i, ecranInt.getColMax(), ecranFin.getColorByXY(i,ecranInt.getColMax()));
			this.wait(25);
			this.showScreen(ecranInt);
			
		}
		
	}
	
}
