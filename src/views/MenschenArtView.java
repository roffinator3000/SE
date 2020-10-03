/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			07.09.2020
	Time:			18:51
	Time spent:		0.2 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public class MenschenArtView extends ViewAbs{
	private String data = "<h2> this is the incomplete view for MENSCHENART</h2>";
		//contains the HTML/CSS/js data to embedd in a HTML page
	
	public MenschenArtView(ControllerIF ctrl, ParkhausIF ph){
		super(ctrl, ph);
		update();
	}
	
	@Override
	public String update(){
		data = "<h2> this is <i>not</i> a real view</h2><br> PS: Menschenart";
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