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
		List<Auto>[] alleAutos = parkhaus.gibAutos();
		// anzahl kunden aktuell
		// anzahl kunden gesamt
		data = "<h2> this is <i>not</i> a real view</h2><br> PS: KundenView";
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
