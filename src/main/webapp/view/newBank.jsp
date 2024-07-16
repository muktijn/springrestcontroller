<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Information Form</title>
</head>
<body>
<h2>new person id : ${contact.personId} 
 firstname ${person.firstName} lastname ${person.lastName}
 Enter Bank Information</h2>
<form action="saveBank" method="post"> <!-- Ensure the action matches your servlet URL mapping -->
    <div>
        <label for="personId">Person ID:</label>
        <input type="number" id="personId" name="personId" value="${contact.personId}" required readonly>
    </div>
    <div>
        <label for="bankname">Bank Name:</label>
        <input type="text" id="bankname" name="bankname" required>
    </div>
    <div>
        <label for="banknumber">Bank Number:</label>
        <input type="text" id="banknumber" name="banknumber" required>
    </div>
    <div>
        <label for="ssn">SSN</label>
        <input type="text" id="ssn" name="ssn" required>
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>