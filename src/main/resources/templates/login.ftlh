<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>

<header class="header">
    <div class="container">
        <div class="header_inner">

            <div class="header_logo">
                <img class="beb" src="images/clinic-removebg-preview.png">
            </div>

            <nav>
                <a class="nav-link active" href="http://minzdrav.gov.by/ru/">
                    <img class="beb" src="images/free-icon-medicine-387604.png">
                </a>
            </nav>


        </div>
    </div>
</header>

<main>
    <div class="circle"></div>

    <form class="register-form-container" action="/login" method="post">

        <h1 class="form-title">Login to start:</h1>

        <div class="form-fields">
            <div class="form-field">
                <input type="text" name="username" placeholder="Login"/>
            </div>
            <div  class="form-field">
                <input type="password" name="password" placeholder="Password"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div>
            <button class="button" type="submit"> Login</button>
            <a href="/registration" class="button button-google">Registration</a>
        </div>

    </form>



</main>


</body>
</html>