<html lang="pl-PL" xmlns="http://java.sun.com/jsf/html">
<body>
<div>
    <a href="/menu-standard-user">Back to menu</a>
</div>
<div >
    <form action="/menu-standard-user/edit-profile" method="post">
        <table >
            <thead>
            <tr>
                <th >Login</th>
                <th >Password</th>
                <th >Name</th>
                <th >Surname</th>
                <th >Telephone</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${user.login}</td>
                <td><input type="text" name="Password" value="${user.password}"></td>
                <td><input type="text" name="Name" value="${user.name}"></td>
                <td><input type="text" name="Surname" value="${user.surname}"></td>
                <td><input type="text" name="Telephone" value="${user.telephone}"></td>

            </tr>
            </tbody>
        </table>
        <input type="hidden" name="UserRole" value="0">
        <input type="submit"> <input type="reset">
    </form>
</div>

</body>
</html>