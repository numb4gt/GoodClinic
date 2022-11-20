<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>User</title>
    <link rel="stylesheet" href="../styles/style2.css">

</head>

<body>

<header class="header">
    <div class="container">
        <div class="header_inner">

            <div class="header_logo">
                <img class="beb" src="../images/clinic-removebg-preview.png">
            </div>

            <nav>
                <div>
                    <form action="/logout" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <input class="button-logout" type="submit" value="Sign Out"/>
                    </form>
                </div>

            </nav>



        </div>
    </div>
</header>


<main>

    <div class="register-form-container">

        <div>MessageList</div>
        <form method="post" action="filter">
            <input type="text" name="filter">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Search</button>
        </form>

        <#list illnesses as ill>

            <div class="user_nav">
                <b class="num">${ill.id}</b>
                <span class="message">${ill.text}</span>
                <i>${ill.tag}</i>
                <strong>${ill.userName!"none"}</strong>
            </div>

        <#else>
            No illneses.

        </#list>

    </div>



    <main>

</body>
</html>