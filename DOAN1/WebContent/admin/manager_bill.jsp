<%-- 
    Document   : manager_product
    Created on : 19-May-2016, 7:33:54 PM
    Author     : TUNGDUONG
--%>

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
HoaDonDAO hddao = new HoaDonDAO();
ArrayList<HoaDon> listhd= hddao.getlistHoaDOn();

%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quản Lý Hóa Đơn</h3>
                  
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">MaHD</th>
                            <th class="data">MaKH</th>
                            <th class="data">Ngày Mua</th>
                             <th class="data">Tổng Tiền</th>
                              <th class="data">Tên KH</th>
                               <th class="data">Địa Chỉ</th>
                                <th class="data">SĐT</th>
                            <th class="data" width="75px">Tùy Chọn</th>
                        </tr>
                        <% int count=0;
                        for(HoaDon hd : listhd) {
                        count++;
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%= count%></td>
                            <td class="data"><%= hd.getMaHD() %></td>
                            <td class="data"><%= hd.getMaKH()%></td>
                            <td class="data"><%= hd.getNgayMua() %></td>
                              <td class="data"><%= hd.getTongTien()%></td>
                                <td class="data"><%= hd.getTenKH() %></td>
                                  <td class="data"><%= hd.getDiaChi()%></td>
                                    <td class="data"><%= hd.getSDT() %></td>
                            <td class="data" width="75px">
                        <center>
                            <a href="${root}/admin/manager_detalbill.jsp?&MaHD=<%=hd.getMaHD()%>"><img src="">Chi Tiết</a>&nbsp;&nbsp; &nbsp;&nbsp;
                            <a href="/DOAN1/QUANLYHOADONsevlet?MaHD=<%=hd.getMaHD()%>"><img src="">Hủy</a>
                        </center>
                        </td>
                        </tr>
                        <%} %>

                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
