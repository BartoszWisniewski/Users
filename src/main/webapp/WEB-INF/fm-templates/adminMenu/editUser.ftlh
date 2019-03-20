<html lang="pl-PL">
<body>
<div>
    <a href="/menu-admin">Back to menu</a>
</div>
<div >
    <form action="/menu-admin/edit-user" method="post">
        <table >
            <thead>
            <tr>
                <th >Login</th>
                <th >Password</th>
                <th >Name</th>
                <th >Surname</th>
                <th >Telephone</th>
                <th >User role</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="Login" value="${user.login}"></td>
                <td><input type="text" name="Password" value="${user.password}"></td>
                <td><input type="text" name="Name" value="${user.name}"></td>
                <td><input type="text" name="Surname" value="${user.surname}"></td>
                <td><input type="text" name="Telephone" value="${user.telephone}"></td>
                <td><select name="UserRole">
                        <option value="0">Standard user</option>
                        <option value="1">Manager</option>
                        <option value="2">Admin</option>
                    </select></td>
            </tr>
            </tbody>
        </table>
        <input type="submit"> <input type="reset">
    </form>
</div>

</body>
</html>