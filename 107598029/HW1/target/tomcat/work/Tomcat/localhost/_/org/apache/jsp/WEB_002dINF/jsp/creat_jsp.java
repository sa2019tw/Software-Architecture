/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2019-03-28 04:27:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class creat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/header.jsp", Long.valueOf(1553746968821L));
    _jspx_dependants.put("/WEB-INF/jsp/bar.jsp", Long.valueOf(1553746968819L));
  }

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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      out.write("<title>課程系統</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@8\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"#\">\r\n");
      out.write("        <span class=\"h3 mx-1\">課程系統</span>\r\n");
      out.write("    </a>\r\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("        <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("            <li class=\"nav-item active\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/list\" role=\"button\">列出所有課程</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/creat\" role=\"button\">新增課程</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <form class=\"form-inline my-2 my-lg-0\" action=\"find\">\r\n");
      out.write("            <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\" aria-label=\"Search\" name=\"cname\">\r\n");
      out.write("            <input type=\"submit\" class=\"btn btn-outline-success my-2 my-sm-0\" role=\"button\"></input>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <form action=\"/creat\" method=\"post\">\r\n");
      out.write("        <div class=\"form-row\">\r\n");
      out.write("            <div class=\"form-group col-md-4\">\r\n");
      out.write("                <label for=\"coursename\">課程名稱</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"coursename\" name=\"coursename\" placeholder=\"Course Name\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group col-md-4\">\r\n");
      out.write("                <label for=\"level\">適合對象</label>\r\n");
      out.write("                <select id=\"level\" name=\"level\" class=\"form-control\">\r\n");
      out.write("                    <option selected value=\"大一\">大一</option>\r\n");
      out.write("                    <option value=\"大二\">大二</option>\r\n");
      out.write("                    <option value=\"大三\">大三</option>\r\n");
      out.write("                    <option value=\"大四\">大四</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group col-md-4\">\r\n");
      out.write("                <label for=\"courseprice\">定價</label>\r\n");
      out.write("                <input type=\"number\" class=\"form-control\" name=\"courseprice\" id=\"courseprice\" placeholder=\"Price\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group col-md-6\">\r\n");
      out.write("                <label for=\"coursedescription\">課程說明</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"coursedescription\" id=\"coursedescription\" placeholder=\"Description\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group col-md-6\">\r\n");
      out.write("                <label for=\"precautions\">注意事項</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"precautions\" id=\"precautions\" placeholder=\"Description\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group col-md-12\">\r\n");
      out.write("                <label for=\"remarks\">備註</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"remarks\" id=\"remarks\" placeholder=\"Remarks\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary\">送出</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("        src=\"https://code.jquery.com/jquery-3.3.1.min.js\"\r\n");
      out.write("        integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\"\r\n");
      out.write("        crossorigin=\"anonymous\">\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
