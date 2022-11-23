<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="../styles/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>GoodClinic</title>
</head>
<body>

<header class="header">
    <div class="container">
        <div class="header_inner">

            <div class="header_logo">
                <img class="beb" src="../images/clinic-removebg-preview.png">
            </div>

            <nav>
                <a href="/doctor" class="button-logout">Back</a>
            </nav>


        </div>
    </div>
</header>

<main>
    <div class="circle"></div>

    <div class="register-form-container">

        Search patient:

        <form class="form-search" method="post" action="/doctor/patientlist">
            <input class="search" placeholder="Enter the patient, you are looking for" type="text" name="filter">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="search-btn" type="submit">Search</button>
        </form>

        <table class="table_list">
            <thead>
            <tr>
                <th>Name</th>
                <th>Add</th>
            </tr>
            </thead>
            <tbody>


            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td><a href="/doctor/${user.id}">Make destination</a></td>
                </tr>


            </#list>

            </tbody>

        </table>

    </div>



</main>


</body>
</html>