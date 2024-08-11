
function firstTest(){
    let pug = prompt("My Pug does not want to ask anything!");
    if(pug==="WHY"){
        alert("BECAUSE HE SAYS SO!")
    }
    else{
    alert("WRONG ANSWER KID");
    }
}

function changeBackgroundColor(){
    let change = prompt("Do you want new color or default color?")
    if(change === 'NEW'){
        alert('Myfav');
       document.body.style.backgroundColor = 'yellow';
    }
    else if(change === 'DEFAULT'){
        alert('TOO BAD!');
        document.body.style.backgroundColor = 'black';
    }
    else{
        alert('WRONG ANSWER!');
        document.body.style.backgroundColor = 'white';
    }
}