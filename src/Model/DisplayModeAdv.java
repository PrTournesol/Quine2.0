package Model;

import java.awt.DisplayMode;

public class DisplayModeAdv  {
	
	private DisplayMode dm;
	private int isQT;
	
 
	public DisplayModeAdv(int width, int height, int bitDepth,int refreshRate){
		dm= new DisplayMode(width, height, bitDepth, refreshRate);
		
	}
	

}
