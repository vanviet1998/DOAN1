<%-- 
    Document   : manager_category
    Created on : 19-May-2016, 7:30:15 PM
    Author     : TUNGDUONG
--%>


<%@page import="model.LoaiSP"%>
<%@page import="DAO.LoaiSPDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý danh mục</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>

        <%
            LoaiSPDAO loaispdao = new LoaiSPDAO();
            ArrayList<LoaiSP> listCategory = loaispdao.getlistLoaiSP();
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quản lý danh mục</h3>
                    
                    <a href="${root}/admin/insert_category.jsp">Thêm danh mục</a>

                    <table class="data">

                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">Mã danh mục</th>
                            <th class="data">Tên danh mục</th>
                            <th class="data" width="90px">Tùy chọn</th>
                        </tr>

                        <%
                            int count = 0;
                            for(LoaiSP loaisp : listCategory){
                                count++;
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=loaisp.getMaLoai()%></td>
                            <td class="data"><%=loaisp.getTenLoai()%></td>
                            <td class="data" width="90px">
                            <center>
                                <a href="${root}/admin/update_category.jsp?command=update&MaLoai=<%=loaisp.getMaLoai()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                                <a href="/DOAN1/QuanLyLoaiSanPhamsevlet?command=delete&MaLoai=<%=loaisp.getMaLoai()%>">Xóa</a>
                            </center>
                            </td>
                        </tr>
                        <%}%>

                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
