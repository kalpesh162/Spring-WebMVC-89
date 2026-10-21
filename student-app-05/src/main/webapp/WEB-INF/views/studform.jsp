
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details Form</title>
</head>
<body>

    <h2>Student Details</h2>

    <form action="save" method="post">

        <label>Student ID:</label>
        <input type="text" name="id" required>
        <br><br>

        <label>Student Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Marks:</label>
        <input type="number" name="marks" min="0" max="100" required>
        <br><br>

        <input type="submit" value="Submit">

    </form>

</body>
</html>
