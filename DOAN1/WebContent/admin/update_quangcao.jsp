<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page import="model.QuangCao"%>
<%@page import="DAO.QuangCaoDAO"%>
<%@page import="model.LoaiSP"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.LoaiSPDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
<%
String MaQC = request.getParameter("MaQC");
QuangCaoDAO qcdao = new QuangCaoDAO();
ArrayList<QuangCao> listqc = qcdao.getListQuangCaobymaQC(MaQC);


   %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Thêm Sản Phẩm</h3>
	<form action ="/DOAN1/QUANLYQUANGCAOsevlet"enctype="multipart/form-data" method="post">
                  

                    <table width="95%">
                    <% for(QuangCao qc : listqc){ %>
                        <tr><td width="125px"><b>Tên Quảng Cáo</b></td><td>
                        <input type="text" class="pendek" name="TenQC" value="<%=qc.getTenQC() %>"></td></tr>
                     

                                  <tr><td><b>Hình
            						<input type="file" name="file" />
                                		    <input type="hidden" name ="hinhqc" value="<%=qc.getHinh()%>">
                                    <tr><td><b>Link</b></td><td><input type="text" class="panjang"name="Link" value="<%=qc.getLink() %>"></td></tr>
    

         <%} %>
      						
                                 
                            </td></tr>
                          
                        <tr><td></td><td>
                                     <input  type="hidden" name ="command" value="update">
                                          <input type="hidden" name ="MaQC" value="<%=MaQC %>">
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
