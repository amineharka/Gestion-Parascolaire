<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Accueil</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/Accueil/accueil.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>

<body>

   	<%@ include file="../header.jsp" %>
   	
    <div class="container">

        <div class="Slider-images ">
                
                <img src="images/image1.jpeg">
           
                <img src="images/image2.jpeg">
                     
                <img src="images/image3.jpeg">
            
                <img src="images/image4.jpeg">
              
                <img src="images/image5.jpeg">

             
        </div>
        
        <div id="buttonLeft">&lt;</div>
        <div id="buttonRight">&gt;</div>

        <div id="circles">
            <div class="cercle"></div>
            <div class="cercle"></div>
            <div class="cercle"></div>
            <div class="cercle"></div>
            <div class="cercle"></div>
        </div>

        <div class="ourApp">
            <h1>Our Application</h1>
            <div>
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nobis maxime, eos, incidunt iste maiores ipsum ad soluta inventore eius veritatis voluptas. Dolorem, quidem saepe rerum labore temporibus quaerat libero voluptatum!
                Aliquam architecto tenetur, debitis doloremque unde facere harum! Ducimus veniam asperiores aspernatur placeat, nam voluptas commodi, debitis, eum quaerat ipsum velit iure expedita dolor non ipsa ratione! Quam, odio culpa?
                Qui perspiciatis earum nobis, provident rem laudantium amet harum dolor eos possimus architecto quo omnis minima corrupti magnam, culpa id numquam. Pariatur sit deleniti veniam. Quod facilis alias totam iusto?
                Officia nisi neque, eveniet ut repellat sed minima saepe sapiente veritatis repudiandae aspernatur veniam voluptas perferendis, facilis quae reiciendis nam quo beatae assumenda libero unde magni excepturi? Earum, quo non?
                Ex nemo itaque neque repudiandae quo sint minima voluptatum, optio labore mollitia, amet reiciendis consequatur minus natus. Molestias perspiciatis nulla deleniti cupiditate, quae fugit totam aperiam culpa, voluptatem quia vero.
                Ipsum dolor cumque dolorem perspiciatis, illo id cum fugit dicta reiciendis debitis vero architecto illum adipisci non, nostrum inventore fuga est consectetur facilis laudantium. Ipsum esse quos voluptatem quis officia.
                Quis officiis commodi impedit iusto, quasi nisi facilis ipsa accusamus inventore cumque temporibus repellat. Voluptatum, voluptate suscipit beatae harum quae assumenda ea sed, fugiat vel accusamus numquam tempora ipsum dignissimos?
                Blanditiis ratione incidunt, quis dolores impedit ducimus iure nam. Iste similique nostrum suscipit veritatis explicabo rerum tenetur non cum? Obcaecati dolores possimus dolorum nam similique sit numquam dicta iusto deleniti?
                Quam in harum quasi fugit voluptatum maxime, quibusdam maiores quae ullam praesentium officia? Blanditiis iure dignissimos, aut adipisci nostrum placeat? Sed exercitationem officia ullam vel quaerat. Adipisci nostrum incidunt atque!
                Ducimus corrupti maiores perferendis recusandae labore et? Harum non at laudantium beatae quidem qui incidunt nisi ab reprehenderit, consequuntur praesentium sint repellat id veritatis assumenda eaque maiores reiciendis laborum earum.
                Inventore animi, cupiditate nulla nobis consectetur itaque unde et adipisci. Facilis, minima! Aperiam tempora nisi, obcaecati facilis dolores minima fugit possimus repudiandae omnis suscipit ab nesciunt quia? Dolor, quas laborum.
                Voluptas, necessitatibus ut magnam, aspernatur quasi suscipit tempore assumenda nisi debitis cum itaque quod, cumque maxime! Eius pariatur tenetur molestias, ipsa illum hic, quos explicabo nulla amet sunt, odio labore.
            </div>
        </div>
    
    </div>
    <form  class="sticky" action="Accueil" method="POST">
        <div>Se connecter</div>
        <fieldset>
                <input type="email" name="email" autocomplete="off" placeholder="Email">
                <input type="password" name="password" placeholder="Mot de passe">
           
        </fieldset>
        <button type="submit" name="submit">Connexion</button>
        <div class="close">X</div>
    </form>
    
    <%@ include file="../footer.jsp" %>
    
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/Accueil/accueil.js"></script>
</html>