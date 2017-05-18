<%@ page import="java.util.Map" %>
<%@ page import="dom.EventText" %>
<%@ page import="dom.Event" %><%--
  Created by IntelliJ IDEA.
  User: stijnergeerts
  Date: 5/05/17
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String favicon = (String)request.getAttribute("favicon");
    final String logo = (String)request.getAttribute("logo");
    final String qrCode = (String)request.getAttribute("qrCode");
    final String backgroundImage = (String)request.getAttribute("backgroundImage");
    final String[] photos = (String[])request.getAttribute("photos");
    final Event event = (Event) request.getAttribute("event");
    final EventText eventText = event.getEventText();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../resources/css/main.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="<%=logo%>">
    <link rel="shortcut icon" type="image/x-icon" href="<%=logo%>">
    <title>
        <%if (eventText.getTextUpper()==null||eventText.getTextUpper().equals("")){%>
        <%=eventText.getCloudinaryDirectory()%>
        <%} else { %>
        <%=eventText.getTextUpper()%>
        <%}%>
    </title>
    <meta property="og:image" content="<%=logo%>" />
</head>
<body
        <%if (event.eventText.isBackgroundImageToggle()){%>
            style="background-image: url(<%=eventText.getBackgroundImage()%>)"
        <%} else {%>
            style="background-color: <%=eventText.getBackgroundColor()%>"
        <%}%>
>
<div id="logo">
    <%if (logo!=null){%>
    <img src="<%=logo%>">
    <%}%>
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
    <%if (qrCode!=null){%>
    <img src="<%=qrCode%>">
    <%}%>
</div>
<%if (eventText.getTextBottom()==null||eventText.getTextBottom().equals("")){%>
<%} else {%>
<div id="textBottom">
    <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextBottom()%></p>
</div>
<%}%>
</body>
</html>
