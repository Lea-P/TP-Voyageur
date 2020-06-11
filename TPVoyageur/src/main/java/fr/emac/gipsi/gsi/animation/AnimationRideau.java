package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationRideau extends AbstractAnimation {
	
	public AnimationRideau() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		for(int i=0;i<ecranInt.getColMax()/2+2;i++){
			for(int j=0;j<ecranInt.getColMax()+1;j++){
				ecranInt.updateColorByXY(j, ecranInt.getColMax()/2+i, ecranFin.getColorByXY(j,ecranInt.getColMax()/2+i));
				ecranInt.updateColorByXY(j, ecranInt.getColMax()/2+1-i, ecranFin.getColorByXY(j,ecranInt.getColMax()/2+1-i));
			}
			this.wait(20);
			this.showScreen(ecranInt);
		}
		
	}
	
}
