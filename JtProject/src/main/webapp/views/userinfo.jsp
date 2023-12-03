<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h2>User Information</h2>

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Attribute</th>
            <th scope="col">Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>User ID</td>
            <td>1</td>
        </tr>
        <tr>
            <td>Username</td>
            <td>Gojo</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>gojosatoru@gmail.com</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>123456</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>shibuya</td>
        </tr>
        </tbody>
    </table>

    <a href="<c:url value='/updateProfile'/>" class="btn btn-primary">Update Profile</a>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>