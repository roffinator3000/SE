<%--Created by IntelliJ IDEA.						Change this in: File | Settings | Editor | File and Code Templates | Other
	Author:			R. Kuhn
	Date			07.09.2020
	Time			18:17
	Time spent:		1 h
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Servlet.ParkhausServlet" %>
<%@ page import="views.ViewIF" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<title>Views - Semesterprojekt Parkhaus</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script src="plotly-latest.min.js"></script>
<%--		<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>--%>

<%--		<meta http-equiv="refresh" content="5"/>--%>
		
		<script type="text/javascript">
			
			setInterval(function () {
				page_refresher();
			}, 1500);		//refreshes the page every x seconds if needed
			
			async function page_refresher() {
				var boo = refresh_post_event();
				if (((await boo).localeCompare("true")) == 0) {
					// window.location.reload(true);
					location.reload();
				}
			}
			
			/*	based on content from 'parkhaus-9.1.7.js'	*/
			
			async function refresh_post_event() {
				const request = "gotNewData";
				const response = await fetch(new Request("${pageContext.request.contextPath}/Parkhaus"), {
					method: 'POST',
					mode: 'cors',
					cache: 'no-store',
					body: request,
					headers: {'Content-Type': 'text/plain'}
				});
				const response_string = (await response.text()).trim();
				// const result = command_interpreter(response_string);
				// console.log(response_string);
				return response_string;
			}
			
			/*		/'parkhaus-9.1.7.js'		 */
		
		</script>
	
	</head>
	<body>
		<div class="header">
			<a class="logo"> Verwaltungsübersicht</a>
			<div class="header-right">
				<a class="active" href="${pageContext.request.contextPath}">Start-Page</a>
			</div>
		</div>
		<br>
		
		<% if (ParkhausServlet.hasNoViews()){
			out.print(
						"<div class='textView'>" +
						"<h2><t>looks like you did not choose any options for graphics</h2>" +
						"</div>"
					);
		} else{
			ArrayList<ViewIF> views = ParkhausServlet.getViews();
			for (ViewIF view : views){
				out.println(view.getData());
				out.println("<br>");
			}
			out.println(ParkhausServlet.getTabelleData());
		}
		%>
		
		<%--Author:			Lawin Daskin
			Date			03.10.2020
			Time			13:24
			Time spent:		20 m	--%>
		<script>window.onload = () => {
			for (const func of window.load)
				func();
		}</script>
		<%--	/Lawin Daskin	--%>
	</body>
</html>
