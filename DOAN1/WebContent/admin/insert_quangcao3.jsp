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


   %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Thêm Sản Phẩm</h3>
	<form action ="/DOAN1/QUANLYQUANGCAOsevlet"enctype="multipart/form-data" method="post">
                  

                    <table width="95%">
                        <tr><td width="125px"><b>Tên Quảng Cáo</b></td><td>
                        <input type="text" class="pendek" name="TenQC"><b style="color: red">vui lòng nhập hết thông tin</b></td></tr>
                     

                                  <tr><td><b>Hình
            						<input type="file" name="file" />
                                		 
                                    <tr><td><b>Link</b></td><td><input type="text" class="panjang"name="Link"><b style="color: red">vui lòng nhập hết thông tin</b></td></tr>
    

         
      						
                                 
                            </td></tr>
                          
                        <tr><td></td><td>
                                     <input  type="hidden" name ="command" value="insert">
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
