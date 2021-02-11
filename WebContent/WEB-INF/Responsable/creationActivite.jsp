
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>creation d'activité</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Responsable/creationActivite.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
 	
</head>
<body>
	<jsp:useBean id= "am" class="services.ActiviteManager" scope="request" />        

	<jsp:setProperty name="am" property="*" />

    <%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
	
   <div id="container">
   
 		  <form id="activiteForm" method="post" action="ajouterActivite" enctype="multipart/form-data">
	
	            <div class="text">
	                <label id="nom">Nom d'activité :</label>
	                <input type="text" name="nom" value="${am.getActivite().getNom() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["nom"]}</span>
	            </div>
	            <div class="text">
	                <label id="description">Description :</label>
	                <textarea name="description">${am.getActivite().getDescription() }</textarea>
	                <span class="erreur" style="color:red">${am.getErreurs()["description"]}</span> 
	            </div>
	            <div class="text">
	                <label id="lieu">Lieu :</label>
	                <input type="text" name="lieu" value="${am.getActivite().getLieu() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["lieu"]}</span>
	            </div>
	            <div class="text">
	                <label id="date">Date :</label>
	                <input type="date" name="date" value="${am.getActivite().getDate().toString() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["date"]}</span>
	            </div>
	            <div class="radio ">
	            	<label>privé/public</label>
	            	<div><label>Privé</label><input type="radio" name="privee" value="true"></div>
	            	<div><label>Public</label><input type="radio" name="privee" value="false"></div>
	            	<span class="erreur" style="color:red">${am.getErreurs()["privee"]}</span>
	            </div>
	            <div>
	                <label class="images" for="image">
	                <span><i class="fas fa-images"></i> </span> 
	                    ajouter une image
	                </label>
	                <input type="file" id="image" name="image" accept="image/*">
	                <span class="erreur" style="color:red">${am.getErreurs()["image"]} </span>
	            </div>
	
	            <button type="submit">Créer</button> 
        </form>
        
   </div>  
        
     <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
</html>