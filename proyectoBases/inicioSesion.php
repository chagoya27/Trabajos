<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesFormulario.css">
    <link rel="stylesheet" href="stylesNavbar.css">
    <title>Xolot</title>
</head>
<body>
    
    <div class="contenido-Pagina">


        <div class="navbar">
            
            <div class="imgEmpresa">
                <img src="imagenes/Axolot.png" alt="Imagen icono Axolotl">
            </div>

            <div class="industria"> <h2>Axolotl</h2></div>
        </div>

        
        <div class="principal">

            <div class="contenedor">

                <header>
                    <h1>Inicio Sesion</h1>
                </header>
        
                <form action="inicioSesion.php" method="POST" class="formulario" id="formulario">
                    
                <?php

//Conexion a base de datos
$conn = oci_pconnect("alu_318218814", "CHAG3182_", "//132.248.59.32/oralab01.fi.unam.mx");

if (!$conn) {
    $e = oci_error();
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
    oci_close($conn);
}

try {
    if (isset($_POST['correo'])) {
        $correo = isset($_POST['correo']) ? $_POST['correo'] : "";
        $contrasegna = isset($_POST['contrasegna']) ? $_POST['contrasegna'] : "";
    } else {
        $correo = 'Introduce@Correo';
        $contrasegna = 'Contraseña';
    }

    $campos = array();
    if ($correo == "" || strpos($correo, "@") === false) {
        array_push($campos, "Ingrese un correo electrónico válido");
    }

    if ($contrasegna == "") {
        array_push($campos, "El campo contraseña no puede estar vacío");
    }

    if (count($campos) > 0) {
        echo "<div class='error'>";
        for ($i = 0; $i < count($campos); $i++) {
            echo "<li>" . $campos[$i] . "</li>";
        }
        echo "</div>";
    } else {

        //sentencia sql para recuperar el correo y la contraseña del usuario
        $sql = 'SELECT CORREO,CONTRASEGNA FROM USUARIO';
        $verificador = 0; //ayudara a saber si es que los datos de la base concuerdan
                            //con las credenciales que el usuario mostro

        //variables para almacenar el correo y la contraseña de la base de datos
        $correoBase ='';
        $contrasegnaBase='';
        // Preparar la sentencia utilizando $conn en lugar de $conexion
        $stid = oci_parse($conn, $sql);

        if (!$stid) {
            $e = oci_error($conn);
            trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
        }

        // Ejecutar la sentencia
        oci_execute($stid);
        
        
        // El ciclo recupera los datos de la base y verifica con lo que se escribio
        //en los respectivos inputs
        while ( ($fila = oci_fetch_assoc($stid)) !==false  and $verificador==0) {
                //imprime los datos
                //echo 'Correo: ' . $fila["CORREO"] . '<br>';
                //echo 'Contrasegna: ' . $fila["CONTRASEGNA"] . '<br>';

                $correoBase = $fila ["CORREO"];
                $contrasegnaBase = $fila["CONTRASEGNA"];

                if ($_SERVER["REQUEST_METHOD"] == "POST") {
                    // Obtiene el valor del input enviado desde el formulario
                    $inputCorreo = $_POST["correo"];
                    $inputContrasegna = $_POST["contrasegna"];

                    //si entra en este if es que se encontro el usuario en la base de datos
                    if($correoBase===$inputCorreo && $contrasegnaBase=== $inputContrasegna){
                        echo "El usuario se encuentra en la base de datos";
                        $verificador =1;
                    }
                }
        }

        if($verificador ==0){
            echo "<div class='error'>";
            echo "Lo sentimos el usuario no se encuentra en la base de datos";
            echo "</div>";
        }    
        oci_close($conn);
    }
} finally {
    // Cerrar la conexión en el bloque finally asegurará que se cierre incluso si hay una excepción
    oci_close($conn);
}

?>

                <div class="contenedor-inputs">
                        <input type="text" id="correo" name="correo" placeholder="Introduce tu correo" value="<?php echo $correo; ?>">
                        <input type="password" name="contrasegna" placeholder="Introduce tu contraseña" value="<?php echo $contrasegna; ?>">
                        <input type="submit" class="btn" value="Iniciar" id="botonR">
                </div>

                </form>
            </div>
        </div>
    </div>
</body>
</html>