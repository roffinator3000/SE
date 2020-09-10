/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			01.09.2020
	Time:			16:28
	Time spent:		0.35 h
*/
package views;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public interface ViewIF{
	
	String update();
	void setController(ControllerIF ctrl);
	void setParkhaus(ParkhausIF ph);
	String getData();
}
