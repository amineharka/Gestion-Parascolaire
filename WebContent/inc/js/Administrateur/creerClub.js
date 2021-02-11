const clubsContainer=document.querySelector("#clubsContainer");
const creerButton=document.querySelector("#creerButton");
const addClubForm=document.querySelector("#addClub");
const container=document.querySelector(".container");
const closeAddForm=document.querySelector("#addClub .close");
const addClubButton=document.querySelector("#submitButton");

clubsContainer.addEventListener("click",(event)=>{
    
    if(event.target.tagName==="I"){
        let removeClub=event.target.parentElement;
        clubsContainer.removeChild(removeClub);
    }
});

creerButton.addEventListener("click",()=>{
    addClubForm.style.transform="translateY(0)";
    clubsContainer.style.filter="blur(15px)";
    clubsContainer.style.pointerEvents="none";
})

closeAddForm.addEventListener("click",()=>{
    addClubForm.style.transform="translateY(-100vh)";
    clubsContainer.style.filter="";
    clubsContainer.style.pointerEvents="";
})

addClubButton.addEventListener("click",()=>{
    const text=document.createTextNode(document.querySelector("#addClub input").value);
    const nouveauClub=document.createElement("div");
    nouveauClub.className="club";
    const clubName=document.createElement("p");
    clubName.appendChild(text);
    const deleteIcon=document.createElement("i");
    deleteIcon.className="fas fa-trash";
    nouveauClub.appendChild(clubName);
    nouveauClub.appendChild(deleteIcon);
    clubsContainer.insertBefore(nouveauClub,document.querySelector("#creerButton"));  

})
