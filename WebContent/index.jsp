
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
$('#success').click(function (e) {
  e.preventDefault()
  $('#message').html('<div class="alert alert-success fade in"><button type="button" class="close close-alert" data-dismiss="alert" aria-hidden="true">×</button>This is a success message</div>');
}
</script>
<meta charset="ISO-8859-1">
<title>To_Do page</title>
<style>
.form_class{
 display: flex;
    justify-content: center;
}
</style>

 <style>
 .footer {
    padding: 20px;
    text-align: center;
    background: #ddd;
}
 </style>




</head>
<body>



<%

	if(request.getAttribute("message")!=null){
		out.print(request.getAttribute("message").toString());
	}
%>
<div class="form_class">
<article>
<header>
<h1>TASK MANAGEMENT </h1><br>
</header>
</article>
</div>
<div class="form_class">

<form action="Result" method="POST">

<div class="input-group mb-3">
<div class="input-group-append">
<h3>TODO:</h3>

  <input type="text" class="form-control" size="80" name="TODO" placeholder="Some text here..." required>
  
    <button class="btn btn-success" type="submit" value="ADD" id="success">ADD</button> 
   
  </div>
</div>

</form>
</div>

 <p style="color:green"align="center" > ${message} </p>
<c:remove var="message" scope="session" /> 
<div class="container">  
  
<table class="table table-table">
    <thead>
 <tr>
 <th>#</th>
 <th>Todo</th>
 <th>Status</th>
 <th>Action</th>
 </tr>
 </thead>

<c:forEach  items="${todos }" var="todo">
<tbody>
<tr >

<td>${ todo.srNo } </td>
<td>${ todo.todo }</td>
<td>${ todo.status }</td>
   <td><form action="CompleteTodo" method ="GET">
   <input type="hidden"  size="100" name="id" value="${ todo.srNo }" />
  
    <button class="btn btn-outline-success" type="submit" >complete</button>  <p style="color:red"align="right" > ${message2} </p>
     
</form>
</td> 
<td><form action="DeletTodo" method ="GET">
  
     <input type="hidden"  size="100" name="id" value="${ todo.srNo }" />
  
    <button class="btn btn-outline-danger" type="submit" >Delete</button>   <p style="color:red"align="right" > ${message1} </p>
</form>
</td>     

</tr>
</tbody>
</c:forEach>
</table>
</div>
  
<div class="footer">Copywright 2017:
 <a href="https://Prodevans technology.com"> ProDevans</a>
</div>



</body>
</html>