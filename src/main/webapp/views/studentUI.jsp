<!-- page language (server page language) -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- ELignore false   (dynamic expressions support ) -->
<%@ page isELIgnored = "false" %>
<!-- taglib for form  (form support) -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- taglib for jstl (looping support ) -->
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
	<head>
	   <title>Student CRUD Application</title>
	</head>
<body>
  <h2> Enter your choice </h2>
  <form:form action="http://localhost:8081/mvc/student/save" method="post" modelAttribute="sbean">
      Student Id : <form:input path="studId"/><br><br>
      Student Name : <form:input path="studName"/><br><br>
      <input type="submit">
  </form:form>
  
 <c:if test="${slist.size()>0}">
     <table border = "1">
        <thead>
          <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Action</th>
          </tr>
        </thead>
        
        <c:forEach items="${slist}" var="s">
          <tr>
             <td><c:out value="${s.studId}"></c:out></td> 
             <td><c:out value="${s.studName}"></c:out></td>
             <td><a href="http://localhost:8081/mvc/student/edit/<c:out value="${s.studId}"></c:out>">Edit</a>
             <a href="http://localhost:8081/mvc/student/delete/<c:out value="${s.studId}"></c:out>">Delete</a></td> 
          </tr>
        </c:forEach>
     
     </table>
 
 </c:if>
  
  
  
</body>

</html>