package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationHorizontale extends AbstractAnimation {
	
	public AnimationHorizontale() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		for(int i=0;i<ecranInt.getColMax()+1;i++){
			for(int j=0;j<ecranInt.getColMax()/2;j++){
				ecranInt.updateColorByXY(2*j, i, ecranFin.getColorByXY(2*j,i));
				ecranInt.updateColorByXY(2*j+1, ecranInt.getColMax()-i, ecranFin.getColorByXY(2*j+1,ecranInt.getColMax()-i));
			}
			ecranInt.updateColorByXY(ecranInt.getColMax(), i, ecranFin.getColorByXY(ecranInt.getColMax(),i));
			this.wait(25);
			this.showScreen(ecranInt);
			
		}
		
	}
	
}
