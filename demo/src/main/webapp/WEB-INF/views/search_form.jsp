<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>BET FINDER BY GAME NAME, CLIENTID, DATE</title>
</head>
<body>
    <a href="/"><button type="button">HOME</button></a>
        <h1>Bet finder</h1>
            <form:form action="search" method="post" modelAttribute="bet">
                <form:label path="game">Game name:</form:label>
                <select name="game">
                <option value="roulette">Roulette</option>
                <option value="baccarat">Baccarat</option>
                <option value="blackjack">Blackjack</option>
                </select>
                <br/>
                <form:label path="clientid">Client Id:</form:label>
                <form:input path="clientid" value="1"/>
                <br/>
                <form:label path="date">Date of the bet:</form:label>
                <input type="date" name="date" value="2020-05-17" min="2020-01-01" max="2022-12-12">
                <br/>
                <form:button>Search</form:button>
            </form:form>
            
</body>
</html>