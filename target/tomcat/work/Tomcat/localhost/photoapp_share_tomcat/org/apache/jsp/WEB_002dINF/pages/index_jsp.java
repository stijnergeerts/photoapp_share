/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-05-15 03:46:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import dom.EventText;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');

    final String favicon = (String)request.getAttribute("favicon");
    final String linkIcon = (String)request.getAttribute("linkIcon");
    final String logo = (String)request.getAttribute("logo");
    final String qr = (String)request.getAttribute("qr");
    final String backgroundImage = (String)request.getAttribute("backgroundImage");
    final String[] photos = (String[])request.getAttribute("photos");
    final EventText eventText = (EventText)request.getAttribute("eventText");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link href=\"../../resources/css/main.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link rel=\"icon\" href=\"");
      out.print(favicon);
      out.write("\">\n");
      out.write("    <title>\n");
      out.write("        ");
if (eventText.getTextUpper()==null||eventText.getTextUpper().equals("")){
      out.write("\n");
      out.write("        ");
      out.print(eventText.getCloudinaryDirectory());
      out.write("\n");
      out.write("        ");
} else { 
      out.write("\n");
      out.write("        ");
      out.print(eventText.getTextUpper());
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </title>\n");
      out.write("    <meta property=\"og:image\" content=\"");
      out.print(favicon);
      out.write("\" />\n");
      out.write("</head>\n");
      out.write("<body\n");
      out.write("        ");
if (backgroundImage==null||backgroundImage.equals("")){
            if (eventText.getBackgroundColor()==null||eventText.getBackgroundColor().equals("")){
      out.write("\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        style=\"background-color: ");
      out.print(eventText.getBackgroundColor());
      out.write("\"\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        style=\"background-image: url(");
      out.print(backgroundImage);
      out.write(")\"\n");
      out.write("        ");
}
      out.write("\n");
      out.write(">\n");
      out.write("<div id=\"logo\">\n");
      out.write("    ");
      out.print(logo);
      out.write("\n");
      out.write("    <img src=\"");
      out.print(linkIcon);
      out.write("\" class=\"hidden\">\n");
      out.write("</div>\n");
if (eventText.getTextUpper()==null||eventText.getTextUpper().equals("")){
      out.write('\n');
} else {
      out.write("\n");
      out.write("<div id=\"textUpper\">\n");
      out.write("    <p style=\"color: ");
      out.print(eventText.getTextColor());
      out.write('"');
      out.write('>');
      out.print(eventText.getTextUpper());
      out.write("</p>\n");
      out.write("</div>\n");
}
      out.write("\n");
      out.write("<div class=\"images\">\n");
      out.write("    ");
for (int i=0; i<photos.length; i++){
      out.write("\n");
      out.write("    ");
      out.print(photos[i]);
      out.write("\n");
      out.write("    ");
}
      out.write("\n");
      out.write("</div>\n");
if (eventText.getTextUnderPhoto()==null||eventText.getTextUnderPhoto().equals("")){
      out.write('\n');
} else {
      out.write("\n");
      out.write("<div id=\"textUnderPhoto\">\n");
      out.write("    <p style=\"color: ");
      out.print(eventText.getTextColor());
      out.write('"');
      out.write('>');
      out.print(eventText.getTextUnderPhoto());
      out.write("</p>\n");
      out.write("</div>\n");
}
      out.write("\n");
      out.write("<div id=\"qr\">\n");
      out.write("    ");
      out.print(qr);
      out.write("\n");
      out.write("</div>\n");
if (eventText.getTextBottom()==null||eventText.getTextBottom().equals("")){
      out.write('\n');
} else {
      out.write("\n");
      out.write("<div id=\"textBottom\">\n");
      out.write("    <p style=\"color: ");
      out.print(eventText.getTextColor());
      out.write('"');
      out.write('>');
      out.print(eventText.getTextBottom());
      out.write("</p>\n");
      out.write("</div>\n");
}
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
