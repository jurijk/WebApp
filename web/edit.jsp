<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">

    <input type="hidden" value="${student.id_student}" name="id_student" />

    <label>Name of student</label><br>
    <input name="first_second_name" value="${student.first_second_name}" /><br><br>

    <label>Class</label><br>
    <input name="id_class" value="${student.id_class}" type="number" max="10" /><br><br>

    <label>Year receipt</label><br>
    <input name="year_receipt" value="${student.year_receipt}" type="number" min="1900" /><br><br>

    <input type="submit" value="Send" />
</form>
</body>
</html>
