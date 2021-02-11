
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
	                   <c:forEach var="club" items="${applicationScope.club}" >
                        <li><a href="#">
                        <c:out value="${ club.name }" />
                        </a></li>  
                      </c:forEach> 
	                  </ul>
	          </li>
	          <li><a href="#">Contact US</a></li>
	      </ul>
	      <div class="LogIn">
	          <a href="#">Se deconnecter</a>  
	      </div>
	</header>
	
