<div><h1>Message list</h1></div>

<div>
    <#if group == 2>
        <a href="/menu-admin">Back to menu Admin</a>
    </#if>
    <#if group == 1>
        <a href="/menu-manager">Back to menu Manager</a>
    </#if>
    <#if group == 0>
        <a href="/menu-standard-user">Back to menu Standard User</a>
    </#if>


</div>
<div>
    <form action="/message" method="post">
        <table >
            <thead>
            <tr>
                <th >Title</th>
                <th >Content</th>
                <th >Group</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="Title"></td>
                <td><input type="text" name="Content"></td>
                <td><select name="UserGroup">
                        <option value="Standard">Standard user</option>
                        <option value="Manager">Manager</option>
                        <option value="Admin">Admin</option>
                    </select></td>
            </tr>
            </tbody>
        </table>
        <input type="submit"> <input type="reset">
    </form>

</div>

<div>
    <#if messageList??>
        <table>
            <thead>
            <tr>
                <th>Title</th>
                <th>Date</th>
                <th>Time</th>
                <th>Content</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list messageList as entry>
                <tr>
                    <td>${entry.title}</td>
                    <td>${entry.date}</td>
                    <td>${entry.time}</td>
                    <td>${entry.content}</td>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>

</div>
