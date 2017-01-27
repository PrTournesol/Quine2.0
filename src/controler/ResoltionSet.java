package Controler;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

public class ResoltionSet {

	/**Permet de tester si cette classe fonctionne correctement
	 * @param args
	 */
	public static void main(String[] args) {
		ResoltionSet reso = new ResoltionSet();
		ArrayList<ArrayList<DisplayMode>> liste = reso.DetecReso();
		DisplayMode mode = reso.findBetter(liste.get(0),(float)16/9);
    	System.out.println(mode.getWidth()+" x "+mode.getHeight()+" "+mode.getBitDepth()+" "+mode.getRefreshRate()+" rapport : "+ (((float)4/3)==((float)mode.getWidth()/mode.getHeight()))+" ; ");

	}
	
	public ResoltionSet() {
		//DetecReso();
	}

	/**Retourne la liste des résolutions disponible sur chaque moniteur
	 * @return liste des résolutions
	 */
	private ArrayList<ArrayList<DisplayMode>> DetecReso() {
		GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		GraphicsDevice[] devices = gEnv.getScreenDevices();
		
		ArrayList<ArrayList<DisplayMode>> listeReso=new ArrayList<>();
		// parcourt la liste des écrans
		for (int i=0; i<devices.length; i++) { 
			//System.out.println("Identifiant de l'écran : " + devices[i].getIDstring() +" infos : ");
		    listeReso.add(new ArrayList<DisplayMode>());
		    for (DisplayMode mode : devices[i].getDisplayModes()) {
		    	// vu que la liste des affichages disponibles sur  écran peut comporter plusieurs fois la même configuraition (ex 1920*1080 60Hz 32 Bit), on supproime les doublons
		    	if (!listeReso.get(i).contains(mode))
		    		listeReso.get(i).add(mode);
		    }
//		    for (DisplayMode displayMode : listeReso.get(i)) {
//		    	System.out.println(displayMode.getWidth()+" x "+displayMode.getHeight()+" "+displayMode.getBitDepth()+" "+displayMode.getRefreshRate()+" rapport : "+ (((float)4/3)==((float)displayMode.getWidth()/displayMode.getHeight()))+" ; ");
//		    }
		}
		return listeReso;	
	}
	
	/** Trouve la meilleure résoltuion possible en format dans une liste de diaplayMode
	 * @param pfList
	 * @param format
	 * @return
	 */
	private DisplayMode findBetter (ArrayList<DisplayMode> pfList, float format){
		ArrayList<DisplayMode> list43 = new ArrayList<>();
		for (DisplayMode displayMode : pfList) {
			if (((float)format)==((float)displayMode.getWidth()/displayMode.getHeight()))
				list43.add(displayMode);
		}
		if (list43.size()==0)
			return null;
		
		DisplayMode betterDM=list43.get(0);
		for (DisplayMode displayMode : list43) {
			if(isBetter(displayMode, betterDM))
				betterDM=displayMode;
		}
		return betterDM;
	}

	/** Est vrqi si DM1 est meilleur que DM 2
	 * @param DM1 est-tu meilleur que
	 * @param DM2 moi
	 * @return
	 */
	private boolean isBetter(DisplayMode DM1, DisplayMode DM2) {
		if (DM1.getWidth() > DM2.getWidth())
			return true;
		else if (DM1.getWidth() < DM2.getWidth())
			return false;
		else
			if (DM1.getHeight() > DM2.getHeight())
				return true;
			else if (DM1.getHeight() < DM2.getHeight())
				return false;
			else
				if (DM1.getRefreshRate() > DM2.getRefreshRate())
					return true;
				else if (DM1.getRefreshRate() < DM2.getRefreshRate())
					return false;
				else 
					return false;
	}
	
	
	
}
