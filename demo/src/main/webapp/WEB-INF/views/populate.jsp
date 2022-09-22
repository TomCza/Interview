<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.lang.*" import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<title>POPULATED</title>
</head>
<body>
    <a href="/"><button type="button">HOME</button></a>
    <br/>
    <h1>DATABASE HAS BEEN POPULATED</h1>
    <%
        String url = "jdbc:mysql://mysql_db:3306/interview";
        Connection connection = DriverManager.getConnection(url,"root","passwrd");
        String sql = "SELECT * FROM bets;";
        ResultSet rs = connection.createStatement().executeQuery(sql);
        %>
        <TABLE BORDER="1">
            <TR>
                <TH>ID</TH>
                <TH>Game</TH>
                <TH>NumBets</TH>
                <TH>Stake</TH>
                <TH>Returns</TH>
                <TH>ClientID</TH>
                <TH>Date</TH>
            </TR>
        <% while(rs.next()){ %>
            <TR>
                <TD> <%= rs.getString(1) %></TD>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getString(3) %></TD>
                <TD> <%= rs.getString(4) %></TD>
                <TD> <%= rs.getString(5) %></TD>
                <TD> <%= rs.getString(6) %></TD>
                <TD> <%= rs.getString(7) %></TD>
            </TR>
         <% } %>
        </TABLE>
</body>
</html>


