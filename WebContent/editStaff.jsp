<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.cham.bean.Staff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/user.css">
<link rel="stylesheet" href="css/edit.css">
<title>USER</title>
</head>
<body>
<div id="header">
		<div style="width: 100%">
         <h1>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h1>
         </div>  
              </div>
<%Staff staff = (Staff)request.getAttribute("staff"); %>
<div class="nav-side-menu">
    <div class="brand">*^_^* MENU *^_^*</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="/QuanLyNhanSu/inforstaff?action=information">
                  <i class="fa fa-dashboard fa-lg"></i> Information
                  </a>
                </li>

                <li>
                  <a href="/QuanLyNhanSu/inforstaff?action=edit">
                  <i class="fa fa-user fa-lg"></i> Edit
                  </a>
                  </li>
               <li>
                  <a href="/QuanLyNhanSu/inforstaff?action=search">
                  <i class="fa fa-user fa-lg"></i> Search
                  </a>
                  </li>

                 <li>
                  <a href="/QuanLyNhanSu/inforstaff?action=logout">
                  <i class="fa fa-users fa-lg"></i> Logout
                  </a>
                </li>
            </ul>
     </div>
</div>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Edit my information</h5>
					<form class="" method="post" action="#">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" value="<%=staff.getName() %>"  id="name"  placeholder="Enter your Name"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Birthday</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="birthday" value="<%=staff.getBirthDay() %>" id="birthday"  placeholder="Enter your Birthday"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="department" class="cols-sm-2 control-label">Department</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="department" value="<%=staff.getDepartmemt() %>" id="department"  placeholder="Enter your Department"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="workdays" class="cols-sm-2 control-label">Workdays</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="workdays" value="<%=staff.getWorkdays() %>" id="workdays"  placeholder="Enter your Workdays"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="coefficientSalary" class="cols-sm-2 control-label">CoefficientSalary</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="coefficientSalary" value="<%=staff.getCoefficientSalary() %>" id="coefficientSalary"  placeholder="Enter your CoefficientSalary"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="position" class="cols-sm-2 control-label">Position</label></br>
							<select name ="piosition" selected ="pp">
   								<option size = "50" value=”tp″ selected=<%=staff.getPosition().equals("Trưởng Phòng")%>>Trưởng Phòng</option>
 							    <option size = "50" value=”pp″ selected=<%=staff.getPosition().equals("Phó Phòng")%>>Phó Phòng</option>
   								<option size = "50" value=”nv″ selected=<%=staff.getPosition().equals("Nhân Viên")%>>Nhân Viên</option>
   								<option size = "50" value=”admin″ selected=<%=staff.getPosition().equals("Admin")%>>Admin</option>
							</select>
							
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Country</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="country" value="<%=staff.getCountry() %>" id="country"  placeholder="Enter your Country"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="allowance" class="cols-sm-2 control-label">Allowance</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="allowance" value="<%=staff.getAllowance() %>" id="allowance"  placeholder="Enter your Allowance"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="salary" class="cols-sm-2 control-label">Salary</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="salary" value="<%=staff.getSalary() %>" id="salary"  placeholder="Enter your Salary"/>
								</div>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your username"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<a href="#" target="_blank" type="button" id="button" class="btn btn-primary btn-lg btn-block login-button">EDIT</a>
						</div>
						
					</form>
				</div>
			</div>
		</div>

		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>


</body>
</html>