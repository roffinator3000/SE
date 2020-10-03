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
import Parkhaus.Parkhaus;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

import java.util.ArrayList;
import java.util.List;

public class EinnahmenView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for EinnahmenView</h2>";
	//contains the HTML/CSS/js data to embedd in a HTML page
	
	public EinnahmenView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update(){
		List<Auto> autosAusgefahren = parkhaus.gibAutos()[0];
		// summe einahmen
		// durchschnittliche einnahmen
		data = "<h2> this is <i>not</i> a real view</h2><br> PS: EinnahmenView";
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
