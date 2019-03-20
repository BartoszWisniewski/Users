<div><h1>List of users</h1></div>

<div>
    <a href="/menu-admin">Back to menu</a>
</div>

<#if usersList??>
    <table >
        <thead>
        <tr>
            <th >Login</th>
            <th >Password</th>
            <th >Name</th>
            <th >Surname</th>
            <th >Telephone</th>
            <th >User role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list usersList as entry>
            <tr>
                <td>${entry.login}</td>
                <td>${entry.password}</td>
                <td>${entry.name}</td>
                <td>${entry.surname}</td>
                <td>${entry.telephone}</td>
                <td>${entry.userRole}</td>
                <td><a href="/menu-admin/edit-user?log=${entry.login}"> Edit </a> <a href="/menu-admin/delete-user?log=${entry.login}"> Delete </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>