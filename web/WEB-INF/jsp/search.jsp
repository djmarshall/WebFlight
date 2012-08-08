<%-- 
    Document   : search.jsp
    Created on : 08/08/2012, 9:55:57 AM
    Author     : Daniel Marshall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Search for Flights</title>
</head>
<body>
<h2>Flight Search</h2>
<form:form method="post" action="display.htm">
 
    <table>
    <tr>
        <td><form:label path="fromDest">From</form:label></td>
        <td><form:input path="fromDest" /></td> 
    </tr>
    <tr>
        <td><form:label path="toDest">To</form:label></td>
        <td><form:input path="toDest" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Search Flights"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>
