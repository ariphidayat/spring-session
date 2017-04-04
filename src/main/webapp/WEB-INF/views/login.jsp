<html>
<body>
<form name="f" action="login" method="POST">
    <table>
        <tr>
            <td>User</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input name="submit" type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>