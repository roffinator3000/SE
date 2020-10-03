/*
	Author:			Lawin Daskin und R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			07.09.2020
	Time:			18:55
	Time spent:		7 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import javax.json.*;



public class KundenTypView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for KUNDENTYP</h2>";
		//contains the HTML/CSS/js data to embedd in a HTML page
	
	public KundenTypView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update(){
		int[] anzahlkunden =parkhaus.gibDaten()[0];


		JsonObject  value= Json.createObjectBuilder()
				.add("data",Json.createArrayBuilder()
						.add(Json.createObjectBuilder()
								.add("labels",Json.createArrayBuilder()
										.add("Abonnent")
										.add("Firmenkunde")
										.add("normaler Kunde"))
								.add("values",Json.createArrayBuilder()
										.add(anzahlkunden[0])
										.add(anzahlkunden[1])
										.add(anzahlkunden[2]))
								.add("type","pie")
						)).build();

		data ="<script type=\"text/javascript\"> var test= function(){ var layout = {   height: 400,   width: 500 };  Plotly.newPlot('myDiv', "+value.toString()+", layout);}\n" +
				"if(!window.load)\n" +
				"  window.load = []\n" +
				"window.load.push(test);</script><br>" +
				"<div id='myDiv' class='myDiv'><!-- Plotly chart will be drawn inside this DIV --></div>";

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
