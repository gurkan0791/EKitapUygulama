<%-- 
    Document   : adminpanel
    Created on : 12.Nis.2015, 17:17:47
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
        <script type="text/javascript">
            $(document).ready(function (){
                jQuery('#logout').click(function(){
                     return true;
                });
            $("#oturumBilgi").click(function (){
               if ( $("#oturumKapa").is(":visible") ) {
                $("#oturumKapa").hide();
               } else { 
                $("#oturumKapa").show();
             }     
                
                return false;
            });    
                $("#oturumKapa").click(function(e) {
                    
                e.stopPropagation(); 
                return true;
           
            });
            });
            $(document).click(function() {
                $("#oturumKapa").hide();
                
             });
            
            //nav bölümü açılır kapanır liste
            
            $(document).on("click","li.menus",function(){
                
                $(this).addClass("secili");
                $(".alt_menus", this).show();
            });
            
        </script>
    </head>
    <body style="padding-top: 70px;">
    
    <header>
        <div id="uygulamaAdi">Yönetim Paneli</div>
        <div id="oturumBilgi">
            <div class="oturumclass" id="oturumResim">
               <img src="" width="40px;" height="40px;"></img>
            </div>
            <div class="oturumclass" id="oturumIsım">
                <c:out value="${sessionScope.calisanlar.ad}"></c:out>
                <c:out value="${sessionScope.calisanlar.soyad}"></c:out></br>
            </div>
            <div style="clear:both;"></div>
            <div id="oturumKapa">
                <img src="" height="100px;" width="100px;" ></img>
                <c:if test="${not empty sessionScope.calisanlar}" >
                    <form  id="logout" action="${pageContext.request.contextPath}/logout" method="post">
                        <input style="color:black;" type="submit" value="Logout" />
                    </form>
                </c:if>
            </div>
            <div style="clear:both;"></div>
        </div>
        
    </header>    
<div class="container" style="width: 100%;">
    <div class="row">
 <div class="col-md-3 col-lg-2">
    <ul  class="nav nav-pills nav-stacked">
    <li  class="active"><a href="#">GÖSTERGE PANELİ</a></li>
    <li ><a href="#">KATALOG</a>
        <ul >
            <li><a href="#" data-toggle="tab">Ürünler</a></li>
            <li><a href="/kategorigoster?altKatID=0" >Kategoriler</a></li>
            <li><a href="" data-toggle="tab">Kategori</a></li>
            <li><a href="#" data-toggle="tab">Css</a></li>
            <li><a href="#" data-toggle="tab">JavaScript</a></li>
        </ul>
    </li>
    <li ><a href="#kategori" data-toggle="tab">İLETİŞİM</a>
    </ul>
 </div>
        <div class="col-md-9 col-lg-10">
  <div class="tab-content">
            <div class="tab-pane active" id="home">1. İçerik Alanı</div>
            <div class="tab-pane" id="kategori">
                
            <jsp:include page="/kategoriekle" ></jsp:include>
            </div>
            <div class="tab-pane" id="messages">3. İçerik Alanı</div>
            <div class="tab-pane" id="settings">BilgiSayaci.Org</div>
  </div>  
            </div>
</div>
</div>
  <section id="sidebar"></section>    
  <section id="content"></section>    
  <aside></aside>    
  <footer></footer> 
    
    
    
</body>
</html>
