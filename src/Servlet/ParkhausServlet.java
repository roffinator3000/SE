/*
	Author:			R. Kuhn
	Coauthor:
	Refactoring:
	Date:			31.08.2020
	Time:			15:33
	Time spent:		0.3 h
*/
package Servlet;

import views.ViewIF;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Parkhaus")
public class ParkhausServlet extends HttpServlet implements ControllerIF{
	private static ArrayList<ViewIF> views = new ArrayList<>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	}
	
	public static boolean hasNoViews(){
		return views.isEmpty();
	}
	
	public static ArrayList<ViewIF> getViews(){
		return views;
	}
	
	
	@Override
	public void addView(ViewIF newView){
		views.add(newView);
	}
	
	@Override
	public void removeView(ViewIF oldView){
		views.remove(oldView);
	}
	
	@Override
	public void updater(){
		for (ViewIF e : views)
			e.update();
	}
}
