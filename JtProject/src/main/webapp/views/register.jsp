<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Document</title>
    <!-- Your existing head content -->

    <!-- Ensure jQuery is loaded before your script -->
  <!-- Remove integrity and crossorigin attributes from the jQuery script tag -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script th:inline="javascript">
    /*<![CDATA[*/
    $(document).ready(function(){
        var urlParams = new URLSearchParams(window.location.search);
        var text = urlParams.get('q') || '';
        console.log("user check:", text);
        if(text === 'notUniqueEmail') {
         $('#errorModalBody').text('The provided email is already in use. Please choose a different email.');
                    $('#errorModal').modal('show');
         }
        else if(text === 'notUniqueUsername')
        {
            $('#errorModalBody').text('The provided username is already in use. Please choose a different username.');
            $('#errorModal').modal('show');
        }
    });
    /*]]>*/
</script>

</head>
<body>
<br>

<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="errorModalLabel">Error</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="errorModalBody">
                The provided email is already in use. Please choose a different email.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!-- Ensure jQuery is loaded before your script -->

<div class="container">
    <div class="col-sm-6">
        <h3 style="margin-top: 10px">Sign Up Now</h3>
        <p>Please fill out this to register</p>
        <form action="newuserregister" method="post">
            <div class="form-group">
                <label for="firstName">User Name</label>
                <input type="text" name="username" id="firstName" minlength="3" maxlength="20" required placeholder="Your Username*" required class="form-control form-control-lg">
            </div>
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control form-control-lg" required minlength="6" placeholder="Email*" required name="email" id="email"
                       aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with
                    anyone else.</small>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control form-control-lg" minlength="6" maxlength="20" required placeholder="Password*" required name="password"
                       id="password">
            </div>
            <div class="form-group">
                <label for="Address">Address</label>
                <textarea class="form-control form-control-lg" rows="3" placeholder="Enter Your Address" name="address" id="Address"></textarea>
            </div>
<span style="margin-top: 10px">Already have an account <a class="linkControl" href="/">Login here</a></span> <br><br>
            <input type="submit" value="Register" class="btn btn-primary btn-block"><br>
            
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>