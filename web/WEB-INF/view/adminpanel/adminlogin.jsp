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
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
    <script>
        angular.module('emailExample', [])
          .controller('ExampleController', ['$scope', function($scope) {

          }]);
    </script>
</head>
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
</html>
