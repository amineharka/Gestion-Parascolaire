<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="supprimerActivite?id=1">Activité 1</a><br>
	<a href="supprimerActivite?id=2">Activité 2</a><br>
	<a href="supprimerActivite?id=3">Activité 3</a><br>
	<a href="supprimerActivite?id=4">Activité 4</a><br>
	<a href="supprimerActivite?id=5">Activité 5</a><br>
	
	<form method="post" action="creerPresentationClub">
		<input type="date" name="date" value="${sessionScope.date.toString() }"><br>
		<input type="submit" value="hello" value="Envoyer">
	</form>
	
</body>
</html>