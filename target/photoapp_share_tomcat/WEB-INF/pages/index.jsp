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

<%--
  Retrieve the attributes
--%>
<%
    final String[] photos = (String[])request.getAttribute("photos");
    final Event event = (Event) request.getAttribute("event");
    final EventText eventText = event.getEventText();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../resources/css/main.css" rel="stylesheet" type="text/css">

    <%--
    Set the favicon and title
    --%>
    <link rel="icon" href="<%=eventText.logo%>">
    <link rel="shortcut icon" type="image/x-icon" href="<%=eventText.logo%>">
    <title>
        <%if (eventText.getTabTitle()==null||eventText.getTabTitle().equals("")){%>
        <%=eventText.getEventName()%>
        <%} else { %>
        <%=eventText.getTabTitle()%>
        <%}%>
    </title>
    <meta property="og:image" content="<%=eventText.logo%>" />
</head>

<%--
  Set the backgroundimage if isBackGroundImageToggle==true.
  Set the backgroundcolor if isBackGroundImageToggle==false.
--%>
<body
        <%if (event.eventText.isBackgroundImageToggle()){%>
            style="background-image: url(<%=eventText.getBackgroundImage()%>)"
        <%} else {%>
            style="background-color: <%=eventText.getBackgroundColor()%>"
        <%}%>
>

<%--
  Set the eventLogo
--%>
<div id="logo">
    <%if (eventText.logo!=null){%>
    <img src="<%=eventText.logo%>">
    <%}%>
</div>

        <%--
        Set the text under the logo (textUpper). (The main title of the page)
        --%>
        <%if (eventText.getTextUpper()==null||eventText.getTextUpper().equals("")){%>
        <%} else {%>
    <div id="textUpper">
        <p style="color: <%=eventText.getTextColor()%>"><%=event.getEventText().textUpper%></p>
    </div>
        <%}%>

    <%--
    Set the text above the photo's (textAbovePhoto)
    --%>
    <%if (eventText.getTextAbovePhoto()==null||eventText.getTextAbovePhoto().equals("")){%>
    <%} else {%>
    <div id="textAbove">
        <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextAbovePhoto()%></p>
    </div>
    <%}%>

    <%--
    Display the selected photo's
    --%>
    <div class="images">
        <%for (int i=0; i<photos.length; i++){%>
        <%=photos[i]%>
        <%}%>
</div>
<%--
Set the text under the photo's (textUnderPhoto)
--%>
<%if (eventText.getTextUnderPhoto()==null||eventText.getTextUnderPhoto().equals("")){%>
<%} else {%>
<div id="textUnderPhoto">
    <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextUnderPhoto()%></p>
</div>
<%}%>
<%--
Set the QR-code (qrCodeImage)
--%>
<div id="qr">
    <%if (eventText.qrCodeImage!=null){%>
    <img src="<%=eventText.qrCodeImage%>">
    <%}%>
</div>
<%--
Set the bottom text (textBottom)
--%>
<%if (eventText.getTextBottom()==null||eventText.getTextBottom().equals("")){%>
<%} else {%>
<div id="textBottom">
    <p style="color: <%=eventText.getTextColor()%>"><%=eventText.getTextBottom()%></p>
</div>
<%}%>
</body>
</html>
