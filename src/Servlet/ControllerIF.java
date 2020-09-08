/*
	Author:			R. Kuhn
	Coauthor:
	Refactoring:
	Date:			01.09.2020
	Time:			15:15
	Time spent:		0.25 h
*/
package Servlet;
import views.ViewIF;

public interface ControllerIF{
	public void addView(ViewIF newView);
	public void removeView(ViewIF oldView);
	public void updater();
}
