<html lang="pl-PL">
<body>

<div>
    User exist.
</div>

<div>
    <a href="menu">Back to menu</a>
</div>

<div >
    <form action="/addUser" method="post">
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
                <td><input type="text" name="Login"></td>
                <td><input type="text" name="Password"></td>
                <td><input type="text" name="Name"></td>
                <td><input type="text" name="Surname"></td>
                <td><input type="text" name="Telephone"></td>
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