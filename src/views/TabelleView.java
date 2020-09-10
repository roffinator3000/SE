/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			10.09.2020
	Time:			08:08
	Time spent:		0.3 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public class TabelleView implements ViewIF{
	ControllerIF controller;
	ParkhausIF parkhaus;
	private String data = "<h2> this is the incomplete view for TABELLE</h2>";
	//contains the HTML/CSS/js data to embedd a table in a HTML page
	
	public TabelleView(ControllerIF ctrl, ParkhausIF ph){
		controller = ctrl;
		controller.setTabelle(this);
		parkhaus = ph;
	}
	
	@Override
	public String update(){
		return "<h2> this is <i>not</i> a real view</h2><br> PS: Tabelle";
	}
	
	@Override
	public String getData(){
		return data;
	}
	
	@Override
	public void setController(ControllerIF ctrl){
		controller.removeTabelle(this);
		controller = ctrl;
		controller.setTabelle(this);
	}
	
	@Override
	public void setParkhaus(ParkhausIF ph){
		parkhaus = ph;
	}
}
