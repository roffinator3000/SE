/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			07.09.2020
	Time:			18:35
	Time spent:		0.3 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public abstract class ViewAbs implements ViewIF{
	ControllerIF controller;
	ParkhausIF parkhaus;
	
	ViewAbs(ControllerIF ctrl, ParkhausIF ph){
		controller = ctrl;
		controller.addView(this);
		parkhaus = ph;
//		update();		//does not work?!?
	}
	
	@Override
	public void setController(ControllerIF ctrl){
		controller.removeView(this);
		controller = ctrl;
		controller.addView(this);
	}
	
	@Override
	public void setParkhaus(ParkhausIF ph){
		parkhaus = ph;
	}
}
