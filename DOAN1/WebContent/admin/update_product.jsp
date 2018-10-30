<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page import="model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
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
String loai = request.getParameter("loaisp");
String id = request.getParameter("MaSP");
SanPham sp = new SanPhamDAO().getSanPham(id);
LoaiSPDAO loaispdao = new LoaiSPDAO();
ArrayList<LoaiSP> listCategory = loaispdao.getlistLoaiSP();
LoaiSP loaisp1 = loaispdao.getloaispbyMaLoai(loai);
%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Sửa Sản Phẩm</h3>
	<form action ="/DOAN1/QUANLYSANPHAMsevlet"enctype="multipart/form-data" method="post">
                  

                    <table width="95%">
                        <tr><td width="125px"><b>Tên Sản Phẩm</b></td><td>
                        <input type="text" class="pendek" name="TenSanPham"value="<%=sp.getTenSP()%>"></td></tr>
                        <tr><td><b>Nơi Sản Xuất</b></td><td><input type="text" class="pendek"name="NoiSanXuat"value="<%=sp.getNoiSanXuat()%>"></td></tr>
                            <tr><td><b>Giá Sản Phẩm</b></td><td><input type="text" class="pendek"name="GiaSanPham"value="<%=sp.getGiaSP()%>"></td></tr>
<%--                                 <tr><td><b>Ảnh Sản Phẩm</b></td><td><input type="text" class="panjang"name="AnhSanPham"value="<%=sp.getAnhSP()%>"></td></tr> --%>
                                    <tr><td><b>Ảnh Sản Phẩm
            						<input type="file" name="file" />
                                    <tr><td><b>Chi Tiết Sản Phẩm</b></td><td><input type="text" class="panjang"name="ChiTietSanPham"value="<%=sp.getChiTietSP()%>"></td></tr>
                
                        <tr><td><b>Loại Sản Phẩm</b></td><td>
                     				       
                                <select name="maloai">
                                	<option value="<%= loaisp1.getMaLoai() %>" selected=""><%= loaisp1.getTenLoai() %></option>
                            <%for(LoaiSP loaisp : listCategory){ %>
                    			
                                      <option  value="<%=loaisp.getMaLoai()%>"><%= loaisp.getTenLoai() %></option>
                                          <%} %> 
                                  
                            			
                                </select>
                                 
                            </td></tr>
                          
                        <tr><td></td><td>
                                     <input type="hidden" name ="command" value="update">
                                         <input type="hidden" name ="MaSP" value="<%=id %>">
                                          <input type="hidden" name ="anhsp" value="<%=sp.getAnhSP() %>">
                                <input type="submit" class="button" value="Sửa">
                            </td></tr>
                    </table>
                      </form>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
