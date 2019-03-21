<html lang="pl-PL">
<body>

<div>
    <#if session??>
        <p>Session information:<br>
        Login:  ${session.login}
        Name:  ${session.name}
        Surname:  ${session.surname}
        Telephone:  ${session.telephone}
        Role:  ${session.role}</p><br>

        <a href="logout" >Logout</a>
    </#if>
</div>

<div>
    <a href="/menu-menager/user-list">Users view</a><p>
    <a href="/menu-menager/edit-profile">Edit your profile</a>
</div>



</body>
</html>