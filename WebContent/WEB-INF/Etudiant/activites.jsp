
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profil Étudiant</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Etudiant/activites.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

	<%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
    
    <div id="container">
        
        <div class="activites">
        	<c:forEach items="${activites }" var="activite">
        		<div class="activite">
	        		<div class="row">
	        			<span>Club :</span>
	        			<span>${activite.club.name }</span>
	        		</div>
	        		<div class="row">
	        			<span>Nom :</span>
	        			<span>${activite.nom }</span>
	        		</div>
	        		<div class="row">
	        			<span>Description :</span>
	        			<span>${activite.description }</span>
	        		</div>
	        		<div class="row">
	        			<span>Date :</span>
	        			<span>${activite.date }</span>
	        		</div>
	        		<div class="row">
	        			<span>Lieu :</span>
	        			<span>${activite.lieu }</span>
	        		</div>
	        		<div class="row">
	        			<span>Privée :</span>
	        			<span>${activite.privee }</span>
	        		</div>
	        	</div>
        	</c:forEach>
        	
        	<c:if test="${!empty result }">
        		<div class="result">
        			<h1>${result }</h1>
        		</div>
        	</c:if>

        
        </div>


    </div>



    <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Etudiant/activites.js"></script>
</html>