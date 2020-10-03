/*
	Author:			C. Schirmacher
	Coauthor:		
	Refactoring:	
	Date:			01.09.2020
	Time:			22:20
	Time spent:		1.5 h
*/
package Parkhaus;

import java.util.ArrayList;
import Auto.Auto;

public class Parkhaus implements ParkhausIF {
	
	private ArrayList<Auto> autosAusgefahren;
	private ArrayList<Auto> autosEingefahren;
	private int[] kundentyp;
	private int[] menschenart;
	
	
	public Parkhaus(){
		autosAusgefahren = new ArrayList<>();
		autosEingefahren = new ArrayList<>();
		kundentyp = new int[3];		// Abonennt, Firmenkunde, normal
		menschenart = new int[4];	// Frauen, Behinderte, Familie, andere
	}
	
	@Override
	public void autoEnter(String[] neuesAuto) {
								//	nummernschild				zeit einfahrt					tickethash	farbcode		kundentyp	menschenart
		Auto auto = new Auto(Integer.parseInt(neuesAuto[1]), Integer.parseInt(neuesAuto[2]), neuesAuto[5], neuesAuto[6], neuesAuto[8], neuesAuto[9]);
		autosEingefahren.add(auto);
		
		switch (neuesAuto[8].toLowerCase()){
			case "abonnent":
				kundentyp[0]++;
				break;
			case "firmenkunde":
				kundentyp[1]++;
				break;
			case "normal":
				kundentyp[2]++;
				break;
		}
		switch (neuesAuto[9].toLowerCase()){
			case "frauen":
				menschenart[0]++;
				break;
			case "behinderte":
				menschenart[1]++;
				break;
			case "familie":
				menschenart[2]++;
				break;
			case "andere":
				menschenart[3]++;
				break;
		}
	}
	
	@Override
	public void autoLeave(String[] altesAuto) {
		Auto carLeaving = null;
		for (Auto a: autosEingefahren) {
			if (Integer.parseInt(altesAuto[1]) == a.getNummerschild() && altesAuto[6] == a.getFarbcode()){
				carLeaving = a;
			}
		}
		autosEingefahren.remove(carLeaving);
		carLeaving.ausfahrt(Integer.parseInt(altesAuto[3]), Integer.parseInt(altesAuto[7]));
		autosAusgefahren.add(carLeaving);
	}
	
	@Override
	public int[][] gibDaten() {
		int[][] parameter = new int[2][];
		parameter[0] = kundentyp;
		parameter[1] = menschenart;
		return parameter;
	}
	
	@Override
	public ArrayList<Auto>[] gibAutos() {
		ArrayList<Auto>[] alleAutos = new ArrayList[2];
		alleAutos[0] = autosAusgefahren;
		alleAutos[1] = autosEingefahren;
		return alleAutos;
	}
}
