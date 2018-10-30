<%-- 
    Document   : manager_product
    Created on : 19-May-2016, 7:33:54 PM
    Author     : TUNGDUONG
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
    <%
    SanPhamDAO dao = new SanPhamDAO();
    ArrayList <SanPham> list= dao.getListSanPham();
   					
    %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Danh Sách Sản Phẩm</h3>

                   <a href="${root}/admin/insert_product.jsp">THÊM SẢN PHẨM</a>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">MaSP</th>
                            <th class="data">Tên Sản Phẩm</th>
                            <th class="data">Mã Loại</th>
                             <th class="data">Nơi Sản Xuất</th>
                               <th class="data">Giá Sản Phẩm</th>
                               <th class="data">Ảnh Sản Phẩm</th>
                               <th class="data">Chi Tiết Sản Phẩm</th>
                            <th class="data" width="75px">Tùy Chọn</th>
                        </tr>
                        <%
                        int count =0;
                        for(SanPham sp : list){
                        	count++;
                        
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%= count %></td>
                            <td class="data"><%= sp.getMaSP()%></td>
                            <td class="data"><%= sp.getTenSP()%></td>
                             <td class="data"><%= sp.getMaLoai()%></td>
                              <td class="data"><%= sp.getNoiSanXuat()%></td>
                               <td class="data"><%= sp.getGiaSP()%></td>
                                <td class="data"><%= sp.getAnhSP()%></td>
                                 <td class="data"><%= sp.getChiTietSP()%></td>
                            <td class="data" width="75px">
                        <center>
                            <a href="${root}/admin/update_product.jsp?command=update&MaSP=<%=sp.getMaSP()%>&loaisp=<%=sp.getMaLoai()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                            <a href="/DOAN1/QUANLYSANPHAMsevlet?command=delete&MaSP=<%=sp.getMaSP()%>">Xóa</a>
                        </center>
                        </td>
                        </tr>
		<%} %>
                    </table>
                </div>
                <div class="clear"></div>
            	<div class="container">
            		<div class="row">
            		<nav aria-label="Page navigation example">
						  <ul class="pagination">
						    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
						    <li class="page-item"><a class="page-link" href="#">1</a></li>
						    <li class="page-item"><a class="page-link" href="#">2</a></li>
						    <li class="page-item"><a class="page-link" href="#">3</a></li>
						    <li class="page-item"><a class="page-link" href="#">Next</a></li>
						  </ul>
					</nav>
            		</div>
            	</div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
