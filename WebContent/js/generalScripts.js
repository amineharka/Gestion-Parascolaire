
//drop down
let dropDown=document.querySelector(".dropDown");
let dropDownContainer=document.querySelector(".clubs");
let dropDownLi=document.querySelectorAll(".dropDown li");

//sticky navbar
window.addEventListener("scroll",()=>{
    let header=document.querySelector("header");
    header.classList.toggle("fixedHeader",window.scrollY>0);
    dropDown.classList.toggle("fixedDropDown",window.scrollY>0);
});

//add css properties to our dropdown when we mouseover it 
     dropDownContainer.addEventListener("mouseover",()=>{
     dropDown.classList.add("dropDownHover"); 
     dropDown.style.cssText="height:450px ; opcity:1;" 
     for(let i=0;i<dropDownLi.length;i++){
         dropDownLi[i].style.opacity="1";
     }
});

//Return 
dropDownContainer.addEventListener("mouseout",()=>{
    dropDown.classList.remove("dropDownHover");
    dropDown.style.cssText="height:0px; opcity:0;" 
    for(let i=0;i<dropDownLi.length;i++){
        dropDownLi[i].style.opacity="0";
    }
  
});

