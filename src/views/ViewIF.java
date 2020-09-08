/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			01.09.2020
	Time:			16:28
	Time spent:		0.25 h
*/
package views;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public interface ViewIF{
	
	public void update();
	public void setController(ControllerIF ctrl);
	public void setParkhaus(ParkhausIF ph);
}
