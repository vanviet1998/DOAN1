<%-- 
    Document   : manager_product
    Created on : 19-May-2016, 7:33:54 PM
    Author     : TUNGDUONG
--%>

<%@page import="model.ChiTietHoaDon"%>
<%@page import="DAO.ChiTietHoaDonDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.HoaDon"%>
<%@page import="DAO.HoaDonDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Bill</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
<%
String Mahd=request.getParameter("MaHD");
ChiTietHoaDonDAO cthd = new ChiTietHoaDonDAO();
ArrayList<ChiTietHoaDon> list = cthd.getlistHoaDOn(Mahd);
%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Chi Tiết Hóa Đơn</h3>
    
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">MaChiTietHD</th>
                            <th class="data">MaHD</th>
                            <th class="data">MaSP</th>
                            <th class="data">SoLuong</th>
                             <th class="data">Đơn Giá</th>
                              <th class="data">Ngày Nhận</th>
                 
                        </tr>
                        <% int count=0;
                       
                        for(ChiTietHoaDon ct: list){
                      	 
                        count++;
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%= count%></td>
                            <td class="data"><%= ct.getMaChiTietHD() %></td>
                            <td class="data"><%= ct.getMaHD()%></td>
                            <td class="data"><%= ct.getMaSP()%></td>
                              <td class="data"><%= ct.getSoLuong()%></td>
                                <td class="data"><%= ct.getGia()%></td>
                                  <td class="data"><%= ct.getNgayNhan()%></td>
                                    
                      
                        </tr>
                        
                        <%} %>

                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
