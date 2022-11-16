<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Hello, user</div>
    <a href="/main">Main page</a>


    <#list illnesses as ill>

        <b>${ill.id}</b>

    </#list>

</@c.page>