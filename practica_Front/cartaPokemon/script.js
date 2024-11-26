

function reproducir(){
    var sonido = new Audio();
    sonido.src = "ash.mp3";
    sonido.play();
}

document.getElementById("imagen").addEventListener("click",reproducir);