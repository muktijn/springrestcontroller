<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Information Form</title>
</head>
<body>
<h2>new person id : ${person.personId} name ${person.firstName}
 Enter Contact Information</h2>
<form action="saveContact" method="post"> <!-- Ensure the action matches your servlet URL mapping -->
    <div>
        <label for="personId">Person ID:</label>
        <input type="number" id="personId" name="personId" value=${person.personId} required readonly>
    </div>
    <div>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
    </div>
    <div>
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required>
    </div>
    <div>
        <label for="state">State:</label>
        <input type="text" id="state" name="state" required>
    </div>
    <div>
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required>
    </div>
    <div>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required>
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>