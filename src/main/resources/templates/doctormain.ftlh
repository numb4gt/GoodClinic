<#import "parts/common.ftlh" as c>

<@c.page>


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

        <div class="register-form-container">

            <h1 class="form-title">Hello, ${username}. Now you - Doctor!</h1>

            <div>
                <a href="/doctor/patientlist" class="button">Patients</a>
                <a href="/doctor/mydestination" class="button">Destination</a>
            </div>

            <div>
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input class="button-google" type="submit" value="Log Out"/>
                </form>
            </div>

        </div>



    </main>


</@c.page>