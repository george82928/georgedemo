<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
    <div class="container customErrorPanel">
        <div class="jumbotron alert-danger">
            <h1>Oops. Something went wrong</h1>
            <h2>${status} ${error}</h2>
        </div>
    </div>
</body>

</html>