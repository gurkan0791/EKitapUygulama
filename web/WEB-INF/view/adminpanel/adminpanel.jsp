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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpanel.css">
        <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
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
<body>
    
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
                    <form id="logout" action="${pageContext.request.contextPath}/logout" method="post">
                        <input type="submit" value="Logout" />
                    </form>
                </c:if>
            </div>
        </div>
        
    </header>    
  <nav>
    <ul id="menu">
    <li class="menus"><a href="#">GÖSTERGE PANELİ</a></li>
    <li class="menus"><a href="#">KATALOG</a>
        <ul class="alt_menus">
            <li><a href="#">Ürünler</a></li>
            <li><a href="/kategoriekle">Kategoriler</a></li>
            <li><a href="#">JQuery</a></li>
            <li><a href="#">Css</a></li>
            <li><a href="#">JavaScript</a></li>
        </ul>
    </li>
    <li class="menus"><a href="#">Uzmanlar</a>
        <ul class="alt_menus">
            <li><a href="#">Bcakir</a></li>
            <li><a href="#">Seomple</a></li>
            <li><a href="#">Batuhankucukali</a></li>
        </ul>
    </li>
    <li class="menus"><a href="#">İletişim</a>
    </ul>
  </nav>   
  <section id="sidebar"></section>    
  <section id="content"></section>    
  <aside></aside>    
  <footer></footer> 
    
    
    
</body>
</html>
