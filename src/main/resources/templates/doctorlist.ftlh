<#import "parts/common.ftlh" as c>

<@c.page>
    List of users:
    <table>
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
                <td><a href="/doctor/${user.id}">Add</a></td>
            </tr>
        </#list>

        </tbody>

    </table>
</@c.page>