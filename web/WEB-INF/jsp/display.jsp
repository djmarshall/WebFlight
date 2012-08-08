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
            <tr><td><h3> Flying from <c:out value="${fromDest}" /> to <c:out value="${toDest}" /> on
                    <fmt:formatDate type="date" dateStyle="medium" value="${fromDate}" />
                    (ordered by Price) </h3></td></tr></table>
        <table width="800" align="center" border="1" cellpadding="0" cellspacing="0">
            <c:forEach items="${flights}" var="flightpath">
            <tr>
                
                <td align="center">
                    <fmt:formatNumber type="currency" value="${flightpath.getPrice()}" />
                </td>
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
        </table><table width="800" align="center">
            <tr><td><a href="search.htm"> Search Again </a></td></tr>
        </table>
    </body>
</html>

