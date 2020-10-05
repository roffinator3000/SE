/*
	Author:			L. Daskin und R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			07.09.2020
	Time:			18:55
	Time spent:		7.5 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import javax.json.Json;
import javax.json.JsonObject;


public class KundenTypView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for KUNDENTYP</h2>";
	//contains the HTML/CSS/js data to embedd in a HTML page
	
	public KundenTypView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update(){
		int[] anzahlKunden = parkhaus.gibDaten()[0];
		
		JsonObject value= Json.createObjectBuilder()
				.add("data",Json.createArrayBuilder()
						.add(Json.createObjectBuilder()
								.add("labels",Json.createArrayBuilder()
										.add("Abonnent")
										.add("Firmenkunde")
										.add("normaler Kunde"))
								.add("values",Json.createArrayBuilder()
										.add(anzahlKunden[0])
										.add(anzahlKunden[1])
										.add(anzahlKunden[2]))
								.add("type","pie")
						)).build();
		
		data = "<div class='textView'>\n";
		data += "<h2>Kunden des Parkhauses:</h2>\n";
		data += "</div>\n";
		data += "<script type=\"text/javascript\"> var test= function(){ var layout = { height: 400, width: 500 }; Plotly.newPlot('myDiv', "+value.toString()+", layout);}\n" +
				"if(!window.load)\n" +
				"	window.load = []\n" +
				"window.load.push(test);</script><br>\n" +
				"<div id='myDiv' class='myDiv'><!-- Plotly chart will be drawn inside this DIV --></div>\n";
		
		data += "<div class='textView'>\n";
		data += "Sollte nichts zu sehen sein so sind wahrscheinlich noch keine Autos in das Parkhaus eingefahren\n";
		data += "</div>\n";
		data += "<br>\n";
		return data;
	}
	
	@Override
	public String getData(){
		return data;
	}
	
	public String toString(){
		return data;
	}
	
	@Override
	public boolean sameType(String type){
		return "kundentyp".equals(type.toLowerCase());
	}
}
