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
    
    <table align="center">
    <tr><td>
        <h2>Flight Search</h2>
    </td></tr>
    <tr>
        
        <form:form method="post" action="display.htm">
    <tr>
        <td>
            Origin: <form:select path="fromDest" items="${fromList}" />
            
        </td>
        <td>
            Destination: <form:select path="toDest" items="${toList}" />
        </td>
    </tr><tr>
        <td>
            Departure Date: <form:select path="fromDay" items="${dayList}" />
            <select> 
                <option value="Aug" >Aug </option>
            </select>
        </td>
        
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
