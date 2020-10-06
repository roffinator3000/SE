/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			10.09.2020
	Time:			08:33
	Time spent:		0.2 h
*/
package views;

import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public class EmptyView implements ViewIF{
	//in case some view is needed but a proper one is unwanted or impossible to make
	public EmptyView(){}
	public EmptyView(ControllerIF ctrl, ParkhausIF ph){}
	
	@Override
	public String update(){
		return "";
	}
	
	@Override
	public void setController(ControllerIF ctrl){
	
	}
	
	@Override
	public void setParkhaus(ParkhausIF ph){
	
	}
	
	@Override
	public String getData(){
		return "";
	}
	
	@Override
	public boolean sameType(String type){
		return "empty".equals(type.toLowerCase()) ||
				"leer".equals(type.toLowerCase())||
				" ".equals(type.toLowerCase())||
				"".equals(type.toLowerCase());
	}
	
	@Override
	public void delete(ControllerIF ctrl){
		ctrl.removeTabelle(this);
	}
}
