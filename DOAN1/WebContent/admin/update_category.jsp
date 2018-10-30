<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập Nhập Danh Mục</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
    <%
	String error ="";
    if(request.getParameter("error")!=null)
    {
    	error = (String) request.getParameter("error");
    }
    %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Cập Nhập Danh Mục</h3>
					<form action ="/DOAN1/QuanLyLoaiSanPhamsevlet" method="post">
             
                    <table width="95%">
                        <tr><td style="float: right"><b>Tên Danh Mục:</b></td><td>
                        <input type="text" class="sedang" name="tendanhmuc"><%= error%></td>
                        </tr>
                      
                       
                        <tr><td></td><td>
                             <input type="hidden" name ="command" value="update">
                             <input type="hidden" name ="MaLoai" value="<%=request.getParameter("MaLoai") %>">
                                <input type="submit" class="button" value="Lưu">
                           
                            </td></tr>
                            
                    </table>
                    </form>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
