/*
	Author:			R. Kuhn
	Coauthor:
	Refactoring:
	Date:			01.09.2020
	Time:			15:15
	Time spent:		0.3 h
*/
package Servlet;
import views.ViewIF;

public interface ControllerIF{
	public void addView(ViewIF newView);
	public default void setTabelle(ViewIF newView){
		addView(newView);
	}
	public void removeView(ViewIF oldView);
	public default void removeTabelle(ViewIF oldView){
		removeView(oldView);
	}
	public void updater();
}
