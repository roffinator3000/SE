/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			02.10.2020
	Time:			23:39
	Time spent:		0.2 h
*/
package views;

import Auto.Auto;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import java.text.DecimalFormat;
import java.util.List;

public class EinnahmenView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for EinnahmenView</h2>";
	//contains the HTML/CSS/js data to embedd in a HTML page
	
	public EinnahmenView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update() {
	
/*
		Author:			C. Schirmacher
		Date			06.10.2020
		Time			15:32
		Time spent:		1.5 h
*/
		
		int[][] daten = parkhaus.gibDaten();
		float einnahmen = (float) daten[2][0] / 100;
		int ehemaligeKunden = parkhaus.gibAutos()[0].size();
		float durchschnitt = (einnahmen / ehemaligeKunden);
		DecimalFormat df = new DecimalFormat("0.00");
		
		data = "<div class='textView'>\n";
		data += "<h2>Einnahmen des Parkhauses:</h2>\n";
		data += df.format(einnahmen) + 		"€ hat das Parkhaus insgesamt eingenommen. <br>\n";
		data += df.format(durchschnitt) +	"€ beträgt die durchschnittliche Einnahme pro Kunde.<br>\n";
		data += "<br>\n";
		
		List<Auto> autos = parkhaus.gibAutos()[0];
		
		float einnahmeAbonnenten = autos.parallelStream()
				.filter(Auto -> Auto.getKundentyp().equals("Abonnent"))
				.mapToInt(Auto -> Auto.getKosten())
				.reduce(0, (sum, Auto) -> sum + Auto)/100.0f;
		
		float einnahmeFirmen = autos.parallelStream()
				.filter(Auto -> Auto.getKundentyp().equals("Firmenkunde"))
				.mapToInt(Auto -> Auto.getKosten())
				.reduce(0, (sum, Auto) -> sum + Auto)/100.0f;
		
		float einnahmeNormal = autos.parallelStream()
				.filter(Auto -> Auto.getKundentyp().equals("NormalerKunde"))
				.mapToInt(Auto -> Auto.getKosten())
				.reduce(0, (sum, Auto) -> sum + Auto)/100.0f;
		
		data += "Dabei ist die Verteilung wie folgt:<br>\n";
		data += df.format(einnahmeAbonnenten) +	"€ von " + daten[0][0] + " Abonnenten.<br>\n";
		data += df.format(einnahmeFirmen) +		"€ von " + daten[0][1] + " Firmenkunden.<br>\n";
		data += df.format(einnahmeNormal) +		"€ von " + daten[0][2] + " regulären Kunden.<br>\n";
		data += "<br>\n";
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
		return "einnahmen".equals(type.toLowerCase());
	}
}
