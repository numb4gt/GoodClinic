<#import "parts/common.ftlh" as c>

<@c.page>
    UserEditor:

    <form action="/doctor" method="post">

        <h1 type="text" name="username">${user.username}</h1>
        <input type="text" name="text" placeholder="Put massage" />
        <input type="text" name="tag" placeholder="Tag">

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" value="${user.id}" name="userID" />

        <button type="submit">Add</button>
    </form>

</@c.page>