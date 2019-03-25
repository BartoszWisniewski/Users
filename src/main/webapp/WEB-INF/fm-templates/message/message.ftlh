<div><h1>Message list</h1></div>

<div>
    <a href="/menu-admin">Back to menu</a>
</div>

<#if messageList??>
    <table >
        <thead>
        <tr>
            <th >Title</th>
            <th >Date</th>
            <th >Content</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list messageList as entry>
            <tr>
                <td>${entry.title}</td>
                <td>${entry.date}</td>
                <td>${entry.content}</td>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>