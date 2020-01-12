<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Select Student</title>
</head>
<body>
<ul>
  <c:forEach var="student" items="${students}">
    <li><c:out value="${student.id_student} * ${student.first_second_name} * ${student.id_class} * ${student.year_receipt}" /></li>
  </c:forEach>
</ul>
</body>
</html>