<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clubs Ensa</title>
    <link rel="stylesheet" href="./inc/css/Public/ListeClubs.css">
    <script src="https://kit.fontawesome.com/5bf11eee96.js" ></script>
</head>
<body>
    <header>
        <ul class="links">
            <li><a href="#">Acceuil</a></li>
            <li><a href="#">Notre Ecole</a></li>
            <li class="clubs" >
                    <a  href="#">Clubs</a>
                    <div>
                        <i class="fas fa-caret-down"></i>
                    </div>
                    <ul class="dropDown">
                     <c:forEach var="club" items="${clubs}" >
                        <li><a href="#">
                        <c:out value="${ club.name }" />
                        </a></li>  
                      </c:forEach>           
                    </ul>
            </li>
            <li><a href="#">Contact US</a></li>
        </ul>
        <div class="LogIn">
            <a href="#">Se connecter</a>
        </div>
    </header>
    <div class="container">
        
        <img class="image-ensa" src="images/imageensaa1.jpeg">
        
        <c:forEach var="club" items="${clubs}" >
            <section class="features">
                <figure>
                    <img src="images/enactus1.jpg">
                    <figcaption>
                        <c:out value="${ club.name }" />
                    </figcaption>
                    <div class="description">
                       <c:out value="${ club.description }" />
                     </div>
                </figure>
                </section>
         </c:forEach>

    
    </div>
    <footer>
        <div>
            <i class="fab fa-facebook-square"></i>
            <i class="fab fa-instagram"></i>
            <i class="fab fa-github"></i>
            <i class="fab fa-twitter"></i>
        </div>
 
    </footer>
</body>
<script type="text/javascript" src="./inc/js/Public/ListeClubs.js"></script>
</html>