<html lang="pl-PL">
<body>

<div >

    <p lang="pl">${member1}</p>

</div>

<a href="/menu-admin/user-list">Users view</a><p>
<a href="/menu-admin/add-user">Add new user</a>


<div>
    <#if session??>
   <p>Session information:<br>
    Login: ${session.login}<br>
    Name: ${session.name}<br>
    Surname: ${session.surname}<br>
    Telephone: ${session.telephone}<br>
    Role: ${session.role}</p><br>

        <a href="logout" >Logout</a>

    </#if>
</div>

</body>
</html>