<%--Created by IntelliJ IDEA.						Change this in: File | Settings | Editor | File and Code Templates | Other
	Author:			R. Kuhn
	Date			07.09.2020
	Time			18:17
	Time spent:		0.75 h
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Servlet.ParkhausServlet" %>
<%@ page import="views.ViewIF" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<title>Views - Semesterprojekt Parkhaus</title>
	</head>
	<body>
		<br><br><br>
<%--		<h2> this is <i>not</i> a view</h2>--%>
		
		<% if (ParkhausServlet.hasNoViews()){
			out.print("<h2><t>looks like you did not choose any options for graphics</h2>");
		} else{
			ArrayList<ViewIF> views = ParkhausServlet.getViews();
			for (ViewIF view : views){
				out.print(view.getData());
				out.print("<br><br>");
			}
			out.print(ParkhausServlet.getTabelleData());
		}
		%>
	</body>
</html>
