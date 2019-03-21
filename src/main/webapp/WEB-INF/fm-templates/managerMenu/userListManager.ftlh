<div><h1>List of users</h1></div>

<div>
    <a href="/menu-manager">Back to menu</a>
</div>

<#if usersList??>
    <table >
        <thead>
        <tr>
            <th >Login</th>
            <th >Name</th>
            <th >Surname</th>
            <th >Telephone</th>
            <th >User role</th>
        </tr>
        </thead>
        <tbody>
        <#list usersList as entry>
            <tr>
                <td>${entry.login}</td>
                <td>${entry.name}</td>
                <td>${entry.surname}</td>
                <td>${entry.telephone}</td>
                <td>${entry.role}</td>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>