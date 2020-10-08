/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			10.09.2020
	Time:			08:08
	Time spent:		0.4 h
*/
package views;

import Auto.Auto;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import java.text.DecimalFormat;
import java.util.List;

public class TabelleView implements ViewIF{
	ControllerIF controller;
	ParkhausIF parkhaus;
	private String data = ""; //"<h2> this is the incomplete view for TABELLE</h2>";
	//contains the HTML/CSS/js data to embedd a table in a HTML page
	
	public TabelleView(ControllerIF ctrl, ParkhausIF ph){
		controller = ctrl;
		controller.setTabelle(this);
		parkhaus = ph;
		update();
	}
	
/*
		Author:			C. Schirmacher
		Date			06.10.2020
		Time			11:19
		Time spent:		5.25 h
*/
	
	@Override
	public String update(){
		List<Auto> autos = parkhaus.gibAutos()[0];
		int neueLaenge = autos.size();
		
		DecimalFormat df = new DecimalFormat("0.00");
		data = "";
		
		for (Auto a : autos){
			String KundenTyp = a.getKundentyp();
			
			if (KundenTyp.equalsIgnoreCase("NormalerKunde")) {
				KundenTyp = "normal";
			}
			
			data = "<tr>\n" +
						"<td>" + a.getNummerschild() 		+ "</td>\n" +
						"<td>" + a.getZeitreinfahren()						// -> "Mon Oct 05 15:13:36 CEST 2020"
						.toString().substring(0, 19)	+ "</td>\n" +	// -> "Mon Oct 05 15:13:36"
						"<td>" + df.format(
						a.getZeitaufenhalt()/100f) 		+ "s</td>\n" +
						"<td>" + df.format(
						a.getKosten()/100f) 	+ "€</td>\n" +
						"<td>" + KundenTyp 					+ "</td>\n" +
						"<td>" + a.getMenschenart() 		+ "</td>\n" +
						"<td>" + a.getParkplatznummer() 	+ "</td>\n" +
					"</tr>"
					+ data;		//this way the new entries will be on top
			}
		String tabelleKopf =
				"<div class='tabelle'>\n" +
					"<table id='autoTabelle'>\n" +
					"<tr>\n" +
					"<th>Nummernschild</th>\n" +
					"<th>Einfahrtszeit</th>\n" +
					"<th>Aufenthaltszeit</th>\n" +
					"<th>Gezahlter Betrag</th>\n" +
					"<th>Kundentyp</th>\n" +
					"<th>Art des Menschen</th>\n" +
					"<th>Parkplatz</th>\n" +
					"</tr>";
		String tabelleEnde =
				"\n</table>\n" +
						"</div>\n";
		
		data = tabelleKopf + data + tabelleEnde;
		return getData();
	}
	
	@Override
	public String getData(){
		return data;
	}
	
	/*		/C. Schirmacher		*/
	
	public String toString(){
		return data;
	}
	
	@Override
	public void setController(ControllerIF ctrl){
		controller.removeTabelle(this);
		controller = ctrl;
		controller.setTabelle(this);
	}
	
	@Override
	public void delete(ControllerIF ctrl){
		controller.removeTabelle(this);
		controller = null;
	}
	
	@Override
	public void setParkhaus(ParkhausIF ph){
		parkhaus = ph;
	}
	
	@Override
	public boolean sameType(String type){
		return "tabelle".equals(type.toLowerCase());
	}
}
