/*
	Author:			R. Kuhn
	Coauthor:
	Refactoring:
	Date:			31.08.2020
	Time:			15:33
	Time spent:		1.2 h
*/
package Servlet;

import views.*;
import Parkhaus.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/Parkhaus")
public class ParkhausServlet extends HttpServlet implements ControllerIF{
	private static final ArrayList<ViewIF> views = new ArrayList<>();
	private static ViewIF tabelle = new EmptyView();
	private static ParkhausIF parkhaus = new Parkhaus();
	private static boolean newerViews = false;	// are data shown in views on latest state
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String body = getBody(request);
		String[] bodyArr = body.split(",");
		System.out.println(body);
		
		switch (bodyArr[0]){
			case "enter" -> {
				parkhaus.autoEnter(bodyArr);
				updater();
				if(!hasNoViews()){
					newerViews = true;
				}
			}
			case "leave" -> {
				parkhaus.autoLeave(bodyArr);
				updater();
				if(!hasNoViews()){
					newerViews = true;
				}
			}
			case "button", "choose" -> {
				toggleView(bodyArr[1]);
					newerViews = true;
			}
			case "gotNewData" -> {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println(newerViews);
				newerViews = false;		//views are now on latest state
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String body = getBody(request);
//		String[] bodyArr = body.split(",");
		System.out.println("GET " + body);
		//
		//		switch (bodyArr[0]){
		//			case "a":
		//				break;
		//		}
	}
	
	private void toggleView(String s) {
		for (ViewIF e : views){
			if (e.sameType(s)){			// check if the clicked view is already in the list
				e.delete(this);			// and remove if so
				return;
			}
		}
		if (tabelle.sameType(s)){		// same for tabelle
			tabelle.delete(this);
			return;
		}
		
		switch (s){						// else add a view of that type
			case "kundenTyp" -> new KundenTypView(this, parkhaus);
			case "menschenArt" -> new MenschenArtView(this, parkhaus);
			case "tabelle" -> new TabelleView(this, parkhaus);
			case "kunden" -> new KundenView(this, parkhaus);
			case "einnahmen" -> new EinnahmenView(this, parkhaus);
		}
	}
	
	public static boolean hasNoViews(){
		return (views.isEmpty() && tabelle.sameType(""));	//emptyView returns true on ""
		// return (views.isEmpty() && tabelle.getClass().equals(new EmptyView())); //works but seems unnecessary
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
	public void setTabelle(ViewIF newTab){
		tabelle = newTab;
	}
	
	@Override
	public void removeTabelle(ViewIF oldTab){
		tabelle = new EmptyView(this, parkhaus);
	}
	
	public static String getTabelleData() {
		return tabelle.getData();
	}
	
	@Override
	public void updater(){
		for (ViewIF e : views)
			e.update();
		tabelle.update();
	}
	
	
	private static String getBody(HttpServletRequest request) throws IOException{    //copied from M. Kaul
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try{
			InputStream inputStream = request.getInputStream();
			if (inputStream != null){
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0){
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else{
				stringBuilder.append("");
			}
		} finally{
			if (bufferedReader != null){
				bufferedReader.close();
			}
		}
		return stringBuilder.toString();
	}
}
