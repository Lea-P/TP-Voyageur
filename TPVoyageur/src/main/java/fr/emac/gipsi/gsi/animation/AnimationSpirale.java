package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationSpirale extends AbstractAnimation {
	
	public AnimationSpirale() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		for(int i=0;i<ecranInt.getColMax()/2+1;i++){
			int k = ecranInt.getColMax()/2-1;
			for(int j=i;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(i, j, ecranFin.getColorByXY(i,j));
				this.wait(ecranInt.getColMax()/(2*(2*k+1)));
				this.showScreen(ecranInt);
			}
			for(int j=i+1;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(j, ecranInt.getColMax()-i, ecranFin.getColorByXY(j,ecranInt.getColMax()-i));
				this.wait(ecranInt.getColMax()/(2*(2*k+1)));
				this.showScreen(ecranInt);
			}
			for(int j=i+1;j<ecranInt.getColMax()-i+1;j++){
				ecranInt.updateColorByXY(ecranInt.getColMax()-i, ecranInt.getColMax()-j, ecranFin.getColorByXY(ecranInt.getColMax()-i,ecranInt.getColMax()-j));
				this.wait(ecranInt.getColMax()/(2*(2*k+1)));
				this.showScreen(ecranInt);
			}
			for(int j=i+1;j<ecranInt.getColMax()-i;j++){
				ecranInt.updateColorByXY(ecranInt.getColMax()-j, i, ecranFin.getColorByXY(ecranInt.getColMax()-j,i));
				this.wait(ecranInt.getColMax()/(2*(2*k+1)));
				this.showScreen(ecranInt);
			}
		}
		
	}
	
}