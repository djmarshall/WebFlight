<%-- 
    Document   : display
    Created on : 07/08/2012, 8:37:04 PM
    Author     : Daniel Marshall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flights</title>
    </head>
    <body>
        <h3> Flights (<c:out value="${fromDest}" /> to <c:out value="${toDest}" />)</h3>
        <table width="800" align="center">
            <c:forEach items="${flights}" var="flightpath">
            <tr>
                <td>$${flightpath.getPrice()}</td>
                <c:forEach items="${flightpath.getFlightList()}" var="current">
                
                <td>
                    <c:out value="${current.fromDest}" /> -> 
                        <c:out value="${current.toDest}" /></p>
                </td>
                </c:forEach>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>

