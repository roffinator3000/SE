/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			02.10.2020
	Time:			23:40
	Time spent:		0.2 h
*/
package views;

import Auto.Auto;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import java.util.List;

public class KundenView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for KundenView</h2>";
	//contains the HTML/CSS/js data to embedd in a HTML page
	
	public KundenView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update(){
	
/*
		Author:			C. Schirmacher
		Date			06.10.2020
		Time			15:32
		Time spent:		0.5 h
*/
		
		List<Auto>[] alleAutos = parkhaus.gibAutos();
		
		int ehemaligeKunden = alleAutos[0].size();
		int aktuelleKunden = alleAutos[1].size();
		
		data = "<div class='textView'>\n";
		data += "<h2>Kunden des Parkhauses:</h2>\n";
		data += "" + (ehemaligeKunden + aktuelleKunden) + 	" Kunden hatte das Parkhaus insgesamt. <br>\n";
		data += "" + aktuelleKunden + 						" davon sind aktuell noch im Pakhaus.<br>\n";
		data += "</div>\n";
		
		/*		/C. Schirmacher		*/
		
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
		return "kunden".equals(type.toLowerCase());
	}
}
