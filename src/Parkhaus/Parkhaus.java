/*
	Author:			C. Schirmacher
	Coauthor:		
	Refactoring:	
	Date:			01.09.2020
	Time:			22:20
	Time spent:		3 h
*/
package Parkhaus;

import java.util.ArrayList;
import java.util.Date;

import Auto.Auto;

public class Parkhaus implements ParkhausIF {
	
	private final static Parkhaus singletonParkhaus = new Parkhaus();
	
	private ArrayList<Auto> autosAusgefahren;
	private ArrayList<Auto> autosEingefahren;
	private int[] kundentyp;
	private int[] menschenart;
	private int einnahmen;
	
	
	private Parkhaus(){
		autosAusgefahren = new ArrayList<>();
		autosEingefahren = new ArrayList<>();
		kundentyp = new int[3];		// Abonennt, Firmenkunde, normal
		menschenart = new int[4];	// Frauen, Behinderte, Familie, andere
	}
	
	public static Parkhaus getParkhaus(){
		return singletonParkhaus;
	}
	
	@Override
	public void autoEnter(String[] neuesAuto) {
		//							nummernschild						zeit einfahrt				tickethash		farbcode	kundentyp	menschenart
		Auto auto = new Auto(Integer.parseInt(neuesAuto[1]), new Date(Long.parseLong(neuesAuto[2])), neuesAuto[5], neuesAuto[6], neuesAuto[8], neuesAuto[9]);
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
			case "frau":
				menschenart[0]++;
				break;
			case "behindert":
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
		try{
			Auto carLeaving = null;
			
			for (Auto a : autosEingefahren){
				if (Integer.parseInt(altesAuto[1]) == a.getNummerschild() && altesAuto[6].equals(a.getFarbcode())){
					carLeaving = a;
				}
			}
			autosEingefahren.remove(carLeaving);
			//							zeit Aufenhalt					parkplatznummer
			carLeaving.ausfahrt(Long.parseLong(altesAuto[3]), Integer.parseInt(altesAuto[7]));
			einnahmen += carLeaving.getKosten();
			autosAusgefahren.add(carLeaving);
		} catch (NullPointerException e){
			System.out.println("NullPointerException");
			System.out.println("Parkhaus.Parkhaus.autoLeave (in Parkhaus.java)");
		}
	}
	public void autoDelete(String[] falschesAuto) {		//wenn webkomponente versucht, einen platz doppelt zu belegen
//		int l = falschesAuto[1].length();						// "Car(xyz)", "Car(xy)" oder "Car(x)" ?
//		String fAuto = falschesAuto[1].substring(4,(l-1));		// "Car(xyz)" -> "xyz"
//		int nummerFalschesAuto = Integer.parseInt(fAuto);		// "xyz" -> xyz
//
//		Auto carDeleting = null;
//		for (Auto a: autosEingefahren) {
//			if (nummerFalschesAuto == a.getNummerschild()){
//				carDeleting = a;
//			}
//		}
//		autosEingefahren.remove(carDeleting);
		Auto carDeleting = autosEingefahren.get(autosEingefahren.size()-1);
		autosEingefahren.remove(carDeleting);
		
		switch (carDeleting.getKundentyp().toLowerCase()){
			case "abonnent":
				kundentyp[0]--;
				break;
			case "firmenkunde":
				kundentyp[1]--;
				break;
			case "normal":
				kundentyp[2]--;
				break;
		}
		switch (carDeleting.getMenschenart().toLowerCase()){
			case "frau":
				menschenart[0]--;
				break;
			case "behindert":
				menschenart[1]--;
				break;
			case "familie":
				menschenart[2]--;
				break;
			case "andere":
				menschenart[3]--;
				break;
		}
	}
	
	@Override
	public int[][] gibDaten() {
		int[][] parameter = new int[3][];
		parameter[0] = kundentyp;
		parameter[1] = menschenart;
		parameter[2] = new int[]{einnahmen};
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
