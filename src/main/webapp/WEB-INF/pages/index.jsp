<%@ page import="java.util.Map" %>
<%@ page import="dom.EventText" %><%--
  Created by IntelliJ IDEA.
  User: stijnergeerts
  Date: 5/05/17
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String favicon = (String)request.getAttribute("favicon");
    final String linkIcon = (String)request.getAttribute("linkIcon");
    final String logo = (String)request.getAttribute("logo");
    final String qr = (String)request.getAttribute("qr");
    final String backgroundImage = (String)request.getAttribute("backgroundImage");
    final String[] photos = (String[])request.getAttribute("photos");
    final EventText eventText = (EventText)request.getAttribute("eventText");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../resources/css/main.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="<%=favicon%>">
    <title>
        <%if (eventText.getTextUpper()==null||eventText.getTextUpper().equals("")){%>
        <%=eventText.getCloudinaryDirectory()%>
        <%} else { %>
        <%=eventText.getTextUpper()%>
        <%}%>
    </title>
</head>
<body
        <%if (backgroundImage==null||backgroundImage.equals("")){
            if (eventText.getBackgroundColor()==null||eventText.getBackgroundColor().equals("")){%>
        <%} else {%>
        style="background-color: <%=eventText.getBackgroundColor()%>"
        <%}%>
        <%} else {%>
        style="background-image: url(<%=backgroundImage%>)"
        <%}%>
>
<div id="logo">
    <%=logo%>
    <img src="<%=linkIcon%>" class="hidden">
</div>
<%if (eventText.getTextUpper()==null||eventText.getTextUpper().equals("")){%>
<%} else {%>
<div id="textUpper">
    <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextUpper()%></p>
</div>
<%}%>
<div class="images">
    <%for (int i=0; i<photos.length; i++){%>
    <%=photos[i]%>
    <%}%>
</div>
<%if (eventText.getTextUnderPhoto()==null||eventText.getTextUnderPhoto().equals("")){%>
<%} else {%>
<div id="textUnderPhoto">
    <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextUnderPhoto()%></p>
</div>
<%}%>
<div id="qr">
    <%=qr%>
</div>
<%if (eventText.getTextBottom()==null||eventText.getTextBottom().equals("")){%>
<%} else {%>
<div id="textBottom">
    <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextBottom()%></p>
</div>
<%}%>
</body>
</html>
