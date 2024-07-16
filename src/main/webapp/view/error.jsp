<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
    <h1>Error Occurred</h1>
    <div>
        <p>An unexpected error has occurred. Please try again later.</p>
        <p th:if="${errorMessage}" th:text="${errorMessage}">Error details</p>
    </div>
</body>
</html>