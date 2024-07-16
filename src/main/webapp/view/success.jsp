<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Success Page</title>
</head>
<body>
    <h1>User details are successfully added</h1>
    
    <h2>Person Information ${person.firstName}</h2>
    
    <p>First Name: "${person.firstName} </p> <!-- Conditional Display -->
    <p>Last Name: "${person.lastName}"  </p>
    <p>Gender:   "${person.gender}"  </p>

    <h2>Bank Information</h2>
    <p>Bank Name: "${bank.bankname}"</p>
    <p>Bank Number: ${bank.banknumber}"</p>
    <p>SSN: ${bank.ssn}"</p>

    <h2>Contact Information</h2>
    <p>Address: "${contact.address}"</p>
    <p>City: "${contact.city}"</p>
    <p>State: "${contact.state}"</p>
    <p>Country: "${contact.country}"</p>
    <p>Phone: "${contact.phone}"</p>
    
    <!-- Inline Text Example -->
    <p th:inline="text">Hello, [[${person.firstName}]] [[${person.lastName}]]!</p>
    
    <!-- Concatenation Example -->
    <p>Full Name: <span th:text="'