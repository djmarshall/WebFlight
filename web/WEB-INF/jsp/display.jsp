<%-- 
    Document   : display
    Created on : 07/08/2012, 8:37:04 PM
    Author     : Daniel Marshall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flights</title>
    </head>
    <body>
        <table width="800" align="center">
            <tr><td><h3> Flights (<c:out value="${fromDest}" /> to <c:out value="${toDest}" />)</h3></td></tr>
        
            <c:forEach items="${flights}" var="flightpath">
            <tr>
                <td>$${flightpath.getPrice()}</td>
                <c:forEach items="${flightpath.getFlightList()}" var="current">
                
                <td>
                    <B> <c:out value="${current.fromDest}" /> to 
                        <c:out value="${current.toDest}" /> </B>
                        <BR>
                        <fmt:formatDate type="date" dateStyle="medium" value="${current.fromDate}" />
                    
                </td>
                </c:forEach>
            </tr>
            </c:forEach>
        
            <tr><td><a href="search.htm"> Search Again </a></td></tr>
        </table>
    </body>
</html>

