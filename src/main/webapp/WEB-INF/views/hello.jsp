<html>
<body>
    <form action="/logout" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <table>
        <tr>
            <td>Id : ${message.id}</td>
        </tr>
        <tr>
            <td>Content : ${message.content}</td>
        </tr>
        <tr>
            <td><a href="hello/new">Change</a> | <a href="hello/remove">Remove</a></td>
        </tr>
    </table>
</body>
</html>