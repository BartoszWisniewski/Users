<div><h1>List of users</h1></div>


<#if usersList??>
    <table >
        <thead>
        <tr>
            <th >ID</th>
            <th >Login</th>
            <th >Password</th>
            <th >Name</th>
            <th >Surname</th>
            <th >Telephone</th>
            <th >User role</th>
        </tr>
        </thead>
        <tbody>
        <#list usersList as entry>
            <tr>
                <td>${entry.id}</td>
                <td>${entry.login}</td>
                <td>${entry.password}</td>
                <td>${entry.name}</td>
                <td>${entry.surname}</td>
                <td>${entry.telephone}</td>
                <td>${entry.userRole}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>