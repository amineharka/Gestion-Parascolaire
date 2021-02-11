

//all the buttons
let buttons = document.querySelectorAll(".button");



//side-bar sub-menus
let subMenu = document.querySelectorAll(".sub-menu");
let arrows = document.querySelectorAll(".fa-caret-right");

//activités publiques sub-menu
let actPubElements = document.querySelectorAll(".act-pub");
let actPubMyClubsElements = document.querySelectorAll(".act-pub-my-clubs");
let actPubOtherClubsElements = document.querySelectorAll(".act-pub-other-clubs");

buttons[0].addEventListener("click", function(){
    subMenu[0].classList.toggle("open");
    subMenu[1].classList.remove("open");
    subMenu[2].classList.remove("open");
    for(let i=0; i<actPubElements.length; i++){
        actPubElements[i].classList.toggle("openn");
    }
    for(let i=0; i<actPubMyClubsElements.length; i++){
        actPubMyClubsElements[i].classList.remove("openn");
    }
    for(let i=0; i<actPubOtherClubsElements.length; i++){
        actPubOtherClubsElements[i].classList.remove("openn");
    }
    arrows[0].classList.toggle("rotated");
    arrows[1].classList.remove("rotated");
    arrows[2].classList.remove("rotated");
});

//activités publiques myclubs sub-menu
buttons[1].addEventListener("click", function(){
    subMenu[1].classList.toggle("open");
    for(let i=0; i<actPubMyClubsElements.length; i++){
        actPubMyClubsElements[i].classList.toggle("openn");
    }
    arrows[1].classList.toggle("rotated");
});

//activités publiques other clubs sub-menu
buttons[2].addEventListener("click", function(){
    subMenu[2].classList.toggle("open");
    for(let i=0; i<actPubOtherClubsElements.length; i++){
        actPubOtherClubsElements[i].classList.toggle("openn");
    }
    arrows[2].classList.toggle("rotated");
});




//activités privées sub-menu
let actPrvElements = document.querySelectorAll(".act-prv");
buttons[3].addEventListener("click", function(){
    subMenu[3].classList.toggle("open");
    for(let i=0; i<actPrvElements.length; i++){
        actPrvElements[i].classList.toggle("openn");
    }
    arrows[3].classList.toggle("rotated");
});


//my clubs sub-menu
let myClubsElements = document.querySelectorAll(".my-clubs");
buttons[4].addEventListener("click", function(){
    subMenu[4].classList.toggle("open");
    for(let i=0; i<myClubsElements.length; i++){
        myClubsElements[i].classList.toggle("openn");
    }
    arrows[4].classList.toggle("rotated");
});


//other clubs sub-menu
let otherClubsElements = document.querySelectorAll(".other-clubs");
buttons[5].addEventListener("click", function(){
    subMenu[5].classList.toggle("open");
    for(let i=0; i<otherClubsElements.length; i++){
        otherClubsElements[i].classList.toggle("openn");
    }
    arrows[5].classList.toggle("rotated");
});

