<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Person Information</title>
</head>
<body>
    <h2>Person Information Form</h2>
    <form action="savePerson" method="POST"> <!-- Adjust action to your Servlet mapping -->
        <label for="firstName">First Name:</label><br>
        <input type="text" id="firstName" name="firstName" required><br>
        <label for="lastName">Last Name:</label><br>
        <input type="text" id="lastName" name="lastName" required><br>
        <label for="middleName">Middle Name:</label><br>
        <input type="text" id="middleName" name="middleName" required><br>
        <label for="gender">Gender:</label><br>
        <select id="gender" name="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>