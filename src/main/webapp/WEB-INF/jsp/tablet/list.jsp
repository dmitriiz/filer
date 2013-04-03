<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0" />
        <title>Entities</title>
    </head>
    <body>
        <c:forEach var="entity" items="${entities}">
            <div>
                <img src='<c:url value="/icon/${entity.guid}"/>' />
                <c:out value="${entity.name}" />
                <a href='<c:url value="/get/${entity.guid}"/>'>download</a>
            </div>
        </c:forEach>
    </body>
</html>
