/*
	Author:			R. Kuhn
	Coauthor:		
	Refactoring:	
	Date:			01.09.2020
	Time:			16:28
	Time spent:		0.4 h
*/
package views;
import Parkhaus.ParkhausIF;
import Servlet.ControllerIF;

public interface ViewIF{
	
	String update();
	void setController(ControllerIF ctrl);
	void setParkhaus(ParkhausIF ph);
	String getData();
	String toString();
	boolean sameType(String type);
	void delete(ControllerIF ctrl);
}
