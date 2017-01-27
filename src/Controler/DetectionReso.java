package Controler;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetectionReso {
	
	public static void main(String[] args) {
		DetectionReso dr = new DetectionReso();
		ArrayList<DisplayMode[]> l = dr.getDisplayModes();
		for (DisplayMode[] displayModes : l) {
			for (DisplayMode displayMode : displayModes) {
				dr.printDisplayMode(displayMode);
			}
		}
	}
	
	
	private ArrayList<DisplayMode> detectResoActive(){
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screenDevices = graphicsEnvironment.getScreenDevices();
		ArrayList<DisplayMode> listeReso = new ArrayList<DisplayMode>();
		for (GraphicsDevice graphicsDevice : screenDevices) {
		    listeReso.add(graphicsDevice.getDisplayMode());
		}
		return listeReso;
	}
	
	private ArrayList<DisplayMode[]> getDisplayModes(){
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screenDevices = graphicsEnvironment.getScreenDevices();
		ArrayList<DisplayMode[]> listeReso = new ArrayList<DisplayMode[]>();
		for (GraphicsDevice graphicsDevice : screenDevices) {
			if (!listeReso.contains(graphicsDevice))
				listeReso.add(graphicsDevice.getDisplayModes());
		}
		return listeReso;		
	}
	
	private void printDisplayMode(DisplayMode pfDM){
		System.out.println(pfDM.getWidth()+" x "+pfDM.getHeight());
		
		
	}
	

}
