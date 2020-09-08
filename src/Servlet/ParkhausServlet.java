/*
	Author:			R. Kuhn
	Coauthor:
	Refactoring:
	Date:			31.08.2020
	Time:			15:33
	Time spent:		0.5 h
*/
package Servlet;

import views.ViewIF;

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
	private static ArrayList<ViewIF> views = new ArrayList<>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String[] body = getBody(request).split(",");
		System.out.println(body);
		
		switch (body[0]){
			case "enter":
				//todo an parkhaus übergeben
				updater();
				break;
			case "leave":
				//todo an parkhaus übergeben
				updater();
				break;
		}
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
