<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>GoodClinic</title>
    <link rel="stylesheet" href="../styles/main.css">
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
                    <a href="/main" class="button-logout">Back</a>
                </div>

            </nav>



        </div>
    </div>
</header>


<main>

    <div class="register-form-container">

        <div>Search:</div>
        <form class="form-search" method="post" action="/main">
            <input class="search" placeholder="Enter the illness, you are looking for" type="text" name="filter">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="search-btn" type="submit">Search</button>
        </form>

        <#list illnesses as ill>

            <div class="bless">
                <p class="who"><b>Doctor:</b> ${ill.userName!"none"}</p>
                <p class="whatill"><b>Diagnosis:</b> ${ill.tag}</p>
                <p class="message"><b>Destination:</b> ${ill.text}</p>
            </div>

            <#else>
            No illneses.

        </#list>

        </div>



    <main>

</body>
</html>