<%-- 
    Document   : urunguncelle
    Created on : 11.May.2015, 21:57:02
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
<body >
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
             <!-- Nav tabs -->
        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">Bilgi</a></li>
            <li><a href="#profile" data-toggle="tab">Fiyat</a></li>
            <li><a href="#messages" data-toggle="tab">Kategori</a></li>
            <li><a href="#settings" data-toggle="tab">Resim</a></li>
        </ul>
 
        <!-- Tab panes -->
        <form class="tab-content" action="urunekle" id="yazarform" >
            
                <div class="tab-pane active" id="home">
                    
                    <label for="yazaradi">Yazar Adı</label>
                    <select class="form-control" name="yazar" id="yazaradi">
                        <c:forEach items="${yazarliste}" var="i">
                            <option value="${i.yazarID}">${i.yazarAd}</option>  
                        </c:forEach>
                    </select>
                    <a href="#" id="yazarekleclick" >Yeni yazar ekle</a>  <br/>
                 <div  style="display: none;" class="form-group" id="yazarekledisp">
                     
                  <input type="text" class="form-control" name="yazarad" id="yazarad" placeholder="Yazar Adı giriniz" />
                  <input type="text" class="form-control" name="yazarsoyad" id="yazarsoyad" placeholder="Yazar Soyad" />
                  <input type="text" class="form-control" name="yazarmail" id="yazarmail" placeholder="Yazar email" />
                  <a href="#" id="yazekle" >kaydet</a>
                </div>
                    
                    <!---->
                    
                     <label for="yazaradi">YayinEvi</label>
                    <select class="form-control" name="yayin" id="yayinadi">
                        <c:forEach items="${yayinliste}" var="i">
                            <option value="${i.yayinID}">${i.ad}</option>  
                        </c:forEach>
                    </select>
                    <a href="#" id="yayinekleclick" >Yeni yayin evi ekle</a>  
                 <div  style="display: none;" class="form-group" id="yayinekledisp">
                     
                  <input type="text" class="form-control" name="yayinad" id="yayinad" placeholder="Yayin evi adi" />
                  <input type="text" class="form-control" name="yayinadres" id="yayinadres" placeholder="adres" />
                  <input type="text" class="form-control" name="yayinmail" id="yayinmail" placeholder="email" />
                  <a href="#" id="yayekle" >kaydet</a>
                </div>
                    <br />
                    <!---->
                    <label for="scrollkategori"> Ana Kategori</label>    
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
                <div class="form-group">
                  <label for="adi">*ADI</label>
                  <input type="text" class="form-control" name="adi" id="adi" placeholder="Ürün Adı" required>
                </div>
                <div class="form-group">
                  <label for="aciklama">Açıklama</label>
                  <textarea class="form-control" id="aciklama" name="aciklama" rows="3" placeholder="Ürün Açıklama Yazısı" ></textarea>
                </div>
                    
                    
                    
                
                    <input type="submit" value="Kaydet">

                </div>
            <div class="tab-pane" id="profile">2. İçerik Alanı</div>
            <div class="tab-pane" id="messages">
                3. içerik alanı
               <div class="form-group">
                  <label for="exampleInputFile">File input</label>
                  <input type="file" id="exampleInputFile">
                  <p class="help-block">Example block-level help text here.</p>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox"> Check me out
                  </label>
                </div>
              <input type="submit" value="Kaydet">  
            </div>
            <div class="tab-pane" id="settings">BilgiSayaci.Org</div>
            
        </form>

        </div>       
        
</div>
    </div>
   </div>
   
   <script>
      
       $(document).ready(function(){
           $('#yazarekleclick').click(function (){
               
               $('#yazarekledisp').show(1000);
           });
           $('#yayinekleclick').click(function (){
               
               $('#yayinekledisp').show(1000);
           });
       });
    function loadXMLDoc(){
        
       var a  = document.getElementById('yazarad').value;
        var b  = document.getElementById('yazarsoyad').value;
         var c  = document.getElementById('yazarmail').value;
          
        var xmlhttp;

               var url= "<c:url value = "yazarekle" />";
                if (window.XMLHttpRequest)
                {
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {

//                        document.getElementById("mid_title").innerHTML=xmlhttp.responseText;
                    }
                }

                xmlhttp.open("GET", url+"?yazarad="+a+"&yazarsoyad="+b+"&yazarmail="+c, true);
                xmlhttp.send();
               
               
//                var url = "urunekle";  
//                $(location).attr('href', url);
                 setTimeout(function() { location.reload() },1000);
               
                
    }
    
   
    
     $(document).ready(function(){
        
      
                $("#yazekle").click(function(){
                     var a  = document.getElementById('adi').value;
                    var b  = document.getElementById('aciklama').value;
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/yazarekle",
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                  $("#yayekle").click(function(){
                     var a  = document.getElementById('adi').value;
                    var b  = document.getElementById('aciklama').value;
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/yayineviekle",
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                 
               });
   </script>
</body>
</html>
