/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			07.09.2020
	Time:			18:55
	Time spent:		0.1 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public class KundentypView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for KUNDENTYP</h2>";
		//contains the HTML/CSS/js data to embedd in a HTML page
	
	public KundentypView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
	}
	
	@Override
	public String update(){
		return "<h2> this is <i>not</i> a real view</h2><br> PS: Kundentyp";
	}
	
	@Override
	public String getData(){
		return data;
	}
}
