const buttonModification=document.querySelector("#modifier");
const formulaire=document.querySelector("#formulaire");
const divs=document.querySelectorAll("#formulaire div");
const closeButton=document.querySelector("#closeButton");

buttonModification.addEventListener("click",(event)=>{
    formulaire.style.cssText="height:500px; opacity:1; pointer-events:all;" 

    for(let i=0;i<divs.length;i++){
        divs[i].style.opacity="1";
    }
})

closeButton.addEventListener("click",(event)=>{
   formulaire.style.cssText="height:0; opacity:0; pointer-events:none;" 
     
    for(let i=0;i<divs.length;i++){
        divs[i].style.opacity="0";
    }
})

