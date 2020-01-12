<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<h3>New student</h3>
<form method="post">
    <label>Name of student</label><br>
    <input name="first_second_name"/><br><br>

    <label>Class</label><br>
    <input name="id_class" type="number" max="10" /><br><br>

    <label>Year receipt</label><br>
    <input name="year_receipt" type="number" min="1900" /><br><br>

    <input type="submit" value="Save" />
</form>
</body>
</html>
