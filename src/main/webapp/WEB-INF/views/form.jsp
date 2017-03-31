<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
    <form:form action="/hello" method="post" modelAttribute="message">
        <table>
            <tr>
                <td>Id</td>
                <td>${message.id}</td>
            </tr>
            <tr>
                <td>Content:</td>
                <td><form:input path="content" /></td>
                <td><form:errors path="content" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
