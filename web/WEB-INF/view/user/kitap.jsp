<%-- 
    Document   : kitap
    Created on : 30.May.2015, 12:45:04
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<!--<div class="container" >
     <div class="row voffset2">    
     <div class="col-md-3 col-lg-3 col-xs-12" ">
         <figure class="text-center" style="text-align: center; margin: 0px; padding: 0px;">
             <img src="<%=request.getContextPath()%>/resimler/${urundetayliste[0].urunResim}" width="200px" height="250px"></img>
             
         </figure>
         
     </div> 
     <div class="col-md-6 col-lg-6 col-xs-12 " ">
         <section>
        <h3>${urundetayliste[0].urunAD}</h3>
        <article>
            <p>
                asddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
                asdddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
                asdasdasdddddddddddddddddddddddddddddddddddddddddddddddddddddd
                asddddddddddddddddddddddddddddddddddddddddddddddddddd
            </p>
            <p>
            </p>
        </article>
    </section>
         
     </div>   
     </div>
    
    <c:out value="${requestScope.uyari}"></c:out>
    <c:forEach items="${urundetayliste}" var="urun">
        ${urun.urunID}
        ${urun.urunAD}
        ${urun.urunResim}
        ${urun.urunFiyat}
        ${urun.aciklama}
    </c:forEach>
    
    <br/>
    
     <c:forEach items="${urunyazaryayinliste}" var="urun">
        ${urun.yazarAD}
        ${urun.yazarSoyad}
        ${urun.yayinEviAD}
       
    </c:forEach>
    
    <br/>
    
     <c:forEach items="${urunozellikliste}" var="urun">
        ${urun.urunID}
        ${urun.ozellikID}
        ${urun.deger}
    </c:forEach>
</div>-->
    
    <div class="container" style="background-color:green">
<article class="row">
    <header class="col-md-6 floatright">
        <a href="#">
            <h2>${urundetayliste[0].urunAD}</h2>
        </a>
        <hr/>
    </header>
        
    <div class="col-md-4">
        <figure>
            <a class="thumbnail" href="#">
        <img src="<%=request.getContextPath()%>/resimler/${urundetayliste[0].urunResim}" width="200px" height="250px"class="img-responsive">
                <!--<figcaption>Caption</figcaption>-->
            </a>
        </figure>
    </div>
    <div class="col-md-6 floatright">
        <p>${urundetayliste[0].aciklama}</p>
    </div>
    <div class="col-md-2 floatright" style="background-color: black;"> 
        <p>${urundetayliste[0].aciklama}</p>
    </div>
</article>
</div>