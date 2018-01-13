<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="com.cham.bean.Staff"%>
<%@page import="com.cham.bean.Teacher"%>
<%@page import="com.cham.bean.User"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/user.css">
<title>USER</title>
</head>
<style type="text/css">
div.content {
    font-family: calibri;
     margin: 10px 0px 100px 500px;
}
</style>
<body>
<%Teacher teacher = (Teacher)request.getAttribute("teacher"); %>

<div id="header">
		<div style="width: 100%"> 
         <h1>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h1>
         </div>  
              </div>

<div class="nav-side-menu">
    <div class="brand">*^_^* MENU *^_^*</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="/QuanLyNhanSu/inforteacher?action=information">
                  <i class="fa fa-dashboard fa-lg"></i> Information
                  </a>
                </li>
                  
               
                <li>
                <a href="/QuanLyNhanSu/inforteacher?action=edit">
                <i class="fa fa-user fa-lg"></i> Edit </a>
                </li>
                
               <li>
                  <a href="/QuanLyNhanSu/inforteacher?action=search">
                  <i class="fa fa-user fa-lg"></i> Search
                  </a>
                  </li>

                 <li>
                  <a href="/QuanLyNhanSu/inforteacher?action=logout">
                  <i class="fa fa-users fa-lg"></i> Logout
                  </a>
                </li>
            </ul>
     </div>
</div>
<div class="content">
	<div class="row">
<br /><br />
<form id="togglingForm" method="post" class="form-horizontal">
    <div class="form-group">
        	<label class="radio-inline">ADD USER </label>  
            <label class="radio-inline">
                <input type="radio" name="rating" value="name" checked='checked' /> TEACHER
            </label>
            <label class="radio-inline">
                <input type="radio" name="rating" value="country" /> STAFF
            </label>
            <button type="button" class="btn btn-success" data-toggle="#jobInfo">ADD</button>
        </div>
    
</form>
</div></div>


</body>
</html>