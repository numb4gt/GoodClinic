<#import "parts/common.ftlh" as c>

<@c.page>

    <header class="header">
        <div class="container">
            <div class="header_inner">

                <div class="header_logo">
                    <img class="beb" src="../images/clinic-removebg-preview.png">
                </div>

                <nav>
                    <a href="/doctor/patientlist" class="button-logout">Back</a>
                </nav>


            </div>
        </div>
    </header>

    <main>
        <div class="circle"></div>

        <div class="register-form-container">

            <form action="/doctor" method="post">

                <p class="editstart" type="text" name="username">Your make destination for: <b>${user.username}</b></p>

                <input type="text" name="tag" placeholder="Enter the diagnosis">
                <input type="text" name="text" placeholder="Enter the destination" />


                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" value="${user.id}" name="userID" />

                <button class="button" type="submit">Add</button>
            </form>


        </div>



    </main>

</@c.page>