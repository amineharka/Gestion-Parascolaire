
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>creer Presentation de Club</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Responsable/presentationClub.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
 	
</head>
<body>
	<jsp:useBean id= "pm" class="services.PresentationManager" scope="request" />        

	<jsp:setProperty name="pm" property="*" />
	
	<jsp:useBean id= "club" class="entities.Club" scope="request" />        

	<jsp:setProperty name="club" property="*" />

    <%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
	
   <div id="container">
   
 		  <form id="presentationForm" method="post" action="modifierPresentation" enctype="multipart/form-data">
	
	            <div class="text">
	                <label id="description">Description :</label>
	                <textarea name="description" >${club.getDescription()}</textarea>
	                <span class="erreur" style="color:red">${pm.getErreurs()["description"]}</span>
	            </div>
	            <div class="text">
	                <label id="paragraphe">Paragraphe :</label>
	                <textarea name="paragraphe"> ${club.getParagraphe()} </textarea>
	                <span class="erreur" style="color:red">${pm.getErreurs()["paragraphe"]} </span> 
	            </div>
	            <div class = "imageContainer">       
	                <label class="logo images" for="logo">
	                    <span><i class="fas fa-images"></i></span> 
	                    ajouter logo
	                </label>
	                <input type="file" id="logo" name="logo" accept="image/*">
	                <span class="erreur" style="color:red">${pm.getErreurs()["logo"]} </span>
	            </div>
	            <div class = "imageContainer">
	                <label class="images" for="image1">
	                    <span><i class="fas fa-images"></i></span>    
	                    ajouter 1ere image
	                </label>  
	                <input type="file" id="image1" name="image1" accept="image/*">
	                <span class="erreur" style="color:red">${pm.getErreurs()["image1"]} </span>
	            </div>
	            <div class = "imageContainer">
	                <label class="images" for="image2">
	                <span><i class="fas fa-images"></i> </span> 
	                    ajouter 2eme image
	                </label>
	                <input type="file" id="image2" name="image2" accept="image/*">
	                <span class="erreur" style="color:red">${pm.getErreurs()["image2"]} </span>
	            </div>
	            <div class = "imageContainer">
	                <label class="images" for="image3">
	                    <span><i class="fas fa-images"></i>  </span> 
	                    ajouter 3eme image
	                </label>
	                <input type="file" id="image3" name="image3" accept="image/*">
	                <span class="erreur" style="color:red">${pm.getErreurs()["image3"]} </span>
	            </div>
	
	            <button type="submit">Créer</button> 
        </form>
        
   </div>  
        
     <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
</html>