
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestion d'activit�</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Responsable/creationActivite.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
 	
</head>
<body>
	<jsp:useBean id= "am" class="services.ActiviteManager" scope="request" />        

	<jsp:setProperty name="am" property="*" />
	
	<jsp:useBean id= "activite" class="entities.Activite" scope="request" />        

	<jsp:setProperty name="activite" property="*" />

    <%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
	
   <div id="container">
   
 		  <form id="activiteForm" method="post" action="modifierActivite" enctype="multipart/form-data">
	
	            <div class="text">
	                <label id="nom">Nom d'activit� :</label>
	                <input type="text" name="nom" value="${activite.getNom() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["nom"]}</span>
	            </div>
	            <div class="text">
	                <label id="description">Description :</label>
	                <textarea name="description">${activite.getDescription() }</textarea>
	                <span class="erreur" style="color:red">${am.getErreurs()["description"]}</span> 
	            </div>
	            <div class="text">
	                <label id="lieu">Lieu :</label>
	                <input type="text" name="lieu" value="${activite.getLieu() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["lieu"]}</span>
	            </div>
	            <div class="text">
	                <label id="date">Date :</label>
	                <input type="date" name="date" value="${activite.getDate().toString() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["date"]}</span>
	            </div>
	            <div class="radio ">
	            	<label>priv�/public</label>
	            	<div><label>Priv�</label><input type="radio" name="privee" value="true"></div>
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
				<div class="buttons">
					<button type="submit">Modifier</button>
					<a class="delete" href="supprimerActivite">Delete</a>
				</div>
	             
        </form>
        
   </div>  
        
     <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
</html>