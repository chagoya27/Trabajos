

btnNaranja = document.getElementById('naranja');
btnAzul = document.getElementById('azul');
btnRosa = document.getElementById('rosa');



function cambioNaranja(){ 
    /*seleccionamos el circulo*/
    document.querySelector('.header .circle').classList.remove('azul');
    document.querySelector('.header .circle').classList.remove('rosa');
    document.querySelector('.header .circle').classList.add('naranja');

    /*seleccionamos la imagen*/
    document.querySelector('.header .image').classList.remove('imageAzul');
    document.querySelector('.header .image').classList.remove('imageRosa');
    document.querySelector('.header .image').classList.add('imageNaranja');

    /*seleccionamos el boton*/
    document.querySelector('.buy .btn').classList.remove('btn-azul');
    document.querySelector('.buy .btn').classList.remove('btn-rosa');
    document.querySelector('.buy .btn').classList.add('btn-naranja');
}

function cambioAzul(){
    /*seleccionamos el circulo*/
    document.querySelector('.header .circle').classList.remove('naranja');
    document.querySelector('.header .circle').classList.remove('rosa');
    document.querySelector('.header .circle').classList.add('azul');

    /*seleccionamos la imagen*/
    document.querySelector('.header .image').classList.remove('imageNaranja');
    document.querySelector('.header .image').classList.remove('imageRosa');
    document.querySelector('.header .image').classList.add('imageAzul');

    /*seleccionamos el boton*/
    document.querySelector('.buy .btn').classList.remove('btn-naranja');
    document.querySelector('.buy .btn').classList.remove('btn-rosa');
    document.querySelector('.buy .btn').classList.add('btn-azul');
}


function cambioRosa(){
    /*seleccionamos el circulo*/
    document.querySelector('.header .circle').classList.remove('naranja');
    document.querySelector('.header .circle').classList.remove('azul');
    document.querySelector('.header .circle').classList.add('rosa');

    /*seleccionamos la imagen*/
    document.querySelector('.header .image').classList.remove('imageNaranja');
    document.querySelector('.header .image').classList.remove('imageAzul');
    document.querySelector('.header .image').classList.add('imageRosa');

    /*seleccionamos el boton*/
    document.querySelector('.buy .btn').classList.remove('btn-azul');
    document.querySelector('.buy .btn').classList.remove('btn-naranja');
    document.querySelector('.buy .btn').classList.add('btn-rosa');
}


btnNaranja.addEventListener('click',cambioNaranja);
btnAzul.addEventListener('click',cambioAzul);
btnRosa.addEventListener('click',cambioRosa);
