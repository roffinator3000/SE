/*
	Author:			L. Daskin und R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			07.09.2020
	Time:			18:51
	Time spent:		1 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import javax.json.Json;
import javax.json.JsonObject;

public class MenschenArtView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for MENSCHENART</h2>";
	//contains the HTML/CSS/js data to embedd in a HTML page
	
	public MenschenArtView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update(){
		int[] anzahlKunden = parkhaus.gibDaten()[1];
		
		JsonObject  value= Json.createObjectBuilder()
				.add("data",Json.createArrayBuilder()
						.add(Json.createObjectBuilder()
								.add("labels",Json.createArrayBuilder()
										.add("Frauen")
										.add("Behinderte")
										.add("Familien")
										.add("Andere"))
								.add("values",Json.createArrayBuilder()
										.add(anzahlKunden[0])
										.add(anzahlKunden[1])
										.add(anzahlKunden[2])
										.add(anzahlKunden[3]))
								.add("type","pie")
						)).build();
		
		data = "<script type=\"text/javascript\"> var test2 = function(){var layout2 = {   height: 400,   width: 500 };  Plotly.newPlot('myDiv2', "+value.toString()+", layout2);}\n" +
				"if(!window.load)\n" +
				"  window.load = []\n" +
				"window.load.push(test2);</script><br>" +
				"<div id='myDiv2' class='myDiv'><!-- Plotly chart will be drawn inside this DIV --></div>";
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
		return "menschenart".equals(type.toLowerCase());
	}
}
