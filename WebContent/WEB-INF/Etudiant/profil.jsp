
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profil Étudiant</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Etudiant/profil.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

	<%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
    
    <div id="container">
        
        <div id="Infos">
            <div id="profil">
                <h1>${sessionScope.etd.prenom } ${sessionScope.etd.nom }</h1>
                <div class="row">
                    <div>                 
                        <span>CNE:</span> ${sessionScope.etd.cne }
                    </div>
                    <div>
                       <span>Filiere:</span> ${sessionScope.etd.filiere }
                    </div>
                </div>
                <div class="row">
                    <div>
                       <span> Pays:</span> ${sessionScope.etd.pays }
                    </div>
                    <div>
                       <span>Ville:</span> ${sessionScope.etd.ville }
                    </div>
                </div>
                <button id="modifier">Modifier</button>
            </div>
            
            
         	<c:choose >
         		<c:when test="${!empty form}">
         			<c:set var="isFormEmpty" scope="request" value="false"/>
         		</c:when>
         		<c:otherwise>
         			<c:set var="isFormEmpty" scope="request" value="true"/>
         		</c:otherwise>
         	</c:choose>
         	
         	
            <form id="formulaire" <c:if test="${!isFormEmpty }">style="height: 500px; opacity: 1; pointer-events: all;"</c:if> method="POST" action="Profil">
                <p id="closeButton">x</p>
                <p>Modifier le profil:</p>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Nom:</label>
                    <input type="text" name="nom" autocomplete="off" value="${sessionScope.etd.nom }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Prenom:</label>
                    <input type="text" name="prenom" autocomplete="off" value="${sessionScope.etd.prenom }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>CNE:</label>
                    <input type="text" name="cne" autocomplete="off" value="${sessionScope.etd.cne }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Filiere:</label>
                    <input type="text" name="filiere" autocomplete="off" value="${sessionScope.etd.filiere }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Pays:</label>
                    <input type="text" name="pays" autocomplete="off" value="${sessionScope.etd.pays }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Ville:</label>
                    <input type="text" name="ville" autocomplete="off" value="${sessionScope.etd.ville }">
                </div>
                <button id="formSubmit">Confirmer</button>
                <c:if test="${!isFormEmpty }">
                	<br/>
                	<div style="opacity: 1;"><p style="margin: auto;">${form.result }</p></div>
    			</c:if>
            </form>
        </div>     


    </div>



    <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Etudiant/profil.js"></script>
</html>