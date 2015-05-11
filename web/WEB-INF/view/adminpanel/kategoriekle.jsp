<%-- 
    Document   : kategoriekle
    Created on : 18.Nis.2015, 21:47:44
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
        <div class="col-md-9 col-lg-10">
            
    <form action="/kategoriekle" method="post">
    Ana Kategori    
<div id="scrollkategori" style="height: 150px; overflow: scroll;">
    <ul>
                <li><input type="radio" name="katidd" value="0"></input>Root
    <c:forEach items="${katliste}" var="i">
        
            
<!--        <tr>
            
            <td> <c:out value="${i.kategoriID}"></c:out> </td>
            <td><c:out value="${i.altKategoriID}"></c:out></td>
            <td><a href="/kategorigoster?altKatID=<c:out value="${i.kategoriID}"></c:out>"> <c:out value="${i.kategoriADI}"></c:out></a></td>
            <td> <c:out value="${i.kategoriAciklama}"></c:out></td>
            </a>
            <%--<c:out value="${i.kategoriResimUrl}"></c:out>--%>
            <td><a href="/kategoriguncelle?katID=<c:out value="${i.kategoriID}"></c:out>">Düzenle</a></td>
        </tr>-->
            
            <ul style="margin-left: 20px;">
            <c:set value="${i.kategoriID}" var="ustID"></c:set>    
            <c:if test="${i.altKategoriID eq 0}">
                <li><input type="radio" name="katidd" value="${i.kategoriID}"></input> ${i.kategoriADI}
                    <c:forEach items="${katliste}" var="j">
                        <c:set value="${j.kategoriID}" var="austID"></c:set>
                    <ul style="margin-left: 40px;">
                        <c:if test="${ustID eq j.altKategoriID}">
                            <li><input type="radio" name="katidd" value="${j.kategoriID}"></input>${j.kategoriADI}
                                <c:forEach items="${katliste}" var="k">
                                    <ul style="margin-left:60px;">
                                        <c:if test="${austID eq k.altKategoriID}">
                                        <li>${k.kategoriADI}</li>
                                        </c:if>
                                    </ul>
                                </c:forEach>
                            </li>
                        </c:if>
                    </ul>
                    </c:forEach>
                </li>
                
            </c:if>
       
            </ul>
    </c:forEach>
</li>
</ul>
            
</div>
        <pre>
        * Adı    : <input type="text" name="katadi"></input>
        Açıklama : <textarea cols="40" rows="20" name="aciklama"></textarea>
        <input type="submit" value="Ekle"></input>
        </pre>
    </form>
            
        </div> 
    </div>
   </div><!--container-->
   
    
</body>
</html>
