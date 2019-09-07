<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Apartments</title>
</head>

<body>
<h2>Apartments table management</h2>
<form action="apservlet" method="get">

    <input type="checkbox" name="auto" value="1" <c:if test="${requestScope.auto ne null}"> checked </c:if>/> Show
    changes
    automatically
    <table border="0">
        <tr>
            <td>
                <b>id(for delete only)</b>
            </td>
            <td>
                <input type="text" name="id"/>
            </td>

            <td>
                <input type="submit" name="command" value="Delete"/>
            </td>
        </tr>
        <tr>
            <td>
                <b>district</b>
            </td>
            <td>
                <input type="text" name="district"/>
            </td>
        </tr>
        <tr>
            <td>
                <b>address</b>
            </td>
            <td>
                <input type="text" name="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <b>price</b>
            </td>
            <td>
                <input type="text" name="price"/>
            </td>
        </tr>
        <tr>
            <td>
                <b>area</b>
            </td>
            <td>
                <input type="text" name="area"/>
            </td>
        </tr>
        <tr>
            <td>
                <b>count of rooms</b>
            </td>
            <td>
                <input type="text" name="roomsCount"/>
            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>

            </td>
            <td>
                <input type="submit" name="command" value="Add"/>
            </td>
        </tr>
    </table>


    <h3>Table output:</h3>
    input selection parameters
    <p><textarea name="params" placeholder="for examlpe: price > 50"
    ></textarea></p>
    <p><input type="submit" name="command" value="Get all">
        <input type="submit" name="command" value="Get by params">
    </p>

</form>

<c:if test="${apartments ne null}">
    <table border="0" frame="border" rules="all">
        <caption>Table of apartments in data base</caption>
        <tr>
            <th>id</th>
            <th>district</th>
            <th>address</th>
            <th>price</th>
            <th>area</th>
            <th>roomsCount</th>
        </tr>
        <c:forEach items="${apartments}" var="cl">
            <tr>
                <td><c:out value="${cl.id}"/></td>
                <td><c:out value="${cl.district}"/></td>
                <td><c:out value="${cl.address}"/></td>
                <td><c:out value="${cl.price}"/></td>
                <td><c:out value="${cl.area}"/></td>
                <td><c:out value="${cl.roomsCount}"/></td>
            </tr>
        </c:forEach>
    </table>

</c:if>
</body>
</html>
