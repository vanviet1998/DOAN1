<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

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
LoaiSPDAO loaispdao = new LoaiSPDAO();
ArrayList<LoaiSP> listCategory = loaispdao.getlistLoaiSP();

	String error ="";
   if(request.getAttribute("error")!=null)
   {
   	error = (String) request.getAttribute("error");
   }
   %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Thêm Sản Phẩm</h3>
	<form action ="/DOAN1/QUANLYSANPHAMsevlet"enctype="multipart/form-data" method="post">
                  

                    <table width="95%">
                        <tr><td width="125px"><b>Tên Sản Phẩm</b></td><td>
                        <input type="text" class="pendek" name="TenSanPham"><b style="color: red">vui lòng nhập hết thông tin</b></td></tr>
                        <tr><td><b>Nơi Sản Xuất</b></td><td><input type="text" class="panjang"name="NoiSanXuat"> <b style="color: red">  vui lòng nhập hết thông tin</b></td></tr>
                            <tr><td><b>Giá Sản Phẩm</b></td><td><input type="text" class="panjang"name="GiaSanPham"><b style="color: red">vui lòng nhập Số</b></td></tr>
<!--                                 <tr><td><b>Ảnh Sản Phẩm</b></td><td><input type="text" class="panjang"name="AnhSanPham"></td></tr> -->
                                  <tr><td><b>Ảnh Sản Phẩm
            						<input type="file" name="file" />
                                		 
                                    <tr><td><b>Chi Tiết Sản Phẩm</b></td><td><input type="text" class="panjang"name="ChiTietSanPham"><b style="color: red">vui lòng nhập hết thông tin</b></td></tr>
    

         
      								 <tr><td><b>Loại Sản Phẩm</b></td><td>
                     				       
                                <select name="maloai">
                            <%for(LoaiSP loaisp : listCategory){ %>
                    
                                      <option  value="<%=loaisp.getMaLoai()%>"><%= loaisp.getTenLoai() %></option>
                                          <%} %> 
                                  
                            			
                                </select>
                                 
                            </td></tr>
                          
                        <tr><td></td><td>
                                     <input type="hidden" name ="command" value="insert">
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
