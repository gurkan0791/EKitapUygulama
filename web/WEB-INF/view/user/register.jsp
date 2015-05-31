<%-- 
    Document   : register
    Created on : 31.May.2015, 12:26:11
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container" >
    <div class="row">
        
        <div class="col-md-6">
            
        <form class="form-horizontal" data-toggle="validator" role="form" action="register" method="POST">
        <fieldset>

        <!-- Form Name -->
        <legend>Kayıt OL</legend>

        <!-- Text input-->
        <div class="form-group">
            <label for="ad" class="col-sm-2 control-label">Ad</label>
            <div class="col-sm-10">
              <input type="text" value="${ad}" name="ad" class="form-control" id="ad" placeholder="" required>
            </div>
          </div>

        <!-- Text input-->
        <div class="form-group">
            <label for="soyad" class="col-sm-2 control-label">Soyad</label>
            <div class="col-sm-10">
              <input type="text" value="${soyad}" name="soyad" class="form-control" id="soyad" placeholder="" required>
            </div>
          </div>

        <!-- Text input-->
        <div class="form-group">
            <label for="email"  class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
              <input type="email" value="${email}" name="email" class="form-control" id="email" placeholder="" required>
            </div>
          </div>

          <div class="form-group">
            <label for="sifre" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
              <input type="password" data-minlength="6" name="sifre" class="form-control" id="sifre" placeholder="" required>
                  <span class="help-block">Minimum of 6 characters</span>
            </div>
          </div>

        <!-- Password input-->
        <div class="form-group">
            <label for="sifretekrar" class="col-sm-2 control-label">Parola Tekrar</label>
            <div class="col-sm-10">
              <input type="password" name="sifretekrar" class="form-control" id="sifretekrar" placeholder="" required>
                  <span class="error" style="color:red">${requestScope.messages.sifre}</span>
            </div>
            
          </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">KAYDET</button>
            </div>
          </div>
        </fieldset>
    </form>

            
        </div>
        
    </div>

</div>
