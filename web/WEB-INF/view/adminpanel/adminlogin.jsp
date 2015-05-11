<%-- 
    Document   : adminlogin
    Created on : 10.Nis.2015, 18:25:15
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>

    <!-- 
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
   <script>
        angular.module('emailExample', [])
          .controller('ExampleController', ['$scope', function($scope) {

          }]);
    </script>-->

</head>
<!--
<body ng-app="emailExample">
    
    <form name="myForm" action="adminlogin" method="post" ng-controller="ExampleController">
    <p>
        Email :
    <input type="email" name="email" ng-model="email.text" required>
    <span class="error" ng-show="myForm.email.$error.required">
      Required!</span>
    <span class="error" ng-show="myForm.email.$error.email">
      Not valid email!</span>
    <tt>text = {{email.text}}</tt>
    <br/>
    </p>
    <p>
        <label for="sifre">Password :</label>
        <input id="sifre" name="sifre" type="password" value="${fn:escapeXml(param.age)}">
            <span class="error">${messages.sifre}</span>    
    </p>
    <p>
        <input type="submit">
            <span class="success">${messages.success}</span>
    </p>
    </form>
</body>
-->
<div class="container">	
<div class="row" style="margin-top: 300px;">
<div class="col-lg-6 col-md-6 col-lg-offset-3 col-md-offset-3">
<form class="form-horizontal" action="adminlogin" method="post">
  <div class="form-group">
    <label for="inputEmail3"  class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="Email" required>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name="sifre" class="form-control" id="inputPassword3" placeholder="Password" required>
    </div>
  </div>
    <span style="color:red;" class="error">${requestScope.uyari}</span>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>

</div>
</div>
</div>
</html>
