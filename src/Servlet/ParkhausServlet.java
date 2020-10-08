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
	private static ParkhausIF parkhaus = Parkhaus.getParkhaus();
	
	public ParkhausServlet() {
		new KundenView(this, parkhaus);
		new EinnahmenView(this, parkhaus);
		new KundenTypView(this, parkhaus);
		new MenschenArtView(this, parkhaus);
		new TabelleView(this, parkhaus);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String body = getBody(request);
		String[] bodyArr = body.split(",");
		System.out.println(body);
		
		switch (bodyArr[0]){
			case "enter" -> {
				parkhaus.autoEnter(bodyArr);
				updater();
			}
			case "leave" -> {
				parkhaus.autoLeave(bodyArr);
				updater();
			}
			case "occupied" -> {		//wenn webkomponente versucht, einen platz doppelt zu belegen
				parkhaus.autoDelete(bodyArr);
				updater();
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
	
	public static boolean hasNoViews(){
		return false;	//all views always on
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
