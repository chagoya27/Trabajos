const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const error =0;



const expresiones = {
	usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^.{4,12}$/, // 4 a 12 digitos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	telefono: /^\d{7,14}$/ // 7 a 14 numeros.
}

const campos={
    usuario: false,
    nombre:false,
    password:false,
    correo:false,
    telefono:false
}


const validarFormulario = (e) => {
    switch(e.target.name){
        case "usuario":
            validarCampo(expresiones.usuario,e.target,'usuario');
        break;

        case "nombre":
            validarCampo(expresiones.nombre,e.target,'nombre');
        break;

        case "password":
            validarCampo(expresiones.usuario,e.target,'password');
            validarPass2();
        break;

        case "password2":
            validarPass2();
        break;

        case "correo":
            validarCampo(expresiones.correo,e.target,'correo');
        break;

        case "telefono":
            validarCampo(expresiones.telefono,e.target,'telefono');
        break;
    }
}


const validarCampo = (expresion,input,campo)=>{
    if(expresion.test(input.value)){
        document.getElementById(`formulario-${campo}`).classList.remove('formulario-grupo-incorrecto');
        document.getElementById(`formulario-${campo}`).classList.add('formulario-grupo-correcto');
        document.querySelector(`#formulario-${campo} i`).classList.remove('fa-circle-xmark');
        document.querySelector(`#formulario-${campo} i`).classList.add('fa-circle-check');
        document.querySelector(`#formulario-${campo} .formulario-input-error`).classList.remove('formulario-input-error-activo');
        campos[campo]= true;
    }else{
        document.getElementById(`formulario-${campo}`).classList.remove('formulario-grupo-correcto');
        document.getElementById(`formulario-${campo}`).classList.add('formulario-grupo-incorrecto');
        document.querySelector(`#formulario-${campo} i`).classList.remove('fa-circle-check');
        document.querySelector(`#formulario-${campo} i`).classList.add('fa-circle-xmark');
        document.querySelector(`#formulario-${campo} .formulario-input-error`).classList.add('formulario-input-error-activo');
        campos[campo]=false;
    }
}

const validarPass2 = ()=>{
    const inputPass1 = document.getElementById('password');
    const inputPass2 = document.getElementById('password2');
    if(inputPass1.value == inputPass2.value){
        document.getElementById('formulario-password2').classList.add('formulario-grupo-correcto');
        document.getElementById('formulario-password2').classList.remove('formulario-grupo-incorrecto');
        document.querySelector('#formulario-password2 i').classList.remove('fa-circle-xmark');
        document.querySelector('#formulario-password2 i').classList.add('fa-circle-check');
        document.querySelector('#formulario-password2 .formulario-input-error').classList.remove('formulario-input-error-activo');
        campos['password']= true;

    }else{
        document.getElementById('formulario-password2').classList.remove('formulario-grupo-correcto');
        document.getElementById('formulario-password2').classList.add('formulario-grupo-incorrecto');
        document.querySelector('#formulario-password2 i').classList.remove('fa-circle-check');
        document.querySelector('#formulario-password2 i').classList.add('fa-circle-xmark');
        document.querySelector('#formulario-password2 .formulario-input-error').classList.add('formulario-input-error-activo');
        campos['password']=false;
    }

}




inputs.forEach((input)=> {
    input.addEventListener('keyup',validarFormulario);
    input.addEventListener('blur',validarFormulario);
});


formulario.addEventListener('submit', (e)=>{
    e.preventDefault();

    const terminos = document.getElementById('terminos');

    if (campos.usuario && campos.nombre && campos.password && campos.correo && campos.telefono && terminos.checked){
        formulario.reset();
        document.getElementById('formulario-mensaje-exito').classList.add('formulario-mensaje-exito-activado');
        document.getElementById('formulario-mensaje').classList.remove('formulario-mensaje-activo');

    }else{
        document.getElementById('formulario-mensaje').classList.add('formulario-mensaje-activo');
        document.getElementById('formulario-mensaje-exito').classList.remove('formulario-mensaje-exito-activado');
    }

});



