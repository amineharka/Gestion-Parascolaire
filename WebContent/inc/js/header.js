//drop down
let dropDown=document.querySelector(".dropDown");
let dropDownContainer=document.querySelector(".clubs");
let dropDownLi=document.querySelectorAll(".dropDown li");

//add css properties to our dropdown when we mouseover it 
dropDownContainer.addEventListener("mouseover",()=>{
     dropDown.classList.add("dropDownHover"); 
     for(let i=0;i<dropDownLi.length;i++){
         dropDownLi[i].style.opacity="1";
     }
});

//Return 
dropDownContainer.addEventListener("mouseout",()=>{
    dropDown.classList.remove("dropDownHover");
    for(let i=0;i<dropDownLi.length;i++){
        dropDownLi[i].style.opacity="0";
    }
  
});
