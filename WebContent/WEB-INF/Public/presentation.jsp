<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:useBean id= "club" class="entities.Club" scope="request" />        

	<jsp:setProperty name="club" property="*" />
<head>
<meta charset="UTF-8">
<title>Presentation de ${club.getName()}</title>


<link rel="stylesheet" href="./inc/css/header-footer.css">
<link rel="stylesheet" href="./inc/css/presentation/presentation.css">
<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	

</head>
<body onload="currentSlide(1)">
	
	
	
	<%@ include file="../header.jsp" %>
	<div class="container">
        <div class="content">
            <div class="cover">
                <img src='<c:url value="images/${club.getLogoPath()}"/>' class="logo">
                
                <button> Join Us</button>
            </div>
            <div class="presentation">
                <h1>Presentation</h1>
                <p>${club.getParagraphe()}</p>
            </div>
            <!-- Slideshow container -->
            <div class="slide" >
            <div class="slideshow-container">

                  <!-- Full-width images with number and caption text -->
                  <div class="mySlides fade">
                    <img src="images/${club.getImg1Path()}" style="width:100%;">
                  </div>

                 <div class="mySlides fade">
                    <img src="images/${club.getImg2Path()}" style="width:100%;">
                  </div>

                  <div class="mySlides fade">
                    <img src="images/${club.getImg3Path()}" style="width:100%;">
                  </div>

                  <!-- Next and previous buttons -->
                  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                  <a class="next" onclick="plusSlides(1)">&#10095;</a>
            </div>
            <br>

                <!-- The dots/circles -->
            <div style="text-align:center">
                <span class="dot" onclick="currentSlide(1)"></span>
                <span class="dot" onclick="currentSlide(2)"></span>
                <span class="dot" onclick="currentSlide(3)"></span>
            </div>
        </div>
        </div>
    </div>
	<%@ include file="../footer.jsp" %>
</body>
<script src="./inc/js/presentation/presentation.js"></script>
<script type="text/javascript" src="./inc/js/header.js"></script>
</html>