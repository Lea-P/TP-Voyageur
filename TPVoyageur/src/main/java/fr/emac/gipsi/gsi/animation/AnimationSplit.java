package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationSplit extends AbstractAnimation {
	
	public AnimationSplit() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		ecranInt.updateColorByXY(ecranInt.getColMax()/2, ecranInt.getColMax()/2, ecranFin.getColorByXY(ecranInt.getColMax()/2,ecranInt.getColMax()/2));
		this.wait(100);
		this.showScreen(ecranInt);
		for(int k=0;k<ecranInt.getColMax()/2+1;k++){
			int i = ecranInt.getColMax()/2-k;
			for(int j=i+1;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(i, j, ecranFin.getColorByXY(i,j));
			}
			for(int j=i+1;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(j, ecranInt.getColMax()-i, ecranFin.getColorByXY(j,ecranInt.getColMax()-i));
			}
			for(int j=i+1;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(ecranInt.getColMax()-i, ecranInt.getColMax()-j, ecranFin.getColorByXY(ecranInt.getColMax()-i,ecranInt.getColMax()-j));
			}
			for(int j=i+1;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(ecranInt.getColMax()-j, i, ecranFin.getColorByXY(ecranInt.getColMax()-j,i));
			}
			this.wait(100);
			this.showScreen(ecranInt);
		}
		
	}
	
}
