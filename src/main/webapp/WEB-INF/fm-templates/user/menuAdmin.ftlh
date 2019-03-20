<html lang="pl-PL">
<body>

<div >

    <p lang="pl">${member1}</p>

</div>

<a href="user-list">Users view</a><p>
<a href="add-user">Add new user</a>


<div>
    <#if session??>
    Session information:
       <#-- <#list session as entry>-->
    Login:${session.login}
    Name:${session.name}
    Surname:${session.surname}
    Telephone:${session.telephone}
    Role:${session.role}

        <a href="logout" >Logout</a>
        <#--</#list>-->
    </#if>
</div>

</body>
</html>