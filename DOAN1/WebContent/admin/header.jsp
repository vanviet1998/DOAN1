<%-- 
    Document   : header
    Created on : 19-May-2016, 7:18:44 PM
    Author     : TUNGDUONG
--%>

<%@page import="model.DangNhap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
    </head>
    <body>
    <% 
    DangNhap dn = null;

if (session.getAttribute("dn") != null) {
    
	 dn = (DangNhap)session.getAttribute("dn");
  }

%>

        <div id="header">
            <div class="inHeader" >
           	
                <div class="mosAdmin">
                <%if(dn != null) {%>
                    Hello, <%=dn.getTenDangNhap() %><br>
                      <a href="/DOAN1/Dangxuat?command=admin">Đăng Xuất</a> 
                    <%} %>
                   | <a href="loginadmin.jsp">Login</a>
                </div>
                <div class="clear"></div>
                
            </div>
        </div> 

    </body>
</html>
