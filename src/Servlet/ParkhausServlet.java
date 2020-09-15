/*
	Author:			R. Kuhn
	Coauthor:
	Refactoring:
	Date:			31.08.2020
	Time:			15:33
	Time spent:		1.1 h
*/
package Servlet;

import views.*;
import Parkhaus.ParkhausIF;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet("/Parkhaus")
public class ParkhausServlet extends HttpServlet implements ControllerIF{
	private static final ArrayList<ViewIF> views = new ArrayList<>();
	private static ViewIF tabelle = new EmptyView();
	private static ParkhausIF parkhaus; //todo init
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String body = getBody(request);
		String[] bodyArr = body.split(",");
		System.out.println(body);
		
		switch (bodyArr[0]){
			case "enter":
				//todo an parkhaus übergeben
				updater();
				break;
			case "leave":
				//todo an parkhaus übergeben
				updater();
				break;
			case "button":
			case "choose":
				toggleView(bodyArr[1]);
				break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String body = getBody(request);
//		String[] bodyArr = body.split(",");
		System.out.println("GET" + body);
		//
		//		switch (bodyArr[0]){
		//			case "a":
		//				break;
		//		}
	}
	
	private void toggleView(String s) {
		for (ViewIF e : views){
			if (e.sameType(s)){			// check if the clicked view is already in the list
				e.delete(this);		// and remove if so
				return;
			}
		}
		if (tabelle.sameType(s)){		// same for tabelle
			tabelle.delete(this);
			return;
		}
		
		switch (s){					// else add a view of that type
			case "kundenTyp" -> new KundentypView(this, parkhaus);
			case "menschenArt" -> new MenschenartView(this, parkhaus);
			case "tabelle" -> new TabelleView(this, parkhaus);
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
