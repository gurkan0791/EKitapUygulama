<%-- 
    Document   : urungoster
    Created on : 10.May.2015, 16:38:03
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0;">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpanel.css">
        <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <title>JSP Page</title>
    
</head>
<body>
    <jsp:include page="aheader.jsp"></jsp:include>
   <div class="container" style="width: 100%;">
    <div class="row">
 <div class="col-md-3 col-lg-2">
    <ul  class="nav nav-pills nav-stacked">
    <li  class="active"><a href="#">GÖSTERGE PANELİ</a></li>
    <li ><a href="/kategorigoster">KATALOG</a>
        <ul >
            <li><a href="#" data-toggle="tab">Ürünler</a></li>
            <li><a href="/kategorigoster?altKatID=0" >Kategoriler</a></li>
            <li><a href="" data-toggle="tab">Kategori</a></li>
            <li><a href="#" data-toggle="tab">Css</a></li>
            <li><a href="#" data-toggle="tab">JavaScript</a></li>
        </ul>
    </li>
    <li ><a href="/kategorigoster" >İLETİŞİM</a>
    </ul>
 </div>
        <!--urun Goster-->
        <div class="col-md-9 col-lg-10">
            
        <table  class="table table-hover">
    <tr>
    <th>ID</th>
    <th>ALTID</th>
    <th>AD</th>
    <th>Açıklama</th>
    <th>Güncelle</th>
    </tr>

    <c:forEach items="${urunliste}" var="i">   
        <tr>
            
            <td> <c:out value="${i.kitapID}"></c:out> </td>
            <td><c:out value="${i.kitapAD}"></c:out></td>
            <td><c:out value="${i.yayinEviID}"></c:out></a></td>
            <td> <c:out value="${i.yazarID}"></c:out></td>
            <td> <c:out value="${i.kategoriID}"></c:out></td>
            <td> <c:out value="${i.aciklama}"></c:out></td>
            </a>
            <%--<c:out value="${i.kategoriResimUrl}"></c:out>--%>
            <td><a href="/urunguncelle?urunID=<c:out value="${i.kitapID}"></c:out>">Düzenle</a></td>
        </tr>
        
    </c:forEach>
</table>  
            
            <nav>
  <ul class="pagination">
    <li>
      <a href="urungoster?id=1" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="1" end="${sayfasayisi}" step="1" var="i">
        <c:choose>
            <c:when test="${empty param.id || param.id>sayfasayisi || param.id<=0}">
                <c:choose>
                    <c:when test="${i eq 1}">
                        <li><a style="color:red;" id="${i}" href="urungoster?id=${i}">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                    <li><a id="${i}" href="urungoster?id=${i}">${i}</a></li>
                    </c:otherwise>
                </c:choose> 
            </c:when>
        <c:when test="${param.id ne i}">
          <li><a id="${i}" href="urungoster?id=${i}">${i}</a></li>        
        </c:when>    
        <c:otherwise>
          <li><a style="color:red;" id="${i}" href="urungoster?id=${i}">${i}</a></li>
        </c:otherwise>
        </c:choose>
    </c:forEach>
    <li>
      <a href="urungoster?id=${sayfasayisi}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
            
        </div>
    </div>
   </div>
</body>
</html>
